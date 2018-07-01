package com.example.administrator.coursewaredemo.list;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/23.
 */

public class Entity implements Serializable {
    private int img;
    private int price;
    private String title;
    private String msg;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;



}
