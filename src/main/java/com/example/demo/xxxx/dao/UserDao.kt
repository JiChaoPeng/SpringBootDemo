package com.example.demo.xxxx.dao

import com.example.demo.xxxx.bean.OrderUserBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao : JpaRepository<OrderUserBean, Int> {
    fun findByAccount(account: String): OrderUserBean
}