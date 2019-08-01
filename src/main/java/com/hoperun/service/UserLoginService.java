package com.hoperun.service;

import com.hoperun.pojo.User;
import com.hoperun.utils.MyException;

/**
 * @descriptiom:
 * @Author: 武政旭
 * @Date: 2019/7/31 15:17
 */
public interface UserLoginService {
    boolean checkUser(User user);
    void addUser(User user) throws MyException;
}
