package com.example.demo.xxxx.order.service.impl;


import com.example.demo.xxxx.bean.ResultBean;
import com.example.demo.xxxx.order.bean.OrderFoodBean;
import com.example.demo.xxxx.order.dao.OrderFoodDao;
import com.example.demo.xxxx.order.service.OrderFoodService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.xxxx.constant.NetConstantKt.ERROR;
import static com.example.demo.xxxx.constant.NetConstantKt.SUCCEED;

@Service("orderFoodService")
public class OrderFoodServiceImpl implements OrderFoodService {

    @Resource
    OrderFoodDao orderFoodDao;

    @NotNull
    @Override
    public ResultBean addFood(@NotNull OrderFoodBean foodBean) {
        try {
            List<OrderFoodBean> byName = orderFoodDao.findByName(foodBean.getName());
            if (byName != null && byName.size() > 0) {
                return new ResultBean(ERROR, "菜品已存在 ",null);
            } else {
                orderFoodDao.save(foodBean);
                return new ResultBean(SUCCEED, null, foodBean);
            }
        } catch (Exception e) {
            return new ResultBean(ERROR, "存储失败 ${e.message}  ${e.cause} ",null);
        }
    }

    @Nullable
    @Override
    public List findAllBean() {
        return orderFoodDao.findAll();
    }

    @Nullable
    @Override
    public List findAllBeanByRoomId(@NotNull String roomId) {
        List<OrderFoodBean> all = orderFoodDao.findAll();
        List<OrderFoodBean> listOf = new ArrayList<>();
        for (OrderFoodBean model :
                all) {
            if (roomId.equals(String.valueOf(model.getRoom_id()))) {
                listOf.add(model);
            }
        }
        return listOf;
    }

    @Nullable
    @Override
    public List findByName(@NotNull String name) {
        return orderFoodDao.findByName(name);

    }
}
