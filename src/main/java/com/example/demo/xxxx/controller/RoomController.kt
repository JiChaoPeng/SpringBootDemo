package com.example.demo.xxxx.controller

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.RoomBean
import com.example.demo.xxxx.bean.RoomListBean
import com.example.demo.xxxx.constant.SUCCEED
import com.example.demo.xxxx.service.impl.RoomServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import javax.annotation.Resource


//返回json格式
@RestController
class RoomController {
    @Autowired
    @Resource
    internal var roomService: RoomServiceImpl? = null

    @RequestMapping("/android/v1/addRoom",
            params = ["name", "ownerId", "level", "age", "imageUrl", "address", "appIndex"],
            method = [RequestMethod.POST])
    fun addRoom(@RequestParam("name") name: String,
                @RequestParam("ownerId") ownerId: Int = 1,
                @RequestParam("level") level: Int = 0,
                @RequestParam("age") age: Int = 0,
                @RequestParam("imageUrl") imageUrl: String? = null,
                @RequestParam("address") address: String? = null,
                @RequestParam("appIndex") appIndex: Int = 0): ResultBean<RoomBean>? {
        return roomService?.addRoom(RoomBean(address, age, imageUrl, level, name, ownerId,appIndex
        ))
    }

    @RequestMapping("/android/v1/rooms",
            method = [RequestMethod.GET])
    fun rooms(): ResultBean<RoomListBean>? {
        return ResultBean(SUCCEED, roomService?.findAllBean().toString())

    }

    @RequestMapping("/android/v1/findRoom",
            params = ["name"],
            method = [RequestMethod.POST])
    fun findRoom(@RequestParam("name") name: String): ResultBean<RoomListBean>? {
        return ResultBean(SUCCEED, roomService?.findByName(name).toString())

    }

}
