package com.yzb.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * ClassName: MDCIntercepter
 * Description:
 * date: 2021/9/10 16:57
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Slf4j
public class MDCInterceptor implements HandlerInterceptor {
    private static final String REQUEST_ID = "requestId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {//每次请求前进行MDC的绑定

        String forwarded = request.getHeader("x-Forwarded-For");
        String remoteAddr = request.getRemoteAddr();
        String uuid = UUID.randomUUID().toString();

        MDC.put(REQUEST_ID, uuid);//绑定MDC
        log.info("【MDC绑定】requestId={}，remoteAddr={}，x-Forwarded-For={}", uuid, remoteAddr, forwarded);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {//每次请求后进行MDC的清除
        MDC.remove(REQUEST_ID);
    }
}
