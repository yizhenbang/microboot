package com.yzb.database.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzb.database.vo.StudentVO;

import java.util.List;

/**
 * ClassName: IMessageMapper
 * Description:
 * date: 2021/10/4 21:45
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
//@Mapper
public interface IMessageMapper extends BaseMapper<StudentVO> {
    List<StudentVO> list();
}
