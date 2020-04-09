package com.example.demo.xxxx.order.controller;

import com.example.demo.xxxx.bean.ResultBean;
import com.example.demo.xxxx.bean.ResultModel;
import com.example.demo.xxxx.order.bean.OrderFoodBean;
import com.example.demo.xxxx.order.bean.OrderFoodListBean;
import com.example.demo.xxxx.order.service.impl.OrderFoodServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static com.example.demo.xxxx.constant.NetConstantKt.ERROR;
import static com.example.demo.xxxx.constant.NetConstantKt.SUCCEED;

//返回json格式
@RestController
public class OrderFoodController {

    @Autowired
    @Resource
    private OrderFoodServiceImpl orderFoodService;

    @RequestMapping(
            params = {"name", "content", "price", "address", "imageUrl", "roomId"},
            method = {RequestMethod.POST},
            value = {"/order/v1/food/add"})
    public ResultBean addFood(@RequestParam("name") @NotNull String name,
                              @RequestParam("content") @NotNull String content,
                              @RequestParam("price") int price,
                              @RequestParam("address") @Nullable String address,
                              @RequestParam("imageUrl") @Nullable String imageUrl,
                              @RequestParam("roomId") int roomId) {
        return orderFoodService.addFood(new OrderFoodBean(name, content, price, imageUrl, address, roomId));

    }

    @RequestMapping(
            params = {"roomId"},
            method = {RequestMethod.POST},
            value = {"/order/v1/food/allbyid"}
    )
    public ResultBean<OrderFoodListBean> findAllFood(@RequestParam("roomId") String roomId) {
        return new ResultBean<>(SUCCEED, null, new OrderFoodListBean(orderFoodService.findAllBeanByRoomId(roomId)));
    }


    @RequestMapping(
            method = {RequestMethod.POST},
            value = {"/order/v1/food/all"}
    )
    public ResultBean<OrderFoodListBean> findAllFood() {
        return new ResultBean<>(SUCCEED, null, new OrderFoodListBean(orderFoodService.findAllBean()));
    }

    @RequestMapping({"/order/v1/food/Upload"})
    @NotNull
    public ResultModel uploadImage(@RequestParam(value = "file", required = false, defaultValue = "") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResultModel(ERROR, "图片为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        if (fileName != null) {
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名

            if (!suffixName.equals(".jpg") && suffixName.equals(".png")) {
                return new ResultModel(ERROR, " 请选择图片 ！！！");
            }
            String filePath = "/pic/food/";// 上传后的路径
            fileName = UUID.randomUUID().toString() + suffixName; // 新文件名
            File dest = new File(filePath + fileName);
            try {
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String filename = "http://39.99.210.2/pic/food/"+fileName;
        return new ResultModel(SUCCEED, filename);
    }


}
