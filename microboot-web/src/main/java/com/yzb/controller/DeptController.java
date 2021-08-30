package com.yzb.controller;

import com.yzb.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: DeptController
 * Description:
 * date: 2021/8/30 0:55
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
public class DeptController {

    @Autowired
    private Dept dept;

    @GetMapping("/dept")
    public Object show(){
        return this.dept;
    }

}
