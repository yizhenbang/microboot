package com.yzb.test;

import com.yzb.SpringBootApp;
import com.yzb.event.YzhenEvent;
import com.yzb.pojo.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

/**
 * ClassName: EventTest
 * Description:
 * date: 2021/9/19 19:34
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@ExtendWith(SpringExtension.class)//使用Junit5
@WebAppConfiguration//启动web服务
@SpringBootTest(classes = SpringBootApp.class)// 设置SpringBoot程序类
public class EventTest {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Test
    public void test1() {
        Student student = new Student();
        student.setId(1);
        student.setStuno("stu001");
        student.setTime(new Date());
        applicationEventPublisher.publishEvent(new YzhenEvent(this,student));
    }

}
