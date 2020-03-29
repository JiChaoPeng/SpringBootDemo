package com.example.demo.xxxx.dao

import com.example.demo.xxxx.bean.OrderUserBean
import org.springframework.data.jpa.repository.JpaRepository

interface OrderUserRepository : JpaRepository<OrderUserBean,Int>{
}