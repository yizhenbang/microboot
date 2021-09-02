package com.yzb.intercepter;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: DefaultIntercepter
 * Description:
 * date: 2021/9/2 22:37
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
public class DefaultHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            System.out.println("=======【DefaultHandlerInterceptor】=======");
            System.out.println("【getBean】" + method.getBean());
            System.out.println("【getBeanType】" + method.getBeanType());
            System.out.println("【getMethod】" + request.getMethod());
        }

        return true;
    }
}
