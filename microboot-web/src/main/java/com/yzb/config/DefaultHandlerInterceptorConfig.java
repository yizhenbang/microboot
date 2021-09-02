package com.yzb.config;

import com.yzb.intercepter.DefaultHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: DefaultHandlerIntercepter
 * Description:
 * date: 2021/9/2 22:44
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class DefaultHandlerInterceptorConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.getDefaultHandlerInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public HandlerInterceptor getDefaultHandlerInterceptor(){
        return new DefaultHandlerInterceptor();
    }

}
