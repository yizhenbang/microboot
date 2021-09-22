package com.yzb.controller;

import com.yzb.asb.action.AbstractBaseAction;
import com.yzb.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.concurrent.Callable;

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
@Slf4j
public class StudentController extends AbstractBaseAction {
    @RequestMapping("/student")
    public Object show1(Student msg) {
        return msg;
    }

    @RequestMapping("/student2")
    public Object show2(@NotBlank @Length(max = 5, min = 1) String msg) {
        return msg;
    }

    @RequestMapping("/student3")
    public Object show3(Student student) {
        return student;
    }

    @RequestMapping("/student4")
    public Object show4(String msg) {
        log.info("【外部线程】{},线程正在工作……", Thread.currentThread().getName());
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("【内部线程】{},线程正在工作……", Thread.currentThread().getName());
                return "【ECHO】Hello";
            }
        };
    }
}
// localhost/student
// localhost/student2
// localhost/student3?id=1&stuno=hi&time=2021-05-12&testregex=abc1