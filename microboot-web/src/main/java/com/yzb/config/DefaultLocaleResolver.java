package com.yzb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * ClassName: DefaultLocaleResolver
 * Description: 接受请求参数loc，当请求参数中没有loc就采用默认的locale，否则进行拆分生成对象并返回
 * date: 2021/9/2 3:10
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class DefaultLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String loc = request.getParameter("loc");//接受请求参数 loc

        System.out.println("resolveLocale========"+loc);

        if (!StringUtils.hasLength(loc)) {
            return Locale.getDefault();
        }

        String[] split = loc.split("_");
        return new Locale(split[0], split[1]);
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }

    @Bean
    public DefaultLocaleResolver localeResolver(){//定义转换处理的Bean
        return new DefaultLocaleResolver();//返回DefaultLocaleResolver
    }
}
