package com.yzb.validation.annotation;

import com.yzb.validation.handle.RegexValidatorHandle;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Digits;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * ClassName: Validator
 * Description:
 * date: 2021/9/6 19:01
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {RegexValidatorHandle.class})//处理类
public @interface RegexValidator {
    //所有的验证注解都需要提供一下三个属性
    String message() default "您的正则格式有误";//错误提示信息

    Class<?>[] groups() default {};//组

    Class<? extends Payload>[] payload() default {};//附加源数据信息

    String pattern();//装入表达式
}
