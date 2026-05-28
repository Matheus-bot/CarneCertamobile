package com.example.carnecertamobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button btnCarnes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseHelper banco = new DataBaseHelper(this);

        banco.inserirCarnesIniciais();

        btnCarnes = findViewById(R.id.btnCarnes);

        btnCarnes.setOnClickListener(v -> {

            Intent tela = new Intent(
                    MainActivity.this,
                    CarnesActivity.class
            );

            startActivity(tela);

        });

    }
}