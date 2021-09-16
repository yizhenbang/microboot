package com.yzb.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * ClassName: Studemt
 * Description:
 * date: 2021/8/21 19:55
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class Student {
    @Digits(integer = 2, fraction = 0)
    private int id;
    @Length(max = 3, min = 1)
    private String stuno;
    @NotNull
    private Date time;//入学时间
}
