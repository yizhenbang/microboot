package com.yzb.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class YZBAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client_yzb")//定义注册的客户端ID
                .secret("hello")//注册的密码
                .authorizedGrantTypes("authorization_code")//响应类型
                .redirectUris("https://www.yootk.com")//返回路径，不配置的话无法生效
                .scopes("webapp");//作用范围
    }
}
