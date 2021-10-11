package com.yzb.database.service.impl;

import com.yzb.database.dao.yzb.TeacherMapper;
import com.yzb.database.dao.yzhenb.StudentMapper;
import com.yzb.database.service.IMessage;
import com.yzb.database.vo.Haha;
import com.yzb.database.vo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName: MessageImpl
 * Description:
 * date: 2021/10/4 19:12
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Service
public class MessageImpl implements IMessage {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void addAll(Map<Teacher, List<Haha>> map) {
        for (Map.Entry<Teacher, List<Haha>> temp : map.entrySet()) {
            Teacher key = temp.getKey();
            teacherMapper.insert(key);
            for (Haha stu : temp.getValue()) {
                studentMapper.insert(stu);
            }
        }
    }
}
