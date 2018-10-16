package com.appsplanet.test.saplmachine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,mpassword;
    Button login,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.username);
        mpassword=(EditText)findViewById(R.id.password);
        login=(Button) findViewById(R.id.login);
        cancel=(Button)findViewById(R.id.cancel) ;


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1=username.getText().toString();
                String str2=mpassword.getText().toString();
                if (str1.isEmpty()&&str2.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"plz enter Something",Toast.LENGTH_LONG).show();

                }else
                {
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);


                }



            }
        });




    }
}
