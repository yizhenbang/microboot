package com.yzb.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * ClassName: IMessageService
 * Description:
 * date: 2021/9/21 17:38
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@WebService(name = "MessageService", targetNamespace = "http://service.yzb.com/")//一般使用包名的反向
public interface IMessageService {
    @WebMethod//WebService方法标注
    String echo(@WebParam String msg);
}