package com.yzb.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import java.util.List;

import static org.apache.cxf.phase.Phase.PREPARE_SEND;

/**
 * ClassName: ClientMessageInterceptor
 * Description:
 * date: 2021/9/21 21:07
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
public class ClientLoginInterceptor extends AbstractPhaseInterceptor<SoapMessage> {//客户端登录拦截器

    private String username;
    private String password;

    public ClientLoginInterceptor(String username, String password) {
        super(PREPARE_SEND);//处理每一个请求
        this.username = username;
        this.password = password;
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        List<Header> headers = message.getHeaders();//获取所有的请求头

        Document document = DOMUtils.createDocument();
        Element auth = document.createElement("auth");//创建认证节点
        Element usernameDOM = document.createElement("username");//创建账号节点
        Element passwordDOM = document.createElement("userPassword");//创建密码节点

        usernameDOM.setTextContent(this.username);//赋值账号
        passwordDOM.setTextContent(this.password);//赋值密码

        auth.appendChild(usernameDOM);
        auth.appendChild(passwordDOM);

        headers.add(0, new Header(new QName("auth"), auth));
    }
}
