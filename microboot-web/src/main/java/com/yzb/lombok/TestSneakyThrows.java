package com.yzb.lombok;

import lombok.SneakyThrows;

/**
 * ClassName: TestSneakyException
 * Description:
 * date: 2021/8/23 11:14
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
public class TestSneakyThrows {
    @SneakyThrows
    public static void send(String msg){
        if (null==msg) {
            // System.err.println("开始报错！！！");
            throw new Exception("ghjgjh");
        }
        System.out.println("【消息为】："+msg);
    }
}