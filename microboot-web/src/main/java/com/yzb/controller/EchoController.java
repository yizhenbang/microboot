package com.yzb.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class EchoController {

    @RequestMapping("/echo")
    public Object echo(String msg) {
        log.error("我是INFO{}，当前路径{}", "EchoController", "/echo");
        log.warn("我是INFO{}，当前路径{}", "EchoController", "/echo");
        log.info("我是INFO{}，当前路径{}", "EchoController", "/echo");
        log.debug("我是INFO{}，当前路径{}", "EchoController", "/echo");
        log.trace("我是INFO{}，当前路径{}", "EchoController", "/echo");
        return msg;
    }
}
