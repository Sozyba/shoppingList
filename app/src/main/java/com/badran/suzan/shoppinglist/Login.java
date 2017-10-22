package com.badran.suzan.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private Button btnIn,btnUp;
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIn=(Button) findViewById(R.id.btnIn);
        btnUp=(Button)findViewById(R.id.btnUp);
       etEmail=(EditText) findViewById(R.id.etEmail);
        etPassword=(EditText) findViewById(R.id.etPassword);
        btnLog=(Button)findViewById(R.id.btnLog);
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),MainList2Activity.class);
                startActivity(i);
            }
        });
    }
}
