package com.yzb;

import com.yzb.banner.YZBBanner;
import com.yzb.lombok.CleanupIO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * ClassName: SpringBootApp
 * Description:
 * date: 2021/8/21 0:36
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@ImportResource(locations = {"classpath:MATE-INF/spring/spring-service.xml"})
@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        // Student build = Student.builder().id(1).name("易振邦").stuno("stu001").build();
        // System.out.println(build);
        SpringApplication springApplication = new SpringApplication(SpringBootApp.class);
        springApplication.setBanner(new YZBBanner());//设置自定义的Banner
        // springApplication.setBannerMode(Banner.Mode.OFF);//让Banner关闭
        springApplication.run(args);
        // TestSneakyThrows.send(" sd ");

        // System.out.println("aa");
        //
        // CleanupIO cleanupIO = new CleanupIO();
        // cleanupIO.read();

    }
}
