package com.hoperun.controller;

import com.hoperun.pojo.User;
import com.hoperun.service.UserLoginService;
import com.hoperun.utils.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @descriptiom:用户登陆
 * @Author: 武政旭
 * @Date: 2019/7/31 16:45
 */
@Controller
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(Model model, User user, HttpServletRequest request){
        boolean bool = userLoginService.checkUser(user);
        if (bool == true){
            request.getSession().setAttribute("user",user);
            return "index";
        }else{
            model.addAttribute("error","用户名或密码错误");
            return "login";
        }
    }
    @RequestMapping("/addUser")
    public String addUser(Model model,User user) throws MyException {
        userLoginService.addUser(user);
        model.addAttribute("success","添加成功");
        return "login";
    }
}
