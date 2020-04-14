package com.example.demo.xxxx.form.service

import com.example.demo.xxxx.bean.ResultBean
import com.example.demo.xxxx.form.bean.FormBean
import com.example.demo.xxxx.order.bean.OrderFoodBean

interface FormService {
    fun addForm(formBean: FormBean): ResultBean<FormBean>

    fun findAllBean(): List<FormBean>?

    fun findByOwnerName(ownerName: String): List<*>?
}
