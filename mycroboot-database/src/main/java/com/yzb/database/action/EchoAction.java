package com.yzb.database.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: EchoAction
 * Description:
 * date: 2021/10/4 1:15
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
public class EchoAction {
    @GetMapping("/echo")
    public String echo(String msg) {
        return "【ECHO】" + msg;
    }
}
