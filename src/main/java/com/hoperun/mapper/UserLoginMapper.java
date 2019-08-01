package com.hoperun.mapper;


import com.hoperun.pojo.User;

/**
 * @descriptiom:用户登陆接口
 * @Author: 武政旭
 * @Date: 2019/7/31 14:58
 */
public interface UserLoginMapper {
    //用户验证方法
    public int checkedUser(User user);

    //添加用户
    public void addUser(User user);
}
