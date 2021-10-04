package com.yzb.database.config;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: DruidLogConfiguration
 * Description:
 * date: 2021/10/4 19:30
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class DruidLogConfiguration {

    @Bean("logFilter")
    public Slf4jLogFilter getSlf4jLogFilter() {
        Slf4jLogFilter slf4jLogFilter = new Slf4jLogFilter();
        slf4jLogFilter.setDataSourceLogEnabled(true);//启用数据库日志
        slf4jLogFilter.setStatementExecutableSqlLogEnable(true);//记录执行日志
        return slf4jLogFilter;
    }

}
