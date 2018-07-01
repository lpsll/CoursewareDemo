package com.example.administrator.coursewaredemo.kongjian;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.administrator.coursewaredemo.R;

public class EditTextTwoActivity extends AppCompatActivity {
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_two);
        edit = (EditText) findViewById(R.id.edit);
        edit.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                String str = edit.getText().toString().trim();
                try {
                    Integer.parseInt(str);
                } catch (Exception e) {
                    showDialog();
                }



            }
            private void showDialog() {
                AlertDialog dialog;
                AlertDialog.Builder bulider = new AlertDialog.Builder(EditTextTwoActivity.this);
                bulider.setTitle("消息").setIcon(android.R.drawable.stat_notify_error);
                bulider.setMessage("你输入的整型数字有误，请改正");
                bulider.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int arg1) {

                    }
                });
                dialog = bulider.create();
                dialog.show();


            }

        });




    }


    }