package com.example.demo.xxxx.order.service.impl


import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.order.bean.OrderFoodBean
import com.example.demo.xxxx.order.dao.OrderFoodDao
import com.example.demo.xxxx.order.service.OrderFoodService
import org.springframework.stereotype.Service

import javax.annotation.Resource
import java.util.ArrayList

import com.example.demo.xxxx.constant.ERROR
import com.example.demo.xxxx.constant.SUCCEED

@Service("orderFoodService")
class OrderFoodServiceImpl : OrderFoodService {

    @Resource
    lateinit var orderFoodDao: OrderFoodDao

    override fun addFood(foodBean: OrderFoodBean): ResultBean<OrderFoodBean> {
        return try {
            val byName = orderFoodDao.findByName(foodBean.name)
            if (byName != null && byName.isNotEmpty()) {
                ResultBean(ERROR, "菜品已存在 ", null)
            } else {
                orderFoodDao.save(foodBean)
                ResultBean(SUCCEED, null, foodBean)
            }
        } catch (e: Exception) {
            ResultBean(ERROR, "存储失败 \${e.message}  \${e.cause} ", null)
        }

    }

    override fun findAllBean(): List<OrderFoodBean>? {
        return orderFoodDao.findAll()
    }

    override fun findAllBeanByRoomId(roomId: String): List<OrderFoodBean>? {
        val all = orderFoodDao.findAll()
        val listOf = ArrayList<OrderFoodBean>()
        for (model in all) {
            if (roomId == model.room_id.toString()) {
                listOf.add(model)
            }
        }
        return listOf
    }

    override fun findByName(name: String): List<OrderFoodBean>? {
        return orderFoodDao.findByName(name)

    }
}
