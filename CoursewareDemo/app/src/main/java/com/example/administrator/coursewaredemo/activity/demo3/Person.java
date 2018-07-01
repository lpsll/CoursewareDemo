package com.example.administrator.coursewaredemo.activity.demo3;

import java.io.Serializable;

import android.net.sip.SipRegistrationListener;

//Serializable的作用是将数据对象存入字节流当中，
//在需要时重新生成对象，主要应用是利用外部存储设备保存对象状态，以及通过网络传输对象等。
//在使用内存的时候，Parcelable比Serializable性能高，所以推荐使用Parcelable类。

public class Person implements Serializable {
	private String name;
	private int age;
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

}
