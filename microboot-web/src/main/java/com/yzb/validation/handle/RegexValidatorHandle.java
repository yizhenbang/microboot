package com.yzb.validation.handle;

import com.yzb.validation.annotation.RegexValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * ClassName: ValidationHandle
 * Description:
 * date: 2021/9/6 19:10
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
public class RegexValidatorHandle implements ConstraintValidator<RegexValidator, Object> {

    private String regex;

    @Override
    public void initialize(RegexValidator constraintAnnotation) {
        this.regex = constraintAnnotation.pattern();//获取表达式
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.toString().matches(this.regex);
    }
}
