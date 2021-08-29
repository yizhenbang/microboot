package com.yzb.controller;

import com.yzb.handle.VideoResourceHttpRequestHandler;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: VideoController
 * Description: 直接返回视频
 * date: 2021/8/29 23:39
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
public class VideoController {

    @Autowired
    private VideoResourceHttpRequestHandler videoResourceHttpRequestHandler;

    @RequestMapping("/video")
    public void handleVideo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        videoResourceHttpRequestHandler.handleRequest(request,response);
    }
}
