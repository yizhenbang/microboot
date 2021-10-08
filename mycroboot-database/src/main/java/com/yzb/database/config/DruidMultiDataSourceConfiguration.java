package com.yzb.database.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * ClassName: DruidMultiDataSourceConfiguration
 * Description:
 * date: 2021/10/5 21:30
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
// @Configuration
public class DruidMultiDataSourceConfiguration {

    // @Bean("druidYzbDataSource")
    // @ConfigurationProperties(prefix = "spring.datasource.yzb")
    public DataSource yzbDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    // @Bean("druidTestDataSource")
    // @ConfigurationProperties(prefix = "spring.datasource.yzhenb")
    public DataSource testDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

}
