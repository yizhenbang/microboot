package com.yzb.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * ClassName: ServiceAspect
 * Description: 切入com.yzb.service及其子包下的类
 * date: 2021/9/2 23:36
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Component
@Aspect
public class ServiceAspect {
    @Around("execution(* com.yzb.service.*.*(..))")
    public Object aroundService(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("【ServiceAspect】before");
        System.out.println("【ServiceAspect-Args】" + joinPoint.getArgs());

        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof String) {
                args[i] = "【AspectJ】" + args[i];
            }
        }

        Object proceed = joinPoint.proceed(args);

        System.out.println("【ServiceAspect-return】" + proceed);
        System.out.println("【ServiceAspect】after");

        return proceed;
    }
}