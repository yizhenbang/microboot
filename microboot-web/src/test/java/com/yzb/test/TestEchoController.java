package com.yzb.test;

import com.yzb.SpringBootApp;
import com.yzb.controller.EchoController;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sound.midi.Soundbank;

/**
 * ClassName: TestEchController
 * Description:
 * date: 2021/8/21 18:40
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@ExtendWith(SpringExtension.class)//使用JUnit5
@WebAppConfiguration // 启动WEB容器
@SpringBootTest(classes = SpringBootApp.class) //配置程序启动类
public class TestEchoController {
    @Autowired
    private EchoController echoController;

    @BeforeAll
    public static void init(){
        System.out.println("【TestEchoController】Init SUCCESSFUL");
    }

    @AfterAll
    public static void after(){
        System.out.println("【TestEchoController】after SUCCESSFUL");
    }

    @Test
    public void TestShow1(){
        String hi = echoController.show1("你好");
        System.out.println(hi);
    }

}
