package com.example.loginregapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registeruser extends AppCompatActivity {
     EditText username,Useremail,Userpassword;
     Button btnregister;
     String newUser,newEmail,newpassword;
     String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeruser);

        username =  findViewById(R.id.name);
        Useremail =  findViewById(R.id.email);
        Userpassword =  findViewById(R.id.password);
        btnregister =  findViewById(R.id.register);

        btnregister.setOnClickListener(view -> {
            SharedPreferences preferences = getSharedPreferences("DETAIL",MODE_PRIVATE);
            newUser = username.getText().toString();
            newEmail = Useremail.getText().toString();
            newpassword = Userpassword.getText().toString();

            SharedPreferences.Editor editor = preferences.edit();

            if (username.getText().length() <= 0 ){
                username.setError("Enter  Username");
            }
            else if(Useremail.getText().length() <= 0 || !(Useremail.getText().toString().trim().matches(emailPattern))){
                Useremail.setError("Enter Valid Email");}
            else if(Userpassword.getText().length() <= 0 || Userpassword.getText().length() < 8 ){
                Userpassword.setError("Enter atleast 8 Character password");
            }
            else {

            //stores 3 new sharedprefs.both the user and password's keys are the same as the input.
            //must be  done this way because sharedprefs is stupid and inefficient . you can't store arrays easily
            editor.putString(newUser,newUser);
            editor.apply();
            editor.putString(newpassword,newpassword);
            editor.apply();
            editor.putString(newUser + newpassword + "data",newUser + "\n" + newEmail);
            editor.apply();

            Intent i = new Intent(Registeruser.this,MainActivity.class);
            Toast.makeText(getApplicationContext(),"User Registered Successfully",Toast.LENGTH_SHORT).show();
            startActivity(i);


            }
        });

    }
}