package com.example.demo.xxxx.controller

import com.example.demo.xxxx.bean.OrderUserBean
import com.example.demo.xxxx.service.UserService
import com.example.demo.xxxx.service.impl.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

//返回json格式
@RestController
class UserController {

    @Autowired
    internal var userService: UserServiceImpl? = null


    @RequestMapping("/order/v1/signUp",method = [RequestMethod.POST])
    fun signUp(account: String, password: String, level: Int? = 0
               , age: Int? = null, name: String? = null, imageIndex: Int? = 0,
               imageUrl: String? = null): Int? {

        return userService?.signUp(OrderUserBean(account, password, level
                , age , name , imageIndex , imageUrl))


    }
    @RequestMapping("/order/v1/signIn",method = [RequestMethod.POST])
    fun signIn(account: String, password: String): OrderUserBean? {

        return userService?.signIn(account, password)


    }

}
