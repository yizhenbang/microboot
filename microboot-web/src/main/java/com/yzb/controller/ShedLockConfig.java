package com.yzb.controller;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * ClassName: ShedLockConfig
 * Description:
 * date: 2021/9/17 19:35
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Configuration // 为一个配置类
@EnableScheduling // 启动定时任务
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S") //PT30S：30秒后强制释放锁
public class ShedLockConfig {

    @Value("${spring.profiles.active}")
    private String env;//当前系统使用的环境

    @Bean
    public LockProvider lockProvider(RedisConnectionFactory redisConnectionFactory){
        return new RedisLockProvider(redisConnectionFactory,this.env);
    }
}
