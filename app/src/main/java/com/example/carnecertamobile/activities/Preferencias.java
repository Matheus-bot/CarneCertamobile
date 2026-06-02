package com.example.carnecertamobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carnecertamobile.R;

public class Preferencias extends AppCompatActivity {

    Button btnMacia;
    Button btnBarata;
    Button btnMagra;
    Button btnVoltar;
    TextView txtCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        btnMacia = findViewById(R.id.btnMacia);
        btnBarata = findViewById(R.id.btnBarata);
        btnMagra = findViewById(R.id.btnMagra);
        btnVoltar = findViewById(R.id.btnVoltar);
        txtCategoria = findViewById(R.id.txtCategoria);

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

        btnVoltar.setOnClickListener(v -> {
            finish();
        });

        txtCategoria.setText(
                "Preferências para " + categoria
        );
    }
}