package com.yzb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: WebController
 * Description:
 * date: 2021/8/31 23:51
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
public class WebController {
    @RequestMapping("/req1")
    public Object show1(HttpServletRequest request, HttpServletResponse response) {
        return getMsg(request, response);
    }

    @RequestMapping("/req2")
    public Object show2() {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();

        return getMsg(request, response);
    }


    public Map getMsg(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<>();
        result.put("【request】getServletPath", request.getServletPath());
        result.put("【session】SessionId", request.getSession().getId());
        result.put("【application】initParam", request.getServletContext().getInitParameter("name"));
        return result;
    }


}
