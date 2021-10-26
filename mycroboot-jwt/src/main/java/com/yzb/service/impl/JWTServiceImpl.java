package com.yzb.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yzb.service.JWTService;
import com.yzb.vo.JWTProperties;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTServiceImpl implements JWTService {

    @Autowired
    private JWTProperties jwtProperties;
    @Value("${spring.application.name?:app_yizhenbang}")
    private String appName;
    private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;//用HS256加密

    @Override
    public SecretKey generateKey() {
        byte[] decode = Base64.getDecoder().decode(Base64.getEncoder().encode(this.jwtProperties.getSecret().getBytes()));
        SecretKey secretKey = new SecretKeySpec(decode, 0, decode.length, "AES");
        return secretKey;
    }

    @Override
    public String createToken(String id, Map<String, Object> subject) throws JsonProcessingException {
        LocalDateTime now = LocalDateTime.now();//当前时间
        LocalDateTime failureTime = now.plusSeconds(this.jwtProperties.getExpire());//失效时间
        Map<String, Object> claims = new HashMap<>();//Calims信息
        claims.put("site", "www.yzb.com");//站点
        claims.put("company", "振邦信息");//站点

        Map<String, Object> header = new HashMap<>();//头信息
        header.put("author", "原来是小易");
        header.put("module", this.appName);
        header.put("desc", "简单的测试一下JWT");

        ObjectMapper objectMapper = new ObjectMapper();

        JwtBuilder jwtBuilder = Jwts.builder()
                .setIssuedAt(DateParse(now))//签发时间
                .setExpiration(DateParse(failureTime))//失效时间
                .setClaims(claims)//额外的信息
                .setHeader(header)//头信息
                .setId(id)//token的ID
                .setIssuer(this.jwtProperties.getIssuer())
                .setSubject(objectMapper.writeValueAsString(subject))//附加信息
                .signWith(this.signatureAlgorithm,this.generateKey());//设置签发者
        return jwtBuilder.compact();//压缩返回
    }

    @Override
    public Jws<Claims> parseToken(String token) throws JwtException {
        if (verifyToken(token)) {//检查Token是否正确
            return Jwts.parser()
                    .setSigningKey(generateKey())//设置token的key
                    .parseClaimsJws(token);//解析token
        } else {
            System.out.println("我失败");
        }
        return null;
    }

    @Override
    public boolean verifyToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(generateKey())//设置token的key
                    .parseClaimsJws(token)//解析token
                    .getBody();//如果能获取body就是解析成功
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    @Override
    public String refreshToken(String token) {
        try {
            if (verifyToken(token)) {//token正确
                Jws<Claims> claimsJws = this.parseToken(token);
                ObjectMapper mapper = new ObjectMapper();
                return this.createToken(claimsJws.getBody().getId(), mapper.convertValue(claimsJws.getBody().getSubject(), Map.class));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Date DateParse(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

}
