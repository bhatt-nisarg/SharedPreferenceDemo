package com.example.loginregapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    Button Delete,register;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        preferences = getSharedPreferences("DETAIL",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String display = preferences.getString("display","");

        TextView displayview = findViewById(R.id.textViewName);
        displayview.setText(display);

        Delete =  findViewById(R.id.Delete);


            Delete.setOnClickListener(view -> {
                editor.clear();
                editor.apply();
                Intent i = new Intent(DisplayActivity.this, MainActivity.class);
                startActivity(i);
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                prefs.edit().putBoolean("Islogin", false).commit();



            });

        register =  findViewById(R.id.regid);
        register.setOnClickListener(view -> {
            Intent intent = new Intent(DisplayActivity.this,Registeruser.class);
            startActivity(intent);
        });


    }
}