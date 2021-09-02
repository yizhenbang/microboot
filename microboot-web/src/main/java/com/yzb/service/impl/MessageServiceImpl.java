package com.yzb.service.impl;

import com.yzb.service.IMessageService;
import org.springframework.stereotype.Service;

/**
 * ClassName: MessageServiceImpl
 * Description:
 * date: 2021/9/2 23:43
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Service
public class MessageServiceImpl implements IMessageService {
    @Override
    public String echo(String msg) {
        System.out.println("【MessageServiceImpl】" + msg);
        return msg;
    }
}
