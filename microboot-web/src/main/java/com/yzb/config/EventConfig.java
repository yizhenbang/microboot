package com.yzb.config;

import com.yzb.event.YzhenEvent;
import com.yzb.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * ClassName: EventConfig
 * Description:
 * date: 2021/9/19 23:46
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Configuration
@Slf4j
public class EventConfig {

    // @EventListener
    // public void show(YzhenEvent event) {
    //     event.show();
    //     log.info("【EventConfig】{}", "你好~");
    // }

    // @EventListener
    // public void eventAll(Object event) {
    //     log.info("【eventAll】{}", event);
    // }

    // @EventListener(condition = "#event.student.stuno=='stu002'")//当学生编号为stu002的时候触发监听
    // public void eventByCondition(YzhenEvent event) {
    //     event.show();
    //     log.info("【eventByCondition】{}", event);
    // }

    @EventListener
    public void eventByContent(Student event) {
        log.info("【eventByCondition】{}", event);
    }
}
