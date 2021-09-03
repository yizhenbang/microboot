package com.yzb.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * ClassName: ErrorPageConfig
 * Description:
 * date: 2021/9/3 16:14
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage errorPage_404 = new ErrorPage(HttpStatus.NOT_FOUND, "/errors/error404");
        ErrorPage errorPage_500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errors/error500");
        registry.addErrorPages(errorPage_404, errorPage_500);
    }

}
