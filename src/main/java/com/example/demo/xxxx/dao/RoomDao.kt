package com.example.demo.xxxx.dao

import com.example.demo.xxxx.bean.RoomBean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomDao : JpaRepository<RoomBean, String> {
    fun findByName(name: String): List<RoomBean>?
}