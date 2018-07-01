package com.example.administrator.coursewaredemo.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

public class DyCheckBoxActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dy_check_box);
        //获取提交按钮
        Button btnOK = (Button) this.findViewById(R.id.btn);
        btnOK.setOnClickListener(this);

    }

    String str;
    @Override
    public void onClick(View v) {

        str="";
        CheckBox cb1Group1 = (CheckBox) findViewById(R.id.cb1);
        CheckBox cb1Group2 = (CheckBox) findViewById(R.id.cb2);
        CheckBox cb1Group3 = (CheckBox) findViewById(R.id.cb3);
        CheckBox cb1Group4 = (CheckBox) findViewById(R.id.cb4);

        if(!cb1Group1.isChecked() && !cb1Group2.isChecked()&&
                !cb1Group3.isChecked()&& !cb1Group4.isChecked()){
            str = "您至少要选择一个答案！";
        }
        if (cb1Group1.isChecked()){
            str += cb1Group1.getText() + "\n";
        }
        if (cb1Group2.isChecked()){
            str += cb1Group2.getText() + "\n";
        }
        if (cb1Group3.isChecked()){
            str += cb1Group3.getText() + "\n";
        }
        if (cb1Group4.isChecked()){
            str += cb1Group4.getText() + "\n";
        }

        Toast textToast = Toast.makeText(this, str,Toast.LENGTH_LONG);
        textToast.setGravity(Gravity.TOP, 0, 300);
        textToast.show();

    }
}
