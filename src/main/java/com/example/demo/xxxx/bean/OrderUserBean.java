package com.example.demo.xxxx.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderUserBean {
    private String  account;
    private String password;
    private int level;
    private int age;
    private String name;
    private int imageIndex;
    private  String imageUrl;
    @Id
    @GeneratedValue
    private int id;

    public OrderUserBean(String account, String password, int level, int age, String name, int imageIndex, String imageUrl) {
        this.account = account;
        this.password = password;
        this.level = level;
        this.age = age;
        this.name = name;
        this.imageIndex = imageIndex;
        this.imageUrl = imageUrl;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageIndex() {
        return imageIndex;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
