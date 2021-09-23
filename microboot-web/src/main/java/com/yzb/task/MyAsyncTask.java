package com.yzb.task;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: MyAsyncTask
 * Description:
 * date: 2021/9/23 19:20
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Component
@Slf4j
public class MyAsyncTask {

    @Async
    @SneakyThrows
    public void execute() {
        log.info("【{}】开始处理异步任务", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);//延迟五秒
        log.info("【{}】结束处理异步任务", Thread.currentThread().getName());
    }
}
