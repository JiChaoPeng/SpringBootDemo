package com.example.demo.xxxx.service;

import com.example.demo.xxxx.bean.OrderUserBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class UserService implements JpaRepository<OrderUserBean, Integer> {
    public abstract int signUp(OrderUserBean orderUser);

    public abstract OrderUserBean signIn(String account , String password);

    public abstract List<OrderUserBean> findAllBean();

    public abstract OrderUserBean findByAccount(String account);
}
