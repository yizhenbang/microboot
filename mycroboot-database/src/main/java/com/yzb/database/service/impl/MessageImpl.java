package com.yzb.database.service.impl;

import com.yzb.database.dao.IMessageMapper;
import com.yzb.database.service.IMessage;
import com.yzb.database.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private IMessageMapper iMessageMapper;

    @Override
    public List<StudentVO> list() {
        return iMessageMapper.list();
    }
}
