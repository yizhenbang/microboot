package com.yzb.starter.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName: Person
 * Description:
 * date: 2021/9/27 21:57
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
@ConfigurationProperties("starter.com.yzb")
public class Person {
    private String name;
    private String sex;
    private Integer age;
}
