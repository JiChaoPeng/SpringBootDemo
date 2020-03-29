package com.example.demo.xxxx.service.impl;

import com.example.demo.xxxx.bean.OrderUserBean;
import com.example.demo.xxxx.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.xxxx.constant.NetConstant.ERROR;
import static com.example.demo.xxxx.constant.NetConstant.SUCCEED;


@Service("userService")
public abstract class UserServiceImpl extends UserService {

    @Override
    public int signUp(OrderUserBean orderUser) {
        try {
            save(orderUser);
            return SUCCEED;
        } catch (Exception e) {
            return ERROR;
        }
    }

    @Nullable
    @Override
    public OrderUserBean signIn(@NotNull String account, @NotNull String password) {
        OrderUserBean findByAccount = findByAccount(account);
        if (findByAccount.getAccount().equals(account)) {
            return findByAccount;
        } else {
            return null;
        }
    }

    @Override
    public List<OrderUserBean> findAllBean() {
        return findAll();
    }
}
