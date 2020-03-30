package com.example.demo.xxxx.service.impl

import com.example.demo.xxxx.bean.UserOrder
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

    override fun findByAccount(account: String): UserOrder {
        return userDao.findByAccount(account)
    }

    override fun signUp(user: UserOrder): Int {
        return try {
            userDao.save(user)
            SUCCEED
        } catch (e: Exception) {
            ERROR
        }
    }

    override fun signIn(account: String, password: String): UserOrder? {
        val findByAccount = findByAccount(account)
        return if (findByAccount.account == account) {
            findByAccount
        } else {
            null
        }
    }

    override fun findAllBean(): List<UserOrder>? {
        return userDao.findAll()
    }

}
