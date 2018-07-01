package com.example.administrator.coursewaredemo.activity.demo3;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/6.
 */

public class Entity implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;
}
