package com.example.demo.xxxx.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodBean {
    private String name;
    private String content;
    private int sale;
    private int price;
    private String imageUrl;
    private String address;
    private int roomId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;

    public FoodBean() {

    }

    public FoodBean(String name, String content, int sale, int price, String imageUrl, String address, int roomId) {
        this.name = name;
        this.content = content;
        this.sale = sale;
        this.price = price;
        this.imageUrl = imageUrl;
        this.address = address;
        this.roomId = roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
