package com.example.demo.xxxx.order.service

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.order.bean.OrderFoodBean

interface OrderFoodService {
    fun addFood(foodBean: OrderFoodBean): ResultBean<OrderFoodBean>

    fun findAllBean(): List<OrderFoodBean>?

    fun findAllBeanByRoomId(roomId: String): List<OrderFoodBean>?

    fun findByName(name: String): List<*>?
}
