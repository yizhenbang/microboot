package com.yzb.oauth.service;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails client = new BaseClientDetails();
        client.setClientId("client_yzb");//设置Client_id
        client.setClientSecret("hello");
        client.setAuthorizedGrantTypes(Arrays.asList("authorization_code"));
        client.setScope(Arrays.asList("webapp"));
        client.isAutoApprove("true");//自动确认
        client.setAccessTokenValiditySeconds(120);//Token有效时间为120秒
        Set<String> hashSet = new HashSet();
        hashSet.add("https://yootk.com");
        client.setRegisteredRedirectUri(hashSet);//要是不设置这个就会导致没有办法获取到   authCode
        return client;
    }
}
