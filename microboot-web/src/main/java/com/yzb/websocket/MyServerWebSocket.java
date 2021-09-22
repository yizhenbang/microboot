package com.yzb.websocket;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.UUID;

/**
 * ClassName: MyServerWebSocket
 * Description:
 * date: 2021/9/22 13:27
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@ServerEndpoint("/websocket/{token}")//需要提供给客户端一个访问终端
@Component
@Slf4j
public class MyServerWebSocket {
    @OnOpen //建立连接
    public void openHandler(Session session, @PathParam("token") String token) {
        if (Strings.isEmpty(token)) {//如果没有内容
            this.sendMessage(session, "【ERROR】客户端token错误，无法建立连接");
        }
        log.info("【建立连接】成功建立连接……SessionId={}", session.getId());
        this.sendMessage(session, UUID.randomUUID().toString());//假装有一个token
    }

    @OnError
    public void throwableHandler(Session session, Throwable throwable) {
        log.info("【发成错误】sessionId={}，错误：{}", session.getId(), throwable);
    }

    @OnClose
    public void closeHandler(Session session) {
        log.info("【关闭连接】sessionId={}", session.getId());
    }

    @OnMessage
    public void messageHandler(Session session, String message) {
        log.info("【{}】用户发送消息，内容为:{]", session.getId(), message);
        this.sendMessage(session, "【ECHO】" + message);
    }

    @SneakyThrows
    private void sendMessage(Session session, String content) {
        if (session != null) {
            synchronized (session) {
                session.getBasicRemote().sendText(content);
            }
        }
    }
}
