package com.example.carnecertamobile.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carnecertamobile.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new android.os.Handler().postDelayed(() -> {

            Intent telaLogin = new Intent(
                    Splash.this,
                    TeladeLogin.class
            );

            startActivity(telaLogin);

            finish();

        }, 2000);

    }
}