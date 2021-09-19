package com.yzb.tash;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: MyScheduleTask
 * Description:
 * date: 2021/9/16 23:38
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Component
@Slf4j
public class MyScheduleTask {//定时任务类

    // lockAtMostFor ：任务执行完成时，任务节点要独占锁的最长时间
    // lockAtLeastFor：任务执行完成时，任务节点要独占锁的最短时间
    @SneakyThrows
    @Scheduled(cron = "* * * * * ?")
    @SchedulerLock(name = "MyFirstShedLock",lockAtLeastFor="5000") // 任务执行后，独占锁5秒
    public void runJobB() {
        log.info("【CROM】执行" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        TimeUnit.SECONDS.sleep(5);
    }

}
