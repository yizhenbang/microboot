package com.yzb.database.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: DynamicDataSourceConfiguration
 * Description:
 * date: 2021/10/6 19:21
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Configuration
public class DynamicDataSourceConfiguration {

    @Bean("dataSource")
    @Primary //注入DataSource的时候优先此配置
    @DependsOn({"druidYzbDataSource", "druidTESTDataSource"})
    public DataSource setDataSource(
            @Autowired DataSource druidYzbDataSource,
            @Autowired DataSource druidTESTDataSource
    ) {
        Map<Object, Object> map = new HashMap(5);
        map.put(DynamicDataSource.DataSourceNames.YZB_DATASOURCE, druidYzbDataSource);
        map.put(DynamicDataSource.DataSourceNames.TEST_DATASOURCE, druidTESTDataSource);
        return new DynamicDataSource(druidYzbDataSource, map);//将 druidYzbDataSource 设置为默认数据源
    }

}
