package com.example.demo.xxxx.service

import com.example.demo.xxxx.bean.OrderUserBean
import org.springframework.data.jpa.repository.JpaRepository


interface UserService {


    fun signUp(orderUser: OrderUserBean): Int

    fun signIn(account: String, password: String): OrderUserBean?

    fun findAllBean(): List<OrderUserBean>?

    fun findByAccount(account: String): OrderUserBean

}
