package com.yzb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * ClassName: I18Controller
 * Description:
 * date: 2021/9/1 20:33
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
public class I18Controller {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/base")
    public Object showbase(){
        Map<String, String> result = new HashMap<>();
        String message = this.messageSource.getMessage("yzb.message", null, Locale.getDefault());
        String url = this.messageSource.getMessage("yzb.url", null, Locale.getDefault());

        System.out.println("========="+message);

        result.put("message",message);
        result.put("url",url);

        return  result;
    }

    @RequestMapping("/locale")
    public Object showlocale(Locale loc){
        Map<String, String> result = new HashMap<>();
        String message = this.messageSource.getMessage("yzb.message", null, loc);
        String url = this.messageSource.getMessage("yzb.url", null, loc);

        System.out.println("=========loc"+loc);
        System.out.println("=========showlocale"+message);

        result.put("message",message);
        result.put("url",url);

        return  result;
    }
}
