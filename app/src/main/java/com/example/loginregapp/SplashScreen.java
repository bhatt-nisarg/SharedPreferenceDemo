package com.example.loginregapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {
    private static final int SPLASH_SCREEN_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);

        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(SplashScreen.this);
                boolean isLogin = prefs.getBoolean("Islogin", false);

                if (isLogin){
                    Intent i = new Intent(SplashScreen.this,DisplayActivity.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(SplashScreen.this,Registeruser.class);
                    startActivity(i);
                }

            }
        },SPLASH_SCREEN_TIME_OUT);



    }

}