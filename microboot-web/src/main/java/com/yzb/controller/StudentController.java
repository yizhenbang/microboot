package com.yzb.controller;

import com.yzb.asb.action.AbstractBaseAction;
import com.yzb.pojo.Student;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * ClassName: MessageController
 * Description:
 * date: 2021/8/27 13:49
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@RestController
@Validated
public class StudentController extends AbstractBaseAction {
    @RequestMapping("/student")
    public Object show1(@Valid Student msg) {
        return msg;
    }

    @RequestMapping("/student2")
    public Object show2(@NotBlank @Length(max = 5, min = 1) String msg) {
        return msg;
    }

    @RequestMapping("/student3")
    public Object show3(@Valid Student student) {
        return student;
    }
}
// localhost/student
// localhost/student2
// localhost/student3?id=1&stuno=hi&time=2021-05-12&testregex=abc1