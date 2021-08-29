package com.yzb.service.impl;

import com.yzb.service.IMessageService;

/**
 * ClassName: IMessageServiceImpl
 * Description:
 * date: 2021/8/21 15:27
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
public class IMessageServiceImpl implements IMessageService {
    @Override
    public String echo(String msg) {
        return "【返回数据】"+msg;
    }
}
