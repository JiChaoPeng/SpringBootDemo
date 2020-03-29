package com.example.demo.xxxx.controller;

import com.example.demo.xxxx.bean.OrderUserBean;
import com.example.demo.xxxx.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//返回json格式
@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/order/v1/signUp",method = RequestMethod.POST)
    int signUp(String account ,String password ,int level
            ,int age ,String name,int imageIndex, String imageUrl) {

        return userService.signUp(new OrderUserBean(account, password, level
                , age , name , imageIndex , imageUrl));


    }
    @RequestMapping(value = "/order/v1/signIn",method = RequestMethod.POST)
    OrderUserBean signIn(String account ,String password ){

        return userService.signIn(account, password);


    }
}
