package com.yzb.database.action;

import com.yzb.database.service.IMessage;
import com.yzb.database.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: EchoAction
 * Description:
 * date: 2021/10/4 1:15
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
//@RestController
public class EchoAction {


    //@Autowired
    private IMessage iMessage;

    @GetMapping("/all")
    public Object all() {
        List<StudentVO> list = iMessage.list();
        return list;
    }
}
