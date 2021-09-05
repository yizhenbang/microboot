package com.yzb.controller;

import com.yzb.pojo.Company;
import com.yzb.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/dept2")
    public Object show(@ModelAttribute("company") Company company, @ModelAttribute("dept") Dept dept) {
        Map<String, Object> map = new HashMap<>();
        map.put("Company", company);
        map.put("Dept", dept);

        return map;
    }

}
