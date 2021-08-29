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
    @Excel(orderNum = "0",width = 10,name = "ID")
    private int id;
    @Excel(orderNum = "1",width = 50,name = "编号")
    private String empno;
    @Excel(orderNum = "2",width = 50,name = "名字")
    private String empname;
    @Excel(orderNum = "3",width = 50,name = "测试时间",databaseFormat = "yyyy-MM-dd",format = "yyyy-MM-dd HH:mm:ss:SSS")
    private Date testtime;
}

