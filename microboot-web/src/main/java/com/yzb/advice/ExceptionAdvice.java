package com.yzb.advice;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ExceptionAdvice
 * Description:
 * date: 2021/9/3 22:03
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)//处理Exception异常
    @ResponseBody
    public Object error_500(Exception e) {
        ServletRequestAttributes requestAttribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttribute.getRequest();//获取HttpServletRequest
        Map map = new HashMap();
        map.put("exception", e.getClass().getName());
        map.put("path", request.getServletPath());
        map.put("content", e.getMessage());
        map.put("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        return map;
    }

}
