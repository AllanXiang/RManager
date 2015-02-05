package com.xzy.service.impl;

import com.xzy.dao.UserMapper;
import com.xzy.model.User;
import com.xzy.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xzy on 2015-01-08 8:47 PM.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(String userName, String userPwd) {
        return userMapper.selectByUsernamePwd(userName, DigestUtils.md5Hex(userPwd));
    }
}
