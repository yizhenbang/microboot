package com.yzb.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;
// import org.springframework.ws.soap.SoapMessage;
// import org.springframework.ws.soap.SoapMessage;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

/**
 * ClassName: WebServiceAuthInterceptor
 * Description:
 * date: 2021/9/21 18:02
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Component
@Slf4j
public class WebServiceAuthInterceptor extends AbstractPhaseInterceptor<SoapMessage> {//WebService授权拦截器
    private SAAJInInterceptor saajInInterceptor = new SAAJInInterceptor();//创建拦截器
    private static final String USER_NAME = "yzhenb";
    private static final String USER_PWD = "123456";

    public WebServiceAuthInterceptor() {
        super(Phase.PRE_PROTOCOL);
        super.getAfter().add(SAAJInInterceptor.class.getName());//添加拦截
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {//处理消息
        SOAPMessage soapMessage = message.getContent(SOAPMessage.class);//获取指定消息内容
        if (soapMessage == null) {//没有消息
            this.saajInInterceptor.handleMessage(message);//使用默认的处理方式
            soapMessage = message.getContent(SOAPMessage.class);//尝试获取消息
        }
        SOAPHeader soapHeader = null;//SOAP头信息
        try {
            soapHeader = soapMessage.getSOAPHeader();//获取头信息
        } catch (SOAPException e) {
            e.printStackTrace();
        }

        if (soapHeader == null) {//如果没有头信息
            throw new Fault(new IllegalAccessException("没有找到头信息，无法进行认证~"));
        }

        //因为SOAP是经过XML进行传输数据的，所以要进行要进行数据结构的约定
        NodeList usernameNodeList = soapHeader.getElementsByTagName("username");
        NodeList userPasswordNodeList = soapHeader.getElementsByTagName("userPassword");

        if (usernameNodeList.getLength() < 1) {
            throw new Fault(new IllegalAccessException("用户名获取失败无法认证~"));
        }

        if (userPasswordNodeList.getLength() < 1) {
            throw new Fault(new IllegalAccessException("密码获取失败无法认证~"));
        }

        String userName = usernameNodeList.item(0).getTextContent().trim();//获取到用户名的实际值
        String userPassword = userPasswordNodeList.item(0).getTextContent().trim();//获取密码的实际值


        if (userName == USER_NAME && userPassword == USER_PWD) {
            log.info("认证成功！~");
        } else {
            log.error("认证失败！~ 请检查账号或密码是否正确");
            throw new Fault(new SOAPException("认证失败！"));
        }

    }
}
