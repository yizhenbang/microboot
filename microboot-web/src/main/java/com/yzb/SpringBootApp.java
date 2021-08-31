package com.yzb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * ClassName: SpringBootApp
 * Description:
 * date: 2021/8/21 0:36
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@SpringBootApplication
public class SpringBootApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringBootApp.class);
        springApplication.run(args);
    }
}
