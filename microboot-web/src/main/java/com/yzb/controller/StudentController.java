package com.yzb.controller;

import com.yzb.asb.action.AbstractBaseAction;
import com.yzb.pojo.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class StudentController extends AbstractBaseAction  {
    @RequestMapping("/student")
    public Object show1(Student msg){
        msg.setStuno("【ECHO】"+msg.getStuno());
        msg.setName("【ECHO】"+msg.getName());
        return msg;
    }
}
// localhost:8080/Student?stuno=123&name=小易&entranceDate=1998-12-01