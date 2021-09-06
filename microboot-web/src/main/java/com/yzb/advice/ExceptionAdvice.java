package com.yzb.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ExceptionAdvice
 * Description:
 * date: 2021/9/6 11:29
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object HandleException(Exception e) {
        Map<String, Object> map = new HashMap<>();

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();//获取request

        map.put("path", request.getServletPath());
        map.put("exception", e.getClass().getName());
        map.put("message", e.getMessage());
        map.put("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        return map;

    }

}
