package com.example.administrator.coursewaredemo.activity.demo3;


import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

import com.example.administrator.coursewaredemo.R;

public class FsActivity extends Activity {
	private Button btn,btn1,btn2;
	private TextView text;
	private EditText edit1,edit2,edit3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fs);
        btn1 = (Button) findViewById(R.id.mbtn1);
        btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(FsActivity.this,SerializableActivity.class);

				Entity entity = new Entity();
				entity.setName("学生a");
				entity.setAge(18);

				Bundle bundle = new Bundle();
				bundle.putSerializable("bundler",entity);
				intent.putExtra("entity",bundle);

				startActivity(intent);

			}


		});

	}
   

}
