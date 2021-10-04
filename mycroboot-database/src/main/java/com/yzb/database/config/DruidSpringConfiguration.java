package com.yzb.database.config;

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * ClassName: DruidSpringConfiguration
 * Description:
 * date: 2021/10/4 18:46
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class DruidSpringConfiguration {

    @Bean("druidStatInterceptor")
    public DruidStatInterceptor getDruidStatInterceptor() {
        return new DruidStatInterceptor();
    }


    @Bean("jdkRegexpMethodPointcut")
    @Scope("prototype")
    public JdkRegexpMethodPointcut getJdkRegexpMethodPointcut() {//获取切面
        JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
        jdkRegexpMethodPointcut.setPatterns("com.yzb.database.service.*", "com.yzb.database.dao.*", "com.yzb.database.action.*");
        return jdkRegexpMethodPointcut;
    }

    @Bean("defaultPointcutAdvisor")//通过advisor 将 advice和切面进行配置
    public DefaultPointcutAdvisor getDefaultPointcutAdvisor(DruidStatInterceptor druidStatInterceptor, JdkRegexpMethodPointcut jdkRegexpMethodPointcut) {
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setAdvice(druidStatInterceptor);
        defaultPointcutAdvisor.setPointcut(jdkRegexpMethodPointcut);
        return defaultPointcutAdvisor;
    }

}
