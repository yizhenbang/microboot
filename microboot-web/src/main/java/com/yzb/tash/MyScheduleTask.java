package com.yzb.tash;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
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

    @Scheduled(fixedDelay = 2000)//两秒执行一次
    @SneakyThrows
    public void runJobA() {// 间隔任务
        log.info("【RATE】执行" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        TimeUnit.SECONDS.sleep(5);//模拟睡眠5秒
    }

    @Scheduled(cron = "* * * * * ?")
    public void runJobB() {
        log.info("【CROM】执行" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}
