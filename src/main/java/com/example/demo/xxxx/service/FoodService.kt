package com.example.demo.xxxx.service

import com.example.demo.xxxx.bean.FoodBean


interface FoodService {

    fun addFood(food: FoodBean): Int

    fun findAllBean(roomId: String): List<FoodBean>?

    fun findByName(name: String): FoodBean

}
