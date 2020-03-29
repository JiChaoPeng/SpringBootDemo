package com.example.demo.xxxx.bean

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class OrderUserBean(
        val account: String,
        val password: String,
        val level: Int?,
        val age: Int?,
        val name: String?,
        val imageIndex: Int?,
        val imageUrl: String?,
        @Id
        @GeneratedValue
        val id: Int? = null)
