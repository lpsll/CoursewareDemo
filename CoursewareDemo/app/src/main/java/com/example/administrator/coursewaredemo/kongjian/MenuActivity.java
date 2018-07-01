package com.example.administrator.coursewaredemo.kongjian;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.administrator.coursewaredemo.R;

/**
 * Created by Administrator on 2017/9/5.
 */

public class MenuActivity extends Activity implements View.OnLongClickListener {
    private ListView list;

    private Button btn1,btn2;

    private Object actionMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //第一个例子，ActionMode菜单（也属于ContextMenu）
        setContentView(R.layout.second);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnLongClickListener(this);


        //第二个例子，Popup弹出菜单
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                PopupMenu ppmenu = new PopupMenu(MenuActivity.this, v);
                ppmenu.getMenuInflater().inflate(R.menu.main, ppmenu.getMenu());
                ppmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem menu) {
                        // TODO Auto-generated method stub
                        switch (menu.getItemId()) {
                            case R.id.one:
                                Toast.makeText(MenuActivity.this, "one_show", Toast.LENGTH_LONG).show();
                                return true;
                            case R.id.two:
                                Toast.makeText(MenuActivity.this, "two_show", Toast.LENGTH_LONG).show();
                                return true;
                            case R.id.three:
                                Toast.makeText(MenuActivity.this, "three_show", Toast.LENGTH_LONG).show();
                                return true;

                            default:
                                return false;
                        }
                    }
                });
                ppmenu.show();

            }
        });






    }




    private class callback implements ActionMode.Callback{

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menu) {
            // TODO Auto-generated method stub
            switch (menu.getItemId()) {
                case R.id.one:
                    Toast.makeText(MenuActivity.this, "one_show", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.two:
                    Toast.makeText(MenuActivity.this, "two_show", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.three:
                    Toast.makeText(MenuActivity.this, "three_show", Toast.LENGTH_LONG).show();
                    return true;

                default:
                    return false;
            }

        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // TODO Auto-generated method stub
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // TODO Auto-generated method stub
            actionMode = null;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            // TODO Auto-generated method stub
            return false;
        }

    }

    @Override
    public boolean onLongClick(View v) {
        // TODO Auto-generated method stub
        if(actionMode != null){
            return false;
        }
        actionMode = startActionMode(new callback());
        v.setSelected(true);
        return true;

    }



}
