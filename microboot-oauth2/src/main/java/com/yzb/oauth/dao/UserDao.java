package com.yzb.oauth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzb.oauth.vo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {

}
