package com.yzb.database.dao;

import com.yzb.database.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;

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
@Mapper
public interface IMessageMapper {
    List<StudentVO> list();
}