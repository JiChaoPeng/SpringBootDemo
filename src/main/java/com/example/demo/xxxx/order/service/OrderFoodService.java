package com.example.demo.xxxx.order.service;

import com.example.demo.xxxx.bean.ResultBean;
import com.example.demo.xxxx.order.bean.OrderFoodBean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface OrderFoodService {
    @NotNull
    ResultBean addFood(@NotNull OrderFoodBean foodBean);

    @Nullable
    List findAllBean();

    @Nullable
    List findAllBeanByRoomId(@NotNull String roomId);

    @Nullable
    List findByName(@NotNull String name);
}
