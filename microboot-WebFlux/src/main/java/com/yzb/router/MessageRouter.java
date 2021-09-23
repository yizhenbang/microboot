package com.yzb.router;

import com.yzb.handler.MessageWebFluxHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

/**
 * ClassName: MessageRute
 * Description:
 * date: 2021/9/24 0:52
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Configuration
public class MessageRouter { //路由配置

    @Bean
    public RouterFunction<ServerResponse> routerFunction(MessageWebFluxHandler messageWebFluxHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/echo") // 使用Get的请求方式，匹配echo路径
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)) //并且接收的是文本类型
                , messageWebFluxHandler::execute);
    }

}
