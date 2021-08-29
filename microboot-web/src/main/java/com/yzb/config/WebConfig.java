package com.yzb.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: WebConfig
 * Description:
 * date: 2021/8/27 23:35
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
// @Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        // 1、循环遍历所有的转换器
        for (HttpMessageConverter<?> converter : converters) {//循环遍历所有的转换器
            if (converter instanceof MappingJackson2HttpMessageConverter){//如果转换器为Jackson的就移除掉
                converters.remove(converter);//移除组件
                break;
            }
        }

        //2、实例化FastJSON的转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        //3、配置FastJSON
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteMapNullValue, //允许将Map的内容为NULL
                SerializerFeature.WriteDateUseDateFormat, //允许将日期进行格式化
                SerializerFeature.WriteNullListAsEmpty, //当List集合为空的时候变成[]
                SerializerFeature.WriteNullStringAsEmpty ,//将空的String变成空字符串
                SerializerFeature.WriteNullNumberAsZero ,//将空的数字转化成0
                SerializerFeature.DisableCircularReferenceDetect //禁用循环引用
        );

        // 4、将fastJsonConfig配置到fastJsonHttpMessageConverter
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        // 5、设置响应的头信息结构
        List<MediaType> mediaTypeEditors = new ArrayList<>();
        mediaTypeEditors.add(MediaType.APPLICATION_JSON);//将JSON设置为转换的结构

        // 6、将配置好的响应头信息结构设置到fastJsonHttpMessageConverter
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypeEditors);

        // 7、将fastJsonHttpMessageConverter配置到咱们的converters来
        converters.add(fastJsonHttpMessageConverter);


    }
}
