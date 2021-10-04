package com.yzb.database.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ExceptionConfig
 * Description:
 * date: 2021/10/4 18:24
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(Exception.class)
    @ResponseBody//返回JSON数据
    public Object exceptionHandler(Exception exception) {
        Map map = new HashMap();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();

        map.put("exception", exception.getClass().getName());
        map.put("ServletPath", request.getServletPath());
        map.put("RequestURI", request.getRequestURI());
        map.put("message", exception.getMessage());
        map.put("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        return map;
    }

}
