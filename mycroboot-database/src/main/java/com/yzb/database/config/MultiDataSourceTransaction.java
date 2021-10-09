package com.yzb.database.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
public class MultiDataSourceTransaction implements Transaction {//多数据源事物
    private DataSource dataSource;//当前数据源
    private boolean autoCommit;//是否自动提交
    private boolean isConnectionTransaction;//是否支持事物
    private Connection currentConnect;//当前连接
    private ConcurrentMap<String, Connection> otherConnect;//其他连接
    private String databaseName;//数据库名字

    public MultiDataSourceTransaction(DataSource dataSource) {
        this.dataSource = dataSource;
        this.otherConnect = new ConcurrentHashMap<>();
        this.databaseName = DynamicDataSource.getDataSource();
    }

    //通过DataSource获取相关的连接
    private void openConnection() throws SQLException {
        this.currentConnect = DataSourceUtils.getConnection(dataSource);//获取连接
        this.autoCommit = this.currentConnect.getAutoCommit();//获取当前自动提交的状态
        this.isConnectionTransaction = DataSourceUtils.isConnectionTransactional(this.currentConnect, dataSource);//是否支持事物
        log.info("当前的数据库提交状态{}，当前连接是否支持事物{}", this.autoCommit, this.isConnectionTransaction);
    }

    @Override
    public Connection getConnection() throws SQLException {//获取连接
        String dataSourceName = DynamicDataSource.getDataSource();
        if (dataSourceName != null && dataSourceName.equals(this.databaseName)) {//现在的数据库为当前使用的数据库
            if (this.currentConnect == null) { //此时没有提供连接
                this.databaseName = dataSourceName;
                openConnection();//打开连接
            }
            return this.currentConnect;
        }
        //如果当前的数据库不是现在使用的数据库
        if (!otherConnect.containsKey(dataSourceName)) {//没有当前数据源的名称存在
            Connection connection = DataSourceUtils.getConnection(dataSource);
            otherConnect.put(dataSourceName, connection);
        }
        return otherConnect.get(dataSourceName);
    }

    @Override
    public void commit() throws SQLException {//提交事物
        //如果此时有连接，并且不支持事物处理，而且支持自动提交处理
        if (currentConnect != null && !this.isConnectionTransaction && this.autoCommit) {
            this.currentConnect.commit();
            for (Connection connection : otherConnect.values()) {
                connection.commit();
            }
        }
    }

    @Override
    public void rollback() throws SQLException {//回滚
        //如果此时有连接，并且不支持事物处理，而且支持自动提交处理
        if (currentConnect != null && !this.isConnectionTransaction && this.autoCommit) {
            this.currentConnect.rollback();
            for (Connection connection : otherConnect.values()) {
                connection.rollback();
            }
        }
    }

    @Override
    public void close() throws SQLException {//关闭
        if (currentConnect != null) {
            DataSourceUtils.releaseConnection(currentConnect, dataSource);
            for (Connection connection : otherConnect.values()) {
                DataSourceUtils.releaseConnection(connection, dataSource);
            }
        }
    }

    @Override
    public Integer getTimeout() throws SQLException {//超时时间
        return 500;
    }
}
