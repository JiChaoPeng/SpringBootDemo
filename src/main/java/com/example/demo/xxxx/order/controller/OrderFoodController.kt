package com.example.demo.xxxx.order.controller

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.bean.ResultModel
import com.example.demo.xxxx.order.bean.OrderFoodBean
import com.example.demo.xxxx.order.bean.OrderFoodListBean
import com.example.demo.xxxx.order.service.impl.OrderFoodServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

import javax.annotation.Resource

import java.io.File
import java.io.IOException
import java.util.UUID

import com.example.demo.xxxx.constant.ERROR
import com.example.demo.xxxx.constant.SUCCEED

//返回json格式
@RestController
class OrderFoodController {

    @Autowired
    @Resource
    lateinit var  orderFoodService: OrderFoodServiceImpl

    @RequestMapping(params = ["name", "content", "price", "address", "imageUrl", "roomId"], method = [RequestMethod.POST], value = ["/order/v1/food/add"])
    fun addFood(@RequestParam("name") name: String,
                @RequestParam("content") content: String,
                @RequestParam("price") price: Int,
                @RequestParam("address") address: String?,
                @RequestParam("imageUrl") imageUrl: String?,
                @RequestParam("roomId") roomId: Int): ResultBean<*> {
        return orderFoodService.addFood(OrderFoodBean(name, content, price, imageUrl, address, roomId))

    }

    @RequestMapping(params = ["roomId"], method = [RequestMethod.POST], value = ["/order/v1/food/allbyid"])
    fun findAllFood(@RequestParam("roomId") roomId: String): ResultBean<OrderFoodListBean> {
        return ResultBean(SUCCEED, null, OrderFoodListBean(orderFoodService.findAllBeanByRoomId(roomId)))
    }


    @RequestMapping(method = [RequestMethod.POST], value = ["/order/v1/food/all"])
    fun findAllFood(): ResultBean<OrderFoodListBean> {
        return ResultBean(SUCCEED, null, OrderFoodListBean(orderFoodService.findAllBean()))
    }

    @RequestMapping("/order/v1/food/Upload")
    fun uploadImage(@RequestParam(value = "file", required = false, defaultValue = "") file: MultipartFile): ResultModel {
        if (file.isEmpty) {
            return ResultModel(ERROR, "图片为空")
        }
        var fileName = file.originalFilename  // 文件名
        if (fileName != null) {
            val suffixName = fileName.substring(fileName.lastIndexOf("."))  // 后缀名

            if (suffixName != ".jpg" && suffixName == ".png") {
                return ResultModel(ERROR, " 请选择图片 ！！！")
            }
            val filePath = "/pic/food/"// 上传后的路径
            fileName = UUID.randomUUID().toString() + suffixName // 新文件名
            val dest = File(filePath + fileName)
            try {
                if (!dest.parentFile.exists()) {
                    dest.parentFile.mkdirs()
                }
                file.transferTo(dest)
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

        val filename = "http://39.99.210.2/pic/food/$fileName"
        return ResultModel(SUCCEED, filename)
    }


}
