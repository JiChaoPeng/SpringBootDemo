package com.example.demo.xxxx.controller

import com.example.demo.xxxx.bean.FoodBean
import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.constant.ERROR
import com.example.demo.xxxx.constant.SUCCEED
import com.example.demo.xxxx.service.impl.FoodServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource
import java.io.IOException
import java.util.UUID
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.bind.annotation.PostMapping
import java.io.File


//返回json格式
@RestController
class FoodController {

    @Autowired
    @Resource
    internal var foodService: FoodServiceImpl? = null

    @RequestMapping("/android/v1/food/add",
            params = ["name", "content", "sale", "price", "address", "imageUrl", "roomId"],
            method = [RequestMethod.POST])
    fun addFood(@RequestParam("name") name: String,
                @RequestParam("content") content: String,
                @RequestParam("sale") sale: Int = 0,
                @RequestParam("price") price: Int = 0,
                @RequestParam("address") address: String? = null,
                @RequestParam("imageUrl") imageUrl: String?,
                @RequestParam("roomId") roomId: Int): ResultBean? {
        return ResultBean(SUCCEED, foodService?.addFood(FoodBean(name, content, sale
                , price, address, imageUrl, roomId)).toString())
    }

    @RequestMapping("/android/v1/food/all",
            params = ["roomId"],
            method = [RequestMethod.POST])
    fun findAllFood(@RequestParam("roomId") roomId: String): ResultBean? {
        return ResultBean(SUCCEED, foodService?.findAllBean(roomId).toString())

    }

    @RequestMapping(value = ["/android/v1/food/Upload"] )
    @Throws(Exception::class)
    fun uploadImage(@RequestParam(value = "file",required = false, defaultValue = "") file: MultipartFile): ResultBean {
        if (file.isEmpty) {
            println("文件为空空")
        }
        var fileName = file.originalFilename  // 文件名
        val suffixName = fileName?.substring(fileName.lastIndexOf("."))  // 后缀名
        if (suffixName != ".jpg" && suffixName != ".png") {
            return ResultBean(ERROR, "", " 请选择图片 ！！！")
        }
        val filePath = "/pic/food/" // 上传后的路径
        fileName = UUID.randomUUID().toString() + suffixName // 新文件名
        val dest = File(filePath + fileName)
        if (!dest.parentFile.exists()) {
            dest.parentFile.mkdirs()
        }
        try {
            file.transferTo(dest)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val filename = "/temp-rainy/$fileName"
        return ResultBean(SUCCEED, filename,filePath)
    }


}
