package com.yzb.database.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: DruidDataSourceConfiguration
 * Description:
 * date: 2021/10/3 15:10
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class DruidDataSourceConfiguration {

    @Bean("yzbDriDruidDataSource")
    public DruidDataSource getYzbDriDruidDataSource(
            @Value("${spring.mybatisReview.datasource.driver-class-name}")
                    String driverClassName, // 数据库驱动程序
            @Value("${spring.mybatisReview.datasource.url}")
                    String url, // 数据库连接地址
            @Value("${spring.mybatisReview.datasource.username}")
                    String username, // 数据库的用户名
            @Value("${spring.mybatisReview.datasource.password}")
                    String password, // 数据库的用户名
            @Value("${spring.mybatisReview.datasource.druid.initial-size}")
                    int initialSize, // 初始化连接数
            @Value("${spring.mybatisReview.datasource.druid.min-idle}")
                    int minIdle, // 最小维持连接数
            @Value("${spring.mybatisReview.datasource.druid.max-active}")
                    int maxActive, // 最大连接数
            @Value("${spring.mybatisReview.datasource.druid.max-wait}")
                    long maxWait, // 最长等待时间
            @Value("${spring.mybatisReview.datasource.druid.time-between-eviction-runs-millis}")
                    long timeBetweenEvictionRunsMillis, // 关闭空闲连接间隔
            @Value("${spring.mybatisReview.datasource.druid.min-evictable-idle-time-millis}")
                    long minEvictableIdleTimeMillis, // 最小存活时间
            @Value("${spring.mybatisReview.datasource.druid.validation-query}")
                    String validationQuery, // 验证查询
            @Value("${spring.mybatisReview.datasource.druid.test-while-idle}")
                    boolean testWhileIdle, // 测试空闲连接是否可用
            @Value("${spring.mybatisReview.datasource.druid.test-on-borrow}")
                    boolean testOnBorrow, // 测试后返回连接
            @Value("${spring.mybatisReview.datasource.druid.test-on-return}")
                    boolean testOnReturn, // 测试后归还
            @Autowired StatFilter statFilter,//注入SQL监控
            @Autowired WallFilter wallFilter//注入SQL防火墙
    ) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName); // 数据库驱动程序
        dataSource.setUrl(url); // 数据库的连接地址
        dataSource.setUsername(username); // 数据库用户名
        dataSource.setPassword(password); // 数据库密码
        dataSource.setInitialSize(initialSize); // 连接池初始化大小
        dataSource.setMinIdle(minIdle); // 最小维持的连接数量
        dataSource.setMaxActive(maxActive); // 最大的连接数量
        dataSource.setMaxWait(maxWait); // 最大等待时间
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis); // 检查的间隔时间
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis); // 存活时间
        dataSource.setValidationQuery(validationQuery); // 验证SQL
        dataSource.setTestWhileIdle(testWhileIdle); // 测试连接是否可用
        dataSource.setTestOnBorrow(testOnBorrow); // 获取时检测
        dataSource.setTestOnReturn(testOnReturn); // 归还时检测

        List<Filter> filters = new ArrayList<>();//设置所有可能存在的监控项
        filters.add(statFilter);
        filters.add(wallFilter);//将SQL防火墙加入
        dataSource.setProxyFilters(filters);

        return dataSource;
    }

}
