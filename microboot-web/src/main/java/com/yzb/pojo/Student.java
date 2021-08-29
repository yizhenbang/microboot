package com.yzb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * ClassName: Studemt
 * Description:
 * date: 2021/8/21 19:55
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
@XmlRootElement
public class Student {
    @XmlElement
    private int id;
    private String stuno;
    @XmlElement
    private String name;
    @XmlElement
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date time;//入学时间
    @XmlElement
    private Emp emp;
}
