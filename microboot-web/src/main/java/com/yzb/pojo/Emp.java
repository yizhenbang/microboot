package com.yzb.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ClassName: Emp
 * Description:
 * date: 2021/8/22 2:09
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

// @Accessors(chain = true)
@Data
public class Emp {
    private int id;
    private String empno;
    private String empname;
}

