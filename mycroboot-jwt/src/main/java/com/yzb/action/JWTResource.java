package com.yzb.action;

import com.yzb.annotation.JWTCheckAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTResource {
    @JWTCheckAnnotation
    @GetMapping("/echo")
    public String echo(String echo) {
        return "【ECHO】" + echo;
    }
}
