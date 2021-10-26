package com.yzb.interceptor;

import com.yzb.annotation.JWTCheckAnnotation;
import com.yzb.service.JWTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class JWTCheckInterceptor implements HandlerInterceptor {

    @Autowired
    private JWTService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            Method method = ((HandlerMethod) handler).getMethod();
            JWTCheckAnnotation annotation = method.getAnnotation(JWTCheckAnnotation.class);
            if (annotation!=null && annotation.require()) {//如果不需要进行验证就直接放行把
                if (!jwtService.verifyToken(getToken(request))) {
                    throw new RuntimeException("token数据无效，无法访问");
                }
            }
        }
        return true;
    }

    private String getToken(HttpServletRequest request) {//获取token
        String token = request.getParameter("token");
        if (!StringUtils.hasLength(token)) {//此时没有在请求参数中找到token
            token = request.getHeader("token");
        }
        return token;
    }
}
