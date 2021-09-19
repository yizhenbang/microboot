package com.yzb.event;

import com.yzb.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import java.time.Clock;

/**
 * ClassName: YzhenEvent
 * Description:
 * date: 2021/9/19 19:28
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Slf4j
public class YzhenEvent extends ApplicationEvent {

    private Student student;

    public YzhenEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }

    public void show() {
        log.info("【YzhenEvent】想要干点事情~");
    }
}
