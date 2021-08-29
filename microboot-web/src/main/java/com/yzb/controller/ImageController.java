package com.yzb.controller;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * ClassName: ImageController
 * Description: 直接返回一张图片
 * date: 2021/8/29 22:34
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
public class ImageController {
    @SneakyThrows
    @RequestMapping(value = "/img",produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
    public BufferedImage createImage(){
        Resource imgResource = new ClassPathResource("/img/Fa6-007.jpg");
        return ImageIO.read(imgResource.getInputStream());
    }
}
