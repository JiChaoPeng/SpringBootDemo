package com.example.demo.xxxx.form.service.impl

import com.example.demo.xxxx.bean.ResultBean
import org.springframework.stereotype.Service
import javax.annotation.Resource
import com.example.demo.xxxx.constant.SUCCEED
import com.example.demo.xxxx.form.bean.FormBean
import com.example.demo.xxxx.form.dao.FormDao
import com.example.demo.xxxx.form.service.FormService

@Service("formService")
class FormServiceImpl : FormService {
    @Resource
    lateinit var formDao: FormDao

    override fun findByOwnerName(ownerName: String): List<FormBean>? {
        return formDao.findByOwnerName(ownerName)
    }

    override fun addForm(formBean: FormBean): ResultBean<FormBean> {
        formDao.save(formBean)
        return ResultBean(SUCCEED, null, formBean)

    }

    override fun findAllBean(): List<FormBean>? {
        return formDao.findAll()
    }

}
