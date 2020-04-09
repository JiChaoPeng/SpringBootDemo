package com.example.demo.xxxx.bean;

import javax.persistence.*;

@Entity
public class RoomBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private int age;
    private String image_url;
    private int level;
    private String name;
    private int owner_id;
    private int appIndex;

    public RoomBean() {
    }

    public RoomBean(String address, int age, String image_url, int level, String name, int ownerId, int appIndex) {
        this.name = name;
        this.owner_id = ownerId;
        this.level = level;
        this.age = age;
        this.image_url = image_url;
        this.address = address;
        this.appIndex = appIndex;
    }

    public int getAppIndex() {
        return appIndex;
    }

    public void setAppIndex(int appIndex) {
        this.appIndex = appIndex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
