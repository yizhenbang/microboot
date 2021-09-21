package com.yzb.service.impl;

import com.yzb.service.IMessageService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * ClassName: MessageServiceImpl
 * Description:
 * date: 2021/9/21 17:54
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Service //该接口自动进行Bean注册
@WebService(serviceName = "MessageService",//服务名
        targetNamespace = "http://service.yzb.com/",//命名空间
        endpointInterface = "com.yzb.service.IMessageService") //接口终端
public class MessageServiceImpl implements IMessageService {
    @Override
    public String echo(String msg) {
        return msg;
    }
}