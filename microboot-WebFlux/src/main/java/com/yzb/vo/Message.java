package com.yzb.vo;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * ClassName: Message
 * Description:
 * date: 2021/9/24 0:43
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class Message {
    private String title;
    private String content;
    private Date date;
}
