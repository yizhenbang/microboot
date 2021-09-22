package com.yzb.client;

import com.yzb.interceptor.ClientLoginInterceptor;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * ClassName: CXFClientDynamic
 * Description:
 * date: 2021/9/21 22:14
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
public class CXFClientDynamic {
    public static void main(String[] args) {
        String address = "http://localhost:8080/service/MessageService?wsdl";
        JaxWsDynamicClientFactory jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance();//动态代理创建
        Client client = jaxWsDynamicClientFactory.createClient(address);
        client.getOutInterceptors().add(new ClientLoginInterceptor("yzhenb", "123456"));//设置拦截器
        try {
            Object[] echoes = client.invoke("echo", "你好啊");
            System.out.println(echoes[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
