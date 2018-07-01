package com.example.administrator.coursewaredemo.activity.demo3;

import android.os.Parcel;
import android.os.Parcelable;

//Parcel的序列化和反序列化的读写全是在内存中进行，所以效率比JAVA序列化中使用外部存储器会高很多。
//Parcelable不能使用在将数据存储在磁盘上的情况，
//因为Parcelable不能很好的保存数据的持续性在外界有变化的情况下。因此在这种情况下，建议使用Serializable
public class Police implements Parcelable {


	private String name;
	private int workTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWorkTime() {
		return workTime;
	}

	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}

	// 内容接口描述，默认返回0即可。
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		// TODO Auto-generated method stub
		parcel.writeString(name);
		parcel.writeInt(workTime);

	}


	public static final Parcelable.Creator<Police> CREATOR = new Creator<Police>() {

		//供反序列化本类数组时调用的
		@Override
		public Police[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Police[size];
		}

		// 在构造函数里面完成了 读取 的工作
		@Override
		public Police createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			Police police = new Police();
			police.name = source.readString();
			police.workTime = source.readInt();
			return police;
		}
	};



}
