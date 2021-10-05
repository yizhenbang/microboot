package com.yzb;

import com.yzb.database.StarterDruidApplication;
import com.yzb.database.dao.IMessageMapper;
import com.yzb.database.service.IMessage;
import com.yzb.database.vo.StudentVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * ClassName: TestMyBatis
 * Description:
 * date: 2021/10/4 21:49
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest(classes = StarterDruidApplication.class)
public class TestMyBatis {

    @Autowired
    private IMessage iMessage;

    @Test
    void list() {
        List<StudentVO> list = iMessage.list();
        list.forEach(System.out::println);
    }
}
