package com.yzb;

import com.yzb.database.StarterDruidApplication;
import com.yzb.database.enums.SexEnum;
import com.yzb.database.service.IMessage;
import com.yzb.database.vo.Haha;
import com.yzb.database.vo.Teacher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    void addBatch() {
        Map<Teacher, List<Haha>> map = new HashMap();
        List<Haha> list = new ArrayList<>();
        Teacher teacher = Teacher.builder().teacherNo("00123").teacherSex(SexEnum.MAX).teacherName("小易老师").build();
        for (int i = 0; i < 10; i++) {
            Haha student = Haha.builder().name("小易").sex(SexEnum.WOMAN).classea_Id(5).teacherId(5).build();
            list.add(student);
        }

        map.put(teacher, list);
        iMessage.addAll(map);
    }
}
