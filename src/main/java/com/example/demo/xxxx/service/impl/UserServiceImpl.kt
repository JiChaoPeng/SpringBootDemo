package com.example.demo.xxxx.service.impl

import com.example.demo.xxxx.bean.OrderUserBean
import com.example.demo.xxxx.constant.ERROR
import com.example.demo.xxxx.constant.SUCCEED
import com.example.demo.xxxx.dao.OrderUserRepository
import com.example.demo.xxxx.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service("userService")
interface UserServiceImpl : UserService {
    override fun signUp(orderUser: OrderUserBean): Int {
        return try {
            save(orderUser)
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

    override fun findAllBean(): List<OrderUserBean> {
        return findAll()
    }

}
