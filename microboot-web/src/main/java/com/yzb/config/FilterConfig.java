package com.yzb.config;

import com.yzb.filter.GFFilter;
import com.yzb.filter.JWXFilter;
import com.yzb.filter.YZBFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * ClassName: FilterConfig
 * Description:
 * date: 2021/9/2 16:20
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean getYZBRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(this.getYZBFilter());
        filterRegistrationBean.addUrlPatterns("/order/*");
        filterRegistrationBean.setName("getYZBRegistration");
        filterRegistrationBean.setOrder(10);

        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean getgetGFRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(this.getGFFilter());
        filterRegistrationBean.addUrlPatterns("/order/*");
        filterRegistrationBean.setName("getgetGFRegistration");
        filterRegistrationBean.setOrder(-100);

        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean getJWXRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(this.getJWXFilter());
        filterRegistrationBean.addUrlPatterns("/order/*");
        filterRegistrationBean.setName("getJWXRegistration");
        filterRegistrationBean.setOrder(50);

        return filterRegistrationBean;
    }

    @Bean
    public Filter getYZBFilter() {
        return new YZBFilter();
    }

    @Bean
    public Filter getGFFilter() {
        return new GFFilter();
    }

    @Bean
    public Filter getJWXFilter() {
        return new JWXFilter();
    }
}
