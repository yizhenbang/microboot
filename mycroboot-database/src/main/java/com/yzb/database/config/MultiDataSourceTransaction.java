package com.yzb.database.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MultiDataSourceTransaction implements Transaction {//多数据源事物
    // private DataSource dataSource;//当前数据源
    // private boolean autoCommit;//是否自动提交
    // private boolean isConnectionTransaction;//是否支持事物
    // private Connection currentConnect;//当前连接
    // private ConcurrentMap<String, Connection> otherConnect;//其他连接
    // private String databaseName;//数据库名字
    //
    // public MultiDataSourceTransaction(DataSource dataSource) {
    //     this.dataSource = dataSource;
    //     this.otherConnect = new ConcurrentHashMap<>();
    //     this.databaseName = DynamicDataSource.getDataSource();
    // }
    //
    // //通过DataSource获取相关的连接
    // private void openConnection() throws SQLException {
    //     this.currentConnect = DataSourceUtils.getConnection(dataSource);//获取连接
    //     this.autoCommit = this.currentConnect.getAutoCommit();//获取当前自动提交的状态
    //     this.isConnectionTransaction = DataSourceUtils.isConnectionTransactional(this.currentConnect, dataSource);//是否支持事物
    //     log.info("当前的数据库提交状态{}，当前连接是否支持事物{}", this.autoCommit, this.isConnectionTransaction);
    // }
    //
    // @Override
    // public Connection getConnection() throws SQLException {//获取连接
    //     String dataSourceName = DynamicDataSource.getDataSource();
    //     log.info("当前数据源名称：{}", dataSourceName);
    //
    //     if (null == dataSourceName || dataSourceName.equals(this.databaseName)) {
    //         // if (dataSourceName != null && dataSourceName.equals(this.databaseName)) {//现在的数据库为当前使用的数据库
    //         if (this.currentConnect == null) { //此时没有提供连接
    //             this.databaseName = dataSourceName;
    //             openConnection();//打开连接
    //         }
    //         return this.currentConnect;
    //     }
    //
    //     //如果当前的数据库不是现在使用的数据库
    //     if (!otherConnect.containsKey(dataSourceName)) {//没有当前数据源的名称存在
    //         Connection connection = DataSourceUtils.getConnection(dataSource);
    //         otherConnect.put(dataSourceName, connection);
    //     }
    //     return otherConnect.get(dataSourceName);
    // }
    //
    // @Override
    // public void commit() throws SQLException {//提交事物
    //     log.error("commit：currentConnection = {}、isConnectionTransactional = {}、autoCommit = {}", this.currentConnect, this.isConnectionTransaction, this.autoCommit);
    //     //如果此时有连接，并且不支持事物处理，而且支持自动提交处理
    //     //当支持自动提交的时候不能调用commit
    //     if (currentConnect != null && !this.isConnectionTransaction && !this.autoCommit) {
    //         log.info("数据库事务提交，当前数据库连接：{}", this.currentConnect);
    //         this.currentConnect.commit();
    //         for (Connection connection : otherConnect.values()) {
    //             connection.commit();
    //         }
    //     }
    // }
    //
    // @Override
    // public void rollback() throws SQLException {//回滚
    //     //如果此时有连接，并且不支持事物处理，而且支持自动提交处理
    //     if (currentConnect != null && !this.isConnectionTransaction && !this.autoCommit) {
    //         log.info("数据库事务回滚，当前数据库连接：{}", this.currentConnect);
    //         this.currentConnect.rollback();
    //         for (Connection connection : otherConnect.values()) {
    //             connection.rollback();
    //         }
    //     }
    // }
    //
    // @Override
    // public void close() throws SQLException {//关闭
    //     if (currentConnect != null) {
    //         DataSourceUtils.releaseConnection(currentConnect, dataSource);
    //         for (Connection connection : otherConnect.values()) {
    //             DataSourceUtils.releaseConnection(connection, dataSource);
    //         }
    //     }
    // }
    //
    // @Override
    // public Integer getTimeout() throws SQLException {//超时时间
    //     log.error("【事物超时】当前数据源：{}，当前数据库连接：{}", DynamicDataSource.getDataSource(), this.currentConnect);
    //     return 3000;
    // }
    private DataSource dataSource; // 事务是需要有DataSource支持
    private Connection currentConnection; // 当前的数据库连接
    private boolean autoCommit; // 是否要进行自动提交启用
    private boolean isConnectionTransactional; // 是否要启用事务
    private ConcurrentHashMap<String, Connection> otherConnectionMap; // 保存其他的Connection对象
    private String currentDatabaseName; // 当前数据库名称

    public MultiDataSourceTransaction(DataSource dataSource) {
        this.dataSource = dataSource; // 保存数据元
        this.otherConnectionMap = new ConcurrentHashMap<>(); // 保存其他数据库连接
        this.currentDatabaseName = DynamicDataSource.getDataSource(); // 获取当前操作的数据库名称
    }

    private void openMainConnection() throws SQLException { // 打开一个连接
        // 通过当前得到的DataSource接口实例来获取一个Connection接口实例
        this.currentConnection = DataSourceUtils.getConnection(this.dataSource);
        this.autoCommit = this.currentConnection.getAutoCommit(); // 获取当前的是否自动提交的状态
        this.isConnectionTransactional = DataSourceUtils.isConnectionTransactional(this.currentConnection, this.dataSource);
        log.info("当前数据库连接：{}、事务支持状态：{}。", this.currentConnection, this.isConnectionTransactional);
    }

    @Override
    public Connection getConnection() throws SQLException { // 获取数据库连接
        // 存在有数据源的前提下才可以实现连接的获取，那么首先要判断是否有数据源存在
        String datasourceName = DynamicDataSource.getDataSource(); // 获取当前数据源名称
        log.info("【MultiDataSourceTransaction.getConnection()】数据源名称：{}", datasourceName);
        if (null == datasourceName || datasourceName.equals(this.currentDatabaseName)) {    // 现在的数据源为当前使用的数据库
            if (this.currentConnection != null) {   // 当前存在有数据库连接
                return this.currentConnection; // 返回当前的连接
            } else {    // 如果当前的数据源没有开启过连接
                openMainConnection(); // 开启一个数据库连接
                this.currentDatabaseName = datasourceName; // 保存当前的数据库名称
                return this.currentConnection; // 返回当前的连接
            }
        } else {    // 没有连接
            if (!this.otherConnectionMap.containsKey(datasourceName)) { // 没有当前这个数据源的名称存在
                Connection conn = dataSource.getConnection(); // 获取数据库连接
                this.otherConnectionMap.put(datasourceName, conn); // 保存连接
            }
            return this.otherConnectionMap.get(datasourceName);
        }
    }

    @Override
    public void commit() throws SQLException { // 数据库事务提交
        log.error("commit：currentConnection = {}、isConnectionTransactional = {}、autoCommit = {}", this.currentConnection, this.isConnectionTransactional, this.autoCommit);
        // 当前存在有Connection接口实例，同时没有开启自动的事务提交，并且存在有支持事务的连接
        if (this.currentConnection != null && !this.isConnectionTransactional && !this.autoCommit) {
            log.info("数据库事务提交，当前数据库连接：{}", this.currentConnection);
            this.currentConnection.commit(); // 提交当前的数据库事务
            for (Connection connecion : this.otherConnectionMap.values()) { // 控制其它的数据库连接
                connecion.commit(); // 保证其他的连接提交事务
            }
        }
    }

    @Override
    public void rollback() throws SQLException { // 事务回滚
        log.error("rollback：currentConnection = {}、isConnectionTransactional = {}、autoCommit = {}", this.currentConnection, this.isConnectionTransactional, this.autoCommit);
        if (this.currentConnection != null && !this.isConnectionTransactional && !this.autoCommit) {
            log.info("数据库事务回滚，当前数据库连接：{}", this.currentConnection);
            this.currentConnection.rollback(); // 回滚当前的数据库事务
            for (Connection connecion : this.otherConnectionMap.values()) { // 控制其它的数据库连接
                connecion.rollback(); // 保证其他的连接提交回滚
            }
        }
    }

    @Override
    public void close() throws SQLException { // 事务关闭
        DataSourceUtils.releaseConnection(this.currentConnection, this.dataSource);
        for (Connection connecion : this.otherConnectionMap.values()) { // 控制其它的数据库连接
            DataSourceUtils.releaseConnection(connecion, this.dataSource);
        }
    }

    @Override
    public Integer getTimeout() throws SQLException { // 超时配置
        return 500;
    }
}
