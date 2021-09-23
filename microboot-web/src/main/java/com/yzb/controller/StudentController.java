package com.yzb.controller;

import com.yzb.asb.action.AbstractBaseAction;
import com.yzb.pojo.Student;
import com.yzb.task.MyAsyncTask;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: MessageController
 * Description:
 * date: 2021/8/27 13:49
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@RestController
@Slf4j
public class StudentController extends AbstractBaseAction {
    @RequestMapping("/student")
    public Object show1(Student msg) {
        return msg;
    }

    @RequestMapping("/student2")
    public Object show2(@NotBlank @Length(max = 5, min = 1) String msg) {
        return msg;
    }

    @RequestMapping("/student3")
    public Object show3(Student student) {
        return student;
    }

    @RequestMapping("/student4")
    public Object show4(String msg) {
        log.info("【外部线程】{},线程正在工作……", Thread.currentThread().getName());
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("【内部线程】{},线程正在工作……", Thread.currentThread().getName());
                return "【ECHO】Hello";
            }
        };
    }

    @RequestMapping("/student5")
    public Object show5(String msg) {
        log.info("【外部线程】{},线程正在工作……", Thread.currentThread().getName());
        WebAsyncTask<String> stringWebAsyncTask = new WebAsyncTask<>(200, new Callable<String>() {//200毫秒超时
            @Override
            public String call() throws Exception {
                log.info("【内部线程】{},线程正在工作……", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);//模拟延迟5s
                return "【ECHO】" + msg;
            }
        });

        stringWebAsyncTask.onTimeout(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.error("【{}】发生错误", Thread.currentThread().getName());
                return "【ERROR】" + msg;
            }
        });

        // stringWebAsyncTask.getExecutor().submit();
        return stringWebAsyncTask;
    }

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @RequestMapping("/student6")
    public Object show6(String msg) {
        log.info("【外部线程】{},线程正在工作……", Thread.currentThread().getName());

        DeferredResult deferredResult = new DeferredResult(200L);//200毫秒超时
        deferredResult.onCompletion(new Runnable() {//线程完成后的执行操作
            @Override
            public void run() {
                log.info("【完成线程】{},线程正在工作……", Thread.currentThread().getName());
            }
        });

        deferredResult.onTimeout(new Runnable() {
            @Override
            public void run() {
                log.info("【线程超时】{},线程正在工作……", Thread.currentThread().getName());
            }
        });


        this.threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            @SneakyThrows
            public void run() {
                log.info("【执行线程】{},线程正在工作……", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);//模拟两秒的延迟
                deferredResult.setResult("【ECHO】" + msg);
            }

        });

        return deferredResult;

    }

    @Autowired
    private MyAsyncTask myAsyncTask;

    @RequestMapping("/student7")
    public Object show7(String msg) {
        log.info("【外部线程】{},线程正在工作……", Thread.currentThread().getName());
        this.myAsyncTask.execute();//执行任务
        return "【ECHO】" + msg;
    }
}