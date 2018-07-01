package com.example.administrator.coursewaredemo.activity.demo3;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/8.
 */

public class Students implements Serializable {
    private String name;
    private String age;
    private String num;
    private String cs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }

}
