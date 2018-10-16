package com.appsplanet.test.saplmachine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    private TextView id,name,last,avatar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        id=findViewById(R.id.data);
        name=findViewById(R.id.name);
        last=findViewById(R.id.lastname);
        avatar1=findViewById(R.id.avatar);

        Intent intent=getIntent();
        String mid=intent.getStringExtra("dataid");
        String mname=intent.getStringExtra("dataname");
        String lastname=intent.getStringExtra("lastname");
        String avatar=intent.getStringExtra("avatar");

        Log.e("Datagot",mid);
        Log.e("dataname",mname);
        Log.e("lastname",lastname);
        Log.e("avatar",avatar);

        id.setText(mid);
        name.setText(mname);
        last.setText(lastname);
        avatar1.setText(avatar);


    }
}
