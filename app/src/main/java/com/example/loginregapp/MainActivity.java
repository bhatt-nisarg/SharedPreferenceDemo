package com.example.loginregapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etname,etpassword;
    Button btnLogin,btnregister;
    public Boolean IsLogin = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname =  findViewById(R.id.txtusername);
        etpassword = findViewById(R.id.txtpassword);
        btnLogin =  findViewById(R.id.submit);
        btnregister =  findViewById(R.id.register);



        btnLogin.setOnClickListener(view -> {
            String user = etname.getText().toString();
            String password = etpassword.getText().toString();
            SharedPreferences preferences = getSharedPreferences("DETAIL",MODE_PRIVATE);

            if (etname.getText().length() <= 0){
                etname.setError("Enter name");
            }
            else if(etpassword.getText().length() <= 0 || etpassword.getText().length() < 8 ){
                Toast.makeText(getApplicationContext(),"Enter Valid password",Toast.LENGTH_LONG).show();
            }

            else {

                Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();

                String userDetails = preferences.getString(user + password + "data", "No Information on that user.");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display", userDetails);
                editor.apply();

                Intent displaydata = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(displaydata);
                //it is for check that user is login or not

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                prefs.edit().putBoolean("Islogin", IsLogin).commit();
            }
        });
        btnregister.setOnClickListener(view -> {
            Intent reisterdata = new Intent(MainActivity.this,Registeruser.class);
            startActivity(reisterdata);
        });


    }
}