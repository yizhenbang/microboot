package com.yzb.database.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * ClassName: SexEnum
 * Description:
 * date: 2021/10/10 9:37
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
public enum SexEnum {
    MAX("男", 1), WOMAN("女", 0);

    SexEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    private String name;
    @EnumValue
    private Integer code;
}
