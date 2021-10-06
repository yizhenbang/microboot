package com.yzb.database.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * ClassName: JDBCTemplateConfiguration
 * Description:
 * date: 2021/10/4 13:03
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
//@Configuration
public class JDBCTemplateConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean("jdbcTemplate")
    public JdbcTemplate getJDBCTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);//设置数据源
        return jdbcTemplate;
    }

}
