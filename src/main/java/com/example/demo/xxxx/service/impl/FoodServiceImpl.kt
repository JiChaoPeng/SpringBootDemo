package com.example.demo.xxxx.service.impl

import com.example.demo.xxxx.bean.FoodBean
import com.example.demo.xxxx.constant.ERROR
import com.example.demo.xxxx.constant.SUCCEED
import com.example.demo.xxxx.dao.FoodDao
import com.example.demo.xxxx.service.FoodService
import org.springframework.stereotype.Service
import javax.annotation.Resource
@Service("foodService")
class FoodServiceImpl : FoodService {

    @Resource
    lateinit var foodDao: FoodDao

    override fun addFood(food: FoodBean): Int {
        return try {
            foodDao.save(food)
            SUCCEED
        } catch (e: Exception) {
            ERROR
        }
    }

    override fun findByName(name: String): FoodBean {
        return foodDao.findByName(name)
    }

    override fun findAllBean(roomId: String): List<FoodBean>? {
        val foods = foodDao.findAll()
        val listOf = arrayListOf<FoodBean>()
        foods.forEach {
            if (roomId.toInt() == it.roomId){
                listOf.add(it)
            }
        }
        return listOf
    }

}
