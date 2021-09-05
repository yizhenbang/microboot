package com.yzb.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * ClassName: Dept
 * Description:
 * date: 2021/8/22 2:03
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
@ConfigurationProperties("yzb")
@Component
public class Dept {
    private int id;
    private String name;
}
