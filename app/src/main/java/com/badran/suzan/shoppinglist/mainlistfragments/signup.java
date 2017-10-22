package com.badran.suzan.shoppinglist.mainlistfragments;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.badran.suzan.shoppinglist.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class signup extends AppCompatActivity {
    private EditText Name;
    private EditText Email;
    private EditText Password;
    private EditText Repassword;
    private Button Save;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Name = (EditText) findViewById(R.id.etName);
        Email = (EditText) findViewById(R.id.etEmail);
        Password = (EditText) findViewById(R.id.etPassword);
        Repassword = (EditText) findViewById(R.id.etREpassword);
        Save = (Button) findViewById(R.id.btnSave);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();

    }



private void dataHandler()
{
    String stEmail=Email.getText().toString();
    String stName=Name.getText().toString();
    String stPassword=Password.getText().toString();
    String stRepassword=Repassword.getText().toString();
    boolean isOk=true;
    if( (stEmail.length()==0) || stEmail.indexOf('@')<1)
    {
        Email.setError("wrong email");
        isOk=false;

    }
    if ((stPassword.length()<8) || stPassword.equals(stRepassword)==false)
    {
        Password.setError("Bad Password");
        isOk=false;

    }
    if (isOk)
    creatAcount(stEmail,stPassword);


}



private void creatAcount(String Email,String Password){
auth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            Toast.makeText(signup.this, "Authentication Successful", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(signup.this, "Authentication failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            task.getException().printStackTrace();
        }
    }


});
}
FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
if(user!= null){
        //User is signed in
}else{
        //No user is signed in

    }
private  void updateUserProfile(FirebaseUser user)
{
UserProfileChangeRequest.Builder builder=new UserProfileChangeRequest.Builder();
  builder.setDisplayName()
}