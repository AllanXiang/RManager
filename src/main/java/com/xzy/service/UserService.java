package com.xzy.service;

import com.xzy.model.User;

/**
 * Created by xzy on 2015-01-08 8:38 PM.
 */
public interface UserService {
    public User getUser(String userName, String userPwd);
}
