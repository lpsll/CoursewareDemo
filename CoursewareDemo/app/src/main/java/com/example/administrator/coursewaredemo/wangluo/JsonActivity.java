package com.example.administrator.coursewaredemo.wangluo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2017/9/6.
 */

public class JsonActivity extends Activity {
    private static final String JSONString = "{" + "\"phone\":[\"12345678\",\"87654321\"],"
            + "\"name\":\"tianjiefeng\"," + "\"age\":100,"
            + "\"address\":{\"country\":\"china\",\"province\":\"jiangsu\"},"
            + "\"married\":false" + "}";

    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

//        initJson();
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);


        JSONObject objects = createJSONObject();

        // 解析得到一个Map对象
        Map<String, Object> personMap = parserJSONString(JSONString);
        String  str = "phone:" + personMap.get("phone") + "\n" + "name:" + personMap.get("name") + "\n"
                + "age:" + personMap.get("age") + "\n" + "address:"
                + personMap.get("address") + "\n" + "married:" + personMap.get("married");
        Log.e("TAG", str);


        tv1.setText(objects.toString());
        tv2.setText(str);


    }

    private void initJson() {
        //例子一，创建一个JSON对象，并写入存储卡文件
        //添加权限 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
        // 不存在不操作
//        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
//        	 // 返回到程序的被调用出
//        	return;
//        }
//        // 将JSON对象写入存储卡
//        writeJSONObjectToSdCard(createJSONObject());

    }


    /**
     * JSON解析
     *
     * @param JSONString
     * @return
     */

    private Map<String, Object> parserJSONString(String JSONString) {
        // TODO Auto-generated method stub
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            // 直接把JSON字符串转化为一个JSONObject对象
            JSONObject person = new JSONObject(JSONString);
            // 第1个键值对
            resultMap.put("phone", person.getJSONArray("phone").toString());
            // 第2个键值对
            resultMap.put("name", person.getString("name"));
            // 第3个键值对
            resultMap.put("age", person.getInt("age"));
            // 第4个键值对
            resultMap.put("address", person.getJSONObject("address").toString());
            // 第5个键值对
            resultMap.put("married", person.getBoolean("married"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }


    private JSONObject createJSONObject() {
        // TODO Auto-generated method stub
        JSONObject person = new JSONObject();
        try {
            JSONArray phone = new JSONArray();
            phone.put("1234567");
            phone.put("7654321");

            person.put("phone", phone);
            person.put("name", "sssss");
            person.put("age", 40);

            JSONObject adress = new JSONObject();
            adress.put("a", "lilili");
            adress.put("b", "ddddsafe");

            person.put("adress", adress);

            person.put("b", false);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

    /**
     * 将JSON对象写入存储卡
     * @param person
     */

    private void writeJSONObjectToSdCard(JSONObject person) {
        // TODO Auto-generated method stub
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "json"
                + File.separator + "json.txt");
        // 文件夹不存在的话，就创建文件夹
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        // 写入内存卡
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(file));
            ps.print(person.toString());
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            if(ps!=null){
                ps.close();
            }
        }
    }

}
