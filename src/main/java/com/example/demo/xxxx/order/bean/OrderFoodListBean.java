package com.example.demo.xxxx.order.bean;

import java.util.List;

public class OrderFoodListBean {
   private List<OrderFoodBean> list ;

    public List<OrderFoodBean> getList() {
        return list;
    }

    public void setList(List<OrderFoodBean> list) {
        this.list = list;
    }

    public OrderFoodListBean(List<OrderFoodBean> list) {
        this.list = list;
    }
}
