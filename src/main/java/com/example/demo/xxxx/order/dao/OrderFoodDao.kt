package com.example.demo.xxxx.order.dao

import com.example.demo.xxxx.order.bean.OrderFoodBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface OrderFoodDao : JpaRepository<OrderFoodBean, String> {
    fun findByName(name: String): List<OrderFoodBean>?
}
