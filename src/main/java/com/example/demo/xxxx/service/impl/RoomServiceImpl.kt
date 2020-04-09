package com.example.demo.xxxx.service.impl

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.RoomBean
import com.example.demo.xxxx.constant.ERROR
import com.example.demo.xxxx.constant.SUCCEED
import com.example.demo.xxxx.dao.RoomDao
import com.example.demo.xxxx.service.RoomService
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service("roomService")
class RoomServiceImpl : RoomService {

    @Resource
    lateinit var roomDao: RoomDao

    override fun findByName(name: String): List<RoomBean>? {
        return roomDao.findByName(name)
    }

    override fun addRoom(bean: RoomBean): ResultBean<RoomBean> {
        return try {
            val findByAccount = roomDao.findByName(bean.name)
            if ((findByAccount != null && findByAccount.isNotEmpty())) {
                ResultBean(ERROR, "饭店已存在 ")
            } else {
                roomDao.save(bean)
                ResultBean(SUCCEED, null, bean)
            }
        } catch (e: Exception) {
            ResultBean(ERROR, "存储失败 ${e.message}  ${e.cause} ")
        }
    }

    override fun findAllBean(): List<RoomBean>? {
        return roomDao.findAll()
    }

}
