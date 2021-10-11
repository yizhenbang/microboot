package com.yzb.database.service;

import com.yzb.database.vo.Haha;
import com.yzb.database.vo.Teacher;

import java.util.List;
import java.util.Map;

/**
 * ClassName: IMessage
 * Description:
 * date: 2021/10/4 19:11
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
public interface IMessage {
    void addAll(Map<Teacher, List<Haha>> map);
}
