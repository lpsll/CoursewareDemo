package com.example.administrator.coursewaredemo.activity.demo3;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/2.
 */

public class DemoEntity implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

}
