package com.yzb.database.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yzb.database.enums.SexEnum;
import lombok.Builder;
import lombok.Data;

@Data
@TableName("teacher")
@Builder
public class Teacher {
    @TableId(type = IdType.AUTO)
    private Integer teacherId;

    private String teacherNo;

    private String teacherName;

    private SexEnum teacherSex;
}

