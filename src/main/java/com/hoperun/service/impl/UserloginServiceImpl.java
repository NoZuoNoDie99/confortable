package com.hoperun.service.impl;

import com.hoperun.mapper.UserLoginMapper;
import com.hoperun.pojo.User;
import com.hoperun.service.UserLoginService;
import com.hoperun.utils.MyException;
import com.hoperun.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @descriptiom:用户登陆实现类
 * @Author: 武政旭
 * @Date: 2019/7/31 15:19
 */
@Service
public class UserloginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginMapper userLoginMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public boolean checkUser(User user) {
        //1.先从缓存里面判断是否有数据,没有再去数据库找
        User userRedis = (User) redisUtil.get(user.getUserName());
        if (userRedis != null){
            if (userRedis.getUserPassword().equals(user.getUserPassword())){
                System.out.println("用户名:"+userRedis.getUserName()+"密码:"+userRedis.getUserPassword());
                return true;
            }
        }
        int i = userLoginMapper.checkedUser(user);
        if (i>0){
            //将数据放入缓存并设置过期时间
            boolean bool = redisUtil.set(user.getUserName(), user, 600);
            System.out.println(bool==false?"添加缓存失败!":"添加缓存成功!");
            return true;
        }
        return false;
    }

    /**
     * 用@Transactional实现spring事务管理和redis事务管理，为了验证事务的回滚，定义添加超过两笔记录即抛出自定义异常
     * @param user
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void addUser(User user) throws MyException {
        for (int i=0; i<5; i++){
            userLoginMapper.addUser(user);
            redisUtil.set(user.getUserName(),user);
            if (i>=2){
                throw new MyException("最多只能插入两笔记录");
            }
        }
    }
}
