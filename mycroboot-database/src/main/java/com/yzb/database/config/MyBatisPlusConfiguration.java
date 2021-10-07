package com.yzb.database.config;

import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * ClassName: MyBatisPlusConfiguration
 * Description:
 * date: 2021/10/5 15:53
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class MyBatisPlusConfiguration {

    @Autowired
    private ResourcePatternResolver resourcePatternResolver;

    @Bean("mybatisSqlSessionFactoryBean")
    public MybatisSqlSessionFactoryBean getMybatisSqlSessionFactoryBean(
            @Autowired DataSource dataSource,
            @Value("${mybatis-plus.config-location}") Resource configLocation,
            @Value("${mybatis-plus.mapper-locations}") String mapperLocation,
            @Value("${mybatis-plus.type-aliases-package}") String typeAliasesPackage,
            @Value("${mybatis-plus.global-config.db-config.logic-delete-value}") String logicDeleteValue,
            @Value("${mybatis-plus.global-config.db-config.logic-not-delete-value}") String logicNotDeleteValue
    ) throws Exception {
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();//创建SqlSessionFactoryBean
        GlobalConfig globalConfig = new GlobalConfig();//创建GlobalConfig
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();//创建DbConfig

        mybatisSqlSessionFactoryBean.setDataSource(dataSource);//设置数据源
        mybatisSqlSessionFactoryBean.setVfs(SpringBootVFS.class);//设置包扫描到类型
        mybatisSqlSessionFactoryBean.setConfigLocation(configLocation);//设置Config路径
        mybatisSqlSessionFactoryBean.setMapperLocations(this.resourcePatternResolver.getResources(mapperLocation));//设置资源文件路径
        mybatisSqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);//设置别名包

        dbConfig.setLogicDeleteValue(logicDeleteValue);//设置逻辑删除值
        dbConfig.setLogicNotDeleteValue(logicNotDeleteValue);//设置逻辑未删除值

        globalConfig.setDbConfig(dbConfig);
        mybatisSqlSessionFactoryBean.setGlobalConfig(globalConfig);
        return mybatisSqlSessionFactoryBean;
    }
}
