package com.example.demo.xxxx.service.impl

import com.example.demo.xxxx.bean.OrderUserBean
import com.example.demo.xxxx.constant.ERROR
import com.example.demo.xxxx.constant.SUCCEED
import com.example.demo.xxxx.dao.UserDao
import com.example.demo.xxxx.service.UserService
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service("userService")
class UserServiceImpl : UserService {

    @Resource
    lateinit var userDao: UserDao

    override fun findByAccount(account: String): OrderUserBean {
        return userDao.findByAccount(account)
    }

    override fun signUp(orderUser: OrderUserBean): Int {
        return try {
            userDao.save(orderUser)
            SUCCEED
        } catch (e: Exception) {
            ERROR
        }
    }

    override fun signIn(account: String, password: String): OrderUserBean? {
        val findByAccount = findByAccount(account)
        return if (findByAccount.account == account) {
            findByAccount
        } else {
            null
        }
    }

    override fun findAllBean(): List<OrderUserBean>? {
        return userDao?.findAll()
    }

}
