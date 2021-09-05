package com.yzb.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: DataAdvice
 * Description:
 * date: 2021/9/4 10:53
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@ControllerAdvice
public class DataAdvice {

    @ModelAttribute("bindModel")
    @ResponseBody
    public Object bindData() {
        Map<String, Object> map = new HashMap<>();
        map.put("【DataAdvice】", "你好");
        return map;
    }

}
