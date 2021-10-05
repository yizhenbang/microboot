package com.yzb.database.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yzb.database.vo.StudentVO;

import java.util.List;

/**
 * ClassName: IMessage
 * Description:
 * date: 2021/10/4 19:11
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
public interface IMessage extends IService<StudentVO> {
    List<StudentVO> mylist();
}
