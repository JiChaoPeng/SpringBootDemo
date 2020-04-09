package com.example.demo.xxxx.order.dao;

import com.example.demo.xxxx.order.bean.OrderFoodBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public
interface OrderFoodDao extends JpaRepository<OrderFoodBean, String> {
    List<OrderFoodBean> findByName(String name );
}
