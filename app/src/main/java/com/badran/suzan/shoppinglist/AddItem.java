package com.badran.suzan.shoppinglist;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.badran.suzan.shoppinglist.data.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        etName = (EditText) findViewById(R.id.etName);
        etPrice = (EditText) findViewById(R.id.etPrice);
        etAmount = (EditText) findViewById(R.id.etAmount);
        etUnits = (EditText) findViewById(R.id.etUnits);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnImage = (ImageButton) findViewById(R.id.btnImage);

    }

    public void dataHander()
            //1.get data from the fields
    {
        String stname = etName.getText().toString();
        String stprice = etPrice.getText().toString();
        String stamount = etAmount.getText().toString();
        String stunits = etUnits.getText().toString();
        //2. todo Validate fields input
        //isok=true;...

        //3.data manipulation
        double amount = Double.parseDouble(stamount);
        double price = Double.parseDouble(stprice);

        //4.building data objects
        Product p=new Product();
        p.setName(stname);
        p.setAmount(amount);
        p.setPrice(price);
        p.setCompleted(false);


        //5.to get user emails...user info
        //to get user emaill...user info
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String email = user.getEmail();
        email = email.replace('.', '*');


        //6.bulding data refernce = data path= ata address
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference();

        //7
        reference.child(email).child("myList").push().setValue(p).
                addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(AddItem.this, "Add Product Successful", Toast.LENGTH_SHORT);
                        } else {
                            Toast.makeText(AddItem.this, "Add Product Failed", Toast.LENGTH_SHORT);
                        }
                    }
                });



        //todo Testing
        reference.child("List").setPriority("soso");
    }
}


