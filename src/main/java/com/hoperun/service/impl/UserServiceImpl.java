package com.hoperun.service.impl;

import com.hoperun.dao.UserDao;
import com.hoperun.pojo.User;
import com.hoperun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @descriptiom:
 * @Author: 武政旭
 * @Date: 2019/7/29 15:49
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    public User selectUser(long userId) {
        return userDao.selectUser(userId);
    }
}
