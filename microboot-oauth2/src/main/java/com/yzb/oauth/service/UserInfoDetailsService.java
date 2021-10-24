package com.yzb.oauth.service;

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
 // extends UserInfoTokenServices
// @Service
public class UserInfoDetailsService{


    // @Override
    public void setPrincipalExtractor(PrincipalExtractor principalExtractor) {
        Map<String, Object> map = new HashMap<>();
        map.put("myCont", "Hello");
        principalExtractor.extractPrincipal(map);
    }
}
