package com.yzb.config;

import com.yzb.interceptor.WebServiceAuthInterceptor;
import com.yzb.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * ClassName: CXFConfig
 * Description:
 * date: 2021/9/21 19:56
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Configuration
public class CXFConfig {
    @Autowired
    private Bus bus;
    @Autowired
    private IMessageService iMessageService;
    @Autowired
    private WebServiceAuthInterceptor webServiceAuthInterceptor;

    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        return new ServletRegistrationBean(new CXFServlet(), "/service/*");//WebService的访问父路径
    }

    @Bean
    public Endpoint messageEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(this.bus, this.iMessageService);
        endpoint.publish("/MessageService");//发布地址
        endpoint.getInInterceptors().add(this.webServiceAuthInterceptor);//添加拦截器
        return endpoint;
    }
}
