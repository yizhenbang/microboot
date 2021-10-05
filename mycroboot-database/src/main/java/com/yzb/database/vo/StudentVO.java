package com.yzb.database.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ClassName: StudentVO
 * Description:
 * date: 2021/10/4 13:06
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
@TableName("student")
public class StudentVO {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String sex;
}
