package com.yzb.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * ClassName: NameAdivce
 * Description:
 * date: 2021/9/5 19:35
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@ControllerAdvice
public class NameAdvice {

    @InitBinder("dept")
    public void dept(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("dept.");
    }

    @InitBinder("company")
    public void company(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("company.");
    }

}
