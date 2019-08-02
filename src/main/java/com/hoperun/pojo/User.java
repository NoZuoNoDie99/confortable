package com.hoperun.pojo;

import java.io.Serializable;

/**
 * @descriptiom:用户信息实体
 * @Author: 武政旭
 * @Date: 2019/7/31 15:00
 */
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private Integer userPassword;

    public User() {}

    public User(Integer userId, String userName, Integer userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(Integer userPassword) {
        this.userPassword = userPassword;
    }
}
