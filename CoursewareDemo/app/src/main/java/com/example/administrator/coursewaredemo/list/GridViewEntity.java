package com.example.administrator.coursewaredemo.list;

/**
 * Created by Administrator on 2018/5/21.
 */

//定义实体类，设置get和set方法（set方法是设置数据，get方法是取出数据）
public class GridViewEntity {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    private int pic;
}
