package com.example.carnecertamobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Preferencias extends AppCompatActivity {

    Button btnMacia;
    Button btnBarata;
    Button btnMagra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        btnMacia = findViewById(R.id.btnMacia);
        btnBarata = findViewById(R.id.btnBarata);
        btnMagra = findViewById(R.id.btnMagra);

        String categoria =
                getIntent().getStringExtra("categoria");

        btnMacia.setOnClickListener(v -> {

            Intent tela = new Intent(
                    Preferencias.this,
                    CarnesActivity.class
            );

            tela.putExtra(
                    "categoria",
                    categoria
            );

            tela.putExtra(
                    "preferencia",
                    "macia"
            );

            startActivity(tela);

        });

        btnBarata.setOnClickListener(v -> {

            Intent tela = new Intent(
                    Preferencias.this,
                    CarnesActivity.class
            );

            tela.putExtra(
                    "categoria",
                    categoria
            );

            tela.putExtra(
                    "preferencia",
                    "barata"
            );

            startActivity(tela);

        });
        btnMagra.setOnClickListener(v -> {

            Intent tela = new Intent(
                    Preferencias.this,
                    CarnesActivity.class
            );

            tela.putExtra(
                    "categoria",
                    categoria
            );

            tela.putExtra(
                    "preferencia",
                    "magra"
            );

            startActivity(tela);

        });
    }
}