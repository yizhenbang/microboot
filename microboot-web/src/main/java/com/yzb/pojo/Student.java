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
    private int id;
    private String stuno;
    private Date time;//入学时间
}
