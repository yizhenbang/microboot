package com.yzb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//标注为方法注解
@Retention(RetentionPolicy.RUNTIME)//运行时进行
public @interface JWTCheckAnnotation {
    boolean require() default true;//默认为true
}
