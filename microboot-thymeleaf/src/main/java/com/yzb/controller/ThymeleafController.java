package com.yzb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: ThymeleafController
 * Description:
 * date: 2021/9/8 16:56
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Controller
public class ThymeleafController {
    @RequestMapping("/thymeleaf")
    public Object show(Model model) {
        model.addAttribute("title", "Hello Thymeleaf");
        return "message/MyThymeleaf";
    }
}
