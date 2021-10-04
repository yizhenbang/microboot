package com.yzb.config;

import com.yzb.intercepter.MDCInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: InterceptorConfig
 * Description:
 * date: 2021/9/10 17:04
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
// @Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.getMDCInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public HandlerInterceptor getMDCInterceptor() {
        return new MDCInterceptor();
    }
}
