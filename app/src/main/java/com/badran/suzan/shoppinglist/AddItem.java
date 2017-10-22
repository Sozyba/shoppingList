package com.badran.suzan.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddItem extends AppCompatActivity {
    private EditText etName;
    private EditText etPrice;
    private EditText etAmount;
    private EditText etUnits;
    private Button btnSave;
    private ImageButton btnImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        etName=(EditText) findViewById(R.id.etName);
        etPrice=(EditText) findViewById(R.id.etPrice);
        etAmount=(EditText)findViewById(R.id.etAmount);
        etUnits=(EditText)findViewById(R.id.etUnits);
        btnSave= (Button) findViewById(R.id.btnSave);
        btnImage=(ImageButton) findViewById(R.id.btnImage);


    }
}
