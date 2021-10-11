package com.yzb.database.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * ClassName: DruidXADataSourceConfig
 * Description:
 * date: 2021/10/8 15:57
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class DruidXADataSourceConfig {

    //因为在配置文件中分为三个板块进行配置
    private static final String YZB_DATABASE_DRUID_PREFIX = "spring.datasource.yzb.";//yzb数据库连接前缀
    private static final String TEST_DATABASE_DRUID_PREFIX = "spring.datasource.yzhenb.";//yzhenb数据库连接前缀
    private static final String DRUID_POOL_PREFIX = "spring.datasource.druid.";//druid

    @Bean("druidYzbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.yzb")
    public DataSource getYzbDruidXADataSource(@Autowired Environment environment) {
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setUniqueResourceName("yzb");//设置资源名字
        atomikosDataSourceBean.setXaDataSourceClassName(environment.getProperty(YZB_DATABASE_DRUID_PREFIX + "type"));//设置数据源类型名字
        atomikosDataSourceBean.setXaProperties(build(environment, YZB_DATABASE_DRUID_PREFIX, DRUID_POOL_PREFIX));//相关属性
        return atomikosDataSourceBean;
    }

    @Bean("druidTESTDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.yzhenb")
    public DataSource getTESTDruidXADataSource(@Autowired Environment environment) {
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setUniqueResourceName("test");//设置资源名字
        atomikosDataSourceBean.setXaDataSourceClassName(environment.getProperty(TEST_DATABASE_DRUID_PREFIX + "type"));//设置数据源类型名字
        atomikosDataSourceBean.setXaProperties(build(environment, TEST_DATABASE_DRUID_PREFIX, DRUID_POOL_PREFIX));//相关属性
        return atomikosDataSourceBean;
    }

    private Properties build(Environment env, String databasePrefix, String druidPrefix) {
        Properties prop = new Properties();
        prop.put("url", env.getProperty(databasePrefix + "url"));
        prop.put("username", env.getProperty(databasePrefix + "username"));
        prop.put("password", env.getProperty(databasePrefix + "password"));
        prop.put("driverClassName", env.getProperty(
                databasePrefix + "driverClassName", ""));
        prop.put("initialSize", env.getProperty(
                druidPrefix + "initial-size", Integer.class));
        prop.put("maxActive", env.getProperty(druidPrefix + "max-active", Integer.class));
        prop.put("minIdle", env.getProperty(druidPrefix + "min-idle", Integer.class));
        prop.put("maxWait", env.getProperty(druidPrefix + "max-wait", Integer.class));
        prop.put("poolPreparedStatements", env.getProperty(
                druidPrefix + "pool-prepared-statements", Boolean.class));
        prop.put("maxPoolPreparedStatementPerConnectionSize",
                env.getProperty(druidPrefix +
                        "max-pool-prepared-statement-per-connection-size", Integer.class));
        prop.put("maxPoolPreparedStatementPerConnectionSize",
                env.getProperty(druidPrefix +
                        "max-pool-prepared-statement-per-connection-size", Integer.class));
        prop.put("validationQuery", env.getProperty(druidPrefix + "validation-query"));
        prop.put("testOnBorrow", env.getProperty(
                druidPrefix + "test-on-borrow", Boolean.class));
        prop.put("testOnReturn", env.getProperty(
                druidPrefix + "test-on-return", Boolean.class));
        prop.put("testWhileIdle", env.getProperty(
                druidPrefix + "test-while-idle", Boolean.class));
        prop.put("timeBetweenEvictionRunsMillis",
                env.getProperty(druidPrefix +
                        "time-between-eviction-runs-millis", Integer.class));
        prop.put("minEvictableIdleTimeMillis", env.getProperty(druidPrefix +
                "min-evictable-idle-time-millis", Integer.class));
        return prop;
    }


}
