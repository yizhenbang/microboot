package com.yzb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName: CustomeAsyncPoolConfig
 * Description:
 * date: 2021/9/23 0:25
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Configuration
public class CustomeAsyncPoolConfig implements WebMvcConfigurer {
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {//异步配置
        configurer.setDefaultTimeout(10000);
        configurer.registerCallableInterceptors(this.timeoutCallableProcessingInterceptor());//设置Callable的拦截器
        configurer.setTaskExecutor(this.threadPoolTaskExecutor());
    }

    @Bean(name = "asyncPoolTaskExecutor")//SpringBoot本身内部就有线程池提供，所以更换一个名字以作为区分
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        threadPoolTaskExecutor.setCorePoolSize(20);//设置内核线程个数（物理线程*2）
        threadPoolTaskExecutor.setMaxPoolSize(200);//设置工作线程池的大小
        threadPoolTaskExecutor.setQueueCapacity(25);//如果线程池占满设置延迟队列，允许25个用户进行等待
        threadPoolTaskExecutor.setKeepAliveSeconds(200);//设置存活时间
        threadPoolTaskExecutor.setThreadNamePrefix("yzb - ");//设置线程名字的前缀
        threadPoolTaskExecutor.setRejectedExecutionHandler(//设置拒绝策略，线程池满了之后是要等还是直接结束
                new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.initialize();//初始化

        return threadPoolTaskExecutor;
    }

    @Bean
    public TimeoutCallableProcessingInterceptor timeoutCallableProcessingInterceptor() {//超时处理
        return new TimeoutCallableProcessingInterceptor();
    }
}
