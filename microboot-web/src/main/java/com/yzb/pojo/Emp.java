package com.yzb.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * ClassName: Emp
 * Description:
 * date: 2021/8/22 2:09
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Data
public class Emp {
    private int id;
    private String empno;
    private String empname;
}

