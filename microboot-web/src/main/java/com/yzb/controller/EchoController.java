package com.yzb.controller;

import com.yzb.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: EchoController
 * Description:
 * date: 2021/9/2 23:44
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
public class EchoController {
    @Autowired
    private IMessageService iMessageService;

    @RequestMapping("/echo")
    public Object echo(String msg) {
        return iMessageService.echo(msg);
    }
}
