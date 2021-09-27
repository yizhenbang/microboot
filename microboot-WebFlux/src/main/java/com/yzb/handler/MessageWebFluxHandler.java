package com.yzb.handler;

import com.yzb.vo.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: MessageWebFluxHandler
 * Description:
 * date: 2021/9/24 0:44
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Component
public class MessageWebFluxHandler {

    /**
     * @param request :这个就是一个请求
     * @returnServerResponse：直接返回响应
     * @author ZhenBang-Yi
     * @description //TODO
     * @createTime 2021/9/24 0:46
     **/
    public Mono<ServerResponse> execute(ServerRequest request) {
        return ServerResponse.ok()// 响应状态码
                .header("Content-type", "text/html;charset=UTF-8") // 设置响应头用标准的格式显示数据
                .body(BodyInserters.fromValue("你好啊~我是处理类返回的数据！！！"));
    }

    // 就不关注传统的ServerResponse 和 ServerRequest 直接将响应类型操作
    public Mono<Message> executeSpringBoot(Message message) {
        message.setContent("【" + Thread.currentThread().getName() + "】" + message.getContent());
        message.setTitle("【" + Thread.currentThread().getName() + "】" + message.getTitle());
        return Mono.create(messageMonoSink -> messageMonoSink.success(message));
    }

    // 集合数据用Flux进行返回
    public Flux<Message> list(Message message) {

        List<Message> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Message temp = new Message();
            temp.setContent("【" + i + "】" + message.getContent());
            temp.setTitle("【" + i + "】" + message.getTitle());
            temp.setDate(message.getDate());
            list.add(temp);
        }

        return Flux.fromIterable(list);
    }

    // Map.Entry 返回map数据
    public Flux<Map.Entry<String, Message>> map(Message message) {
        Map<String, Message> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            Message temp = new Message();
            temp.setContent("【" + i + "】" + message.getContent());
            temp.setTitle("【" + i + "】" + message.getTitle());
            temp.setDate(message.getDate());
            map.put(String.valueOf(i), temp);
        }

        return Flux.fromIterable(map.entrySet());
    }
}
