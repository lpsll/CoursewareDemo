package com.example.administrator.coursewaredemo.kongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.coursewaredemo.R;

public class EditTextActivity extends AppCompatActivity {

    private TextView text;
    private EditText edit;
    private Button btn;
    final int Max = 20;
    int Rest_Length = Max;
    private static final String TAG="edittext";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        text = (TextView) findViewById(R.id.text);
        edit = (EditText) findViewById(R.id.edit);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                edit.setText("");
                Rest_Length = Max;
                text.setText("还能输入"+Rest_Length+"数字");
            }
        });




        edit.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {

                Log.e(TAG, "text"+Rest_Length);
                if(Rest_Length>0){
                    Rest_Length = Max-edit.getText().length();
                }
                Log.e(TAG, "-->text"+Rest_Length);

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                text.setText("还能输入"+Rest_Length+"数字");
                Log.e(TAG, "-->before"+Rest_Length);
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                text.setText("还能输入"+Rest_Length+"数字");
                Log.e(TAG, "-->after"+Rest_Length);
            }
        });

    }
}
