package com.yzb.client;

import com.yzb.interceptor.ClientLoginInterceptor;
import com.yzb.service.IMessageService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * ClassName: CXFClientProxy
 * Description:
 * date: 2021/9/21 21:30
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */


public class CXFClientProxy {
    public static void main(String[] args) {
        String address = "http://localhost:8080/service/MessageService?wsdl";
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(IMessageService.class);
        jaxWsProxyFactoryBean.setAddress(address);
        jaxWsProxyFactoryBean.getOutInterceptors().add(new ClientLoginInterceptor("yzhenb", "123456"));
        IMessageService iMessageService = (IMessageService) jaxWsProxyFactoryBean.create();
        String hi = iMessageService.echo("你好");
        System.out.println(hi);
    }
}
