package com.yzb.oauth.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ResourceAction {
    @RequestMapping("/resource")
    public Principal principal(Principal principal) {
        return principal;
    }
}
