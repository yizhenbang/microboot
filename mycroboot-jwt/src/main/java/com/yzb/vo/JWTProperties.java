package com.yzb.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "yzb.config.jwt")
@Data
public class JWTProperties {
    private String sing;//证书签名
    private String issuer;//证书签发人
    private String secret;//加密秘钥
    private Long expire;//有效时间（单位：秒）
}
