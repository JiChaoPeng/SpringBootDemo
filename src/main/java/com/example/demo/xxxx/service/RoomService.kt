package com.example.demo.xxxx.service

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.RoomBean


interface RoomService {


    fun addRoom(bean: RoomBean): ResultBean<RoomBean>


    fun findAllBean(): List<RoomBean>?

    fun findByName(name: String): List<RoomBean>?

}
