package com.yzb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringBootApp.class);
        springApplication.run(args);
    }
}
