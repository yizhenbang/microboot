package com.yzb.database.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yzb.database.enums.SexEnum;
import lombok.Builder;
import lombok.Data;

@Data
@TableName("haha")
@Builder
public class Haha {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private SexEnum sex;

    @TableField(exist = false)
    private Integer classea_Id;

    private Integer teacherId;
}

