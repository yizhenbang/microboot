package com.yzb.database.service.impl;

import com.yzb.database.service.IMessage;
import org.springframework.stereotype.Service;

/**
 * ClassName: MessageImpl
 * Description:
 * date: 2021/10/4 19:12
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Service
public class MessageImpl implements IMessage {
    @Override
    public String echo(String msg) {
        return "【ECHO】" + msg;
    }
}
