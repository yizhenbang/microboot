package com.yzb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ErrorPageController
 * Description:
 * date: 2021/9/3 16:07
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/errors/*")
public class ErrorPageController {

    @RequestMapping("error404")
    public Object errors_404() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();

        response.setStatus(HttpServletResponse.SC_NOT_FOUND);//设置响应状态码

        Map<String, Object> result = new HashMap<>();
        result.put("status", HttpServletResponse.SC_NOT_FOUND);//状态码
        result.put("content", "您的访问路径有误！");//获取访问者地址
        result.put("path", request.getServletPath());//请求路径
        result.put("referer", request.getHeader("referer"));//获取访问者地址

        return result;
    }

    @RequestMapping("error500")
    public Object errors_500() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();

        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);//设置响应状态码

        Map<String, Object> result = new HashMap<>();
        result.put("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);//状态码
        result.put("content", "服务器内部发生错误！");//获取访问者地址
        result.put("path", request.getServletPath());//请求路径
        result.put("referer", request.getHeader("referer"));//获取访问者地址

        return result;
    }

}
