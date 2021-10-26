package com.yzb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;

import javax.crypto.SecretKey;
import java.util.Map;

public interface JWTService {

    /**
     * @author ZhenBang-Yi
     * @description //TODO 获取Token的ke
     * @createTime 2021/10/25 18:49
     **/
    SecretKey generateKey();

    /**
     * @param id      Token的唯一id
     * @param subject 所有的附加信息，这里传入的是Map数据，但是保存的时候是Json
     * @return
     * @author ZhenBang-Yi
     * @description //TODO 生成Token数据
     * @createTime 2021/10/25 18:48
     **/
    String createToken(String id, Map<String, Object> subject) throws JsonProcessingException;


    /**
     * @author ZhenBang-Yi
     * @description //TODO 解析Token
     * @createTime 2021/10/25 18:51
     * JwtException 如果结构异常或者Token失效就会报错
     **/
    Jws<Claims> parseToken(String token) throws JwtException;

    /**
     * @author ZhenBang-Yi
     * @description //TODO 验证Token是否正确
     * @createTime 2021/10/25 18:52
     **/
    boolean verifyToken(String token);

    /**
     * @author ZhenBang-Yi
     * @description //TODO 刷新Token
     * @createTime 2021/10/25 18:53
     **/
    String refreshToken(String token);
}
