package com.asa.loginform;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by APRIJAL_PASARIBU on 16/04/2015.
 */
public class TodoActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.todo_layout);
        TextView tvTodo = (TextView)findViewById(R.id.tvTodo);
        tvTodo.setText(getIntent().getStringExtra("Nama"));
    }
}
