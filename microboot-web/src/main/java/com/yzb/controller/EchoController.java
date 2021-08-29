package com.yzb.controller;

import com.yzb.service.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;

/**
 * ClassName: EchoController
 * Description:
 * date: 2021/8/21 0:38
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@RestController
public class EchoController {

    private static final Logger logger = LoggerFactory.getLogger(EchoController.class);

    @Autowired
    private IMessageService imessageservice;


    @RequestMapping("/")
    public String show1(String msg){
        logger.info("打通连接了");
        return imessageservice.echo(msg);
    }

}
