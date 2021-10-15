package com.yzb.oauth.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yzb.oauth.dao.UserDao;
import com.yzb.oauth.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserDetailsServiceHandler implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("卧槽我进来了");
        if (!StringUtils.hasLength(username)) {
            throw new UsernameNotFoundException("没有用户名存在，请重新输入");
        }
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", username);
        User user = userDao.selectOne(userQueryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("没有用户名存在，请重新输入");
        }

        List<GrantedAuthority> list = AuthorityUtils.createAuthorityList("oauth", "ROLE_admin");

        return new org.springframework.security.core.userdetails.User(user.getName(), this.passwordEncoder.encode(user.getPassword()), list);
    }
}
