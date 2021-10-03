package com.yzb.database.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;


/**
 * ClassName: DruidMonitorConfig
 * Description:
 * date: 2021/10/3 17:07
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Configuration
public class DruidMonitorConfig {

    @Bean("statViewServletServletRegistration")
    public ServletRegistrationBean<StatViewServlet> getStatViewServletServletRegistration() {
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(
                new StatViewServlet(), "/druid/*"
        );

        registrationBean.addInitParameter(StatViewServlet.PARAM_NAME_USERNAME, "yzhenb");//设置账号
        registrationBean.addInitParameter(StatViewServlet.PARAM_NAME_PASSWORD, "123456");//设置密码
        registrationBean.addInitParameter(StatViewServlet.PARAM_NAME_ALLOW, "127.0.0.1");//白名单
        registrationBean.addInitParameter(StatViewServlet.PARAM_NAME_DENY, "");//黑名单
        registrationBean.addInitParameter(StatViewServlet.PARAM_NAME_RESET_ENABLE, "true");//操作数据很多允许重置

        return registrationBean;

    }

}
