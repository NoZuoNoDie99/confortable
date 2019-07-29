package com.hoperun.dao;

import com.hoperun.pojo.User;

/**
 * @descriptiom:
 * @Author: 武政旭
 * @Date: 2019/7/29 15:48
 */
public interface UserDao {
    User selectUser(long id);
}
