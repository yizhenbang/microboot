package com.yzb.starter.config;

import com.yzb.starter.handler.DefaultImportBeanDefinitionRegistrar;
import com.yzb.starter.selector.DefaultImportSelector;
import com.yzb.starter.vo.Person;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: config
 * Description:
 * date: 2021/9/27 21:56
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
// @EnableConfigurationProperties(Person.class)
// @Import(Person.class)
// @Import(DefaultImportSelector.class)
@Import(DefaultImportBeanDefinitionRegistrar.class)
public class DefaultAutoConfig {

    @Bean("pigs")
    public List<String> getPigs() {
        return Arrays.asList("小易", "啊", "你好", "我喜欢你");
    }

}
