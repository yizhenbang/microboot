package com.yzb.test;

import com.yzb.SpringBootApp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * ClassName: SendMailTest
 * Description:
 * date: 2021/9/3 0:54
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@ExtendWith(SpringExtension.class) // 使用Junit5测试工具
@WebAppConfiguration // 启动WEB运行环境
@SpringBootTest(classes = SpringBootApp.class)// 配置程序启动类
public class SendMailTest {
    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void sendMail(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();//创建一个简单的邮件服务
        simpleMailMessage.setFrom("1628755314@qq.com");//邮件发送者
        simpleMailMessage.setTo("1628755314@qq.com");//邮件接受者
        simpleMailMessage.setSubject("来自可爱的小易给您的邮件");//设置邮件标题
        simpleMailMessage.setText("Hello Mail ！ Please see www.baidu.com");//设置正文

        javaMailSender.send(simpleMailMessage);//发送
    }

}
