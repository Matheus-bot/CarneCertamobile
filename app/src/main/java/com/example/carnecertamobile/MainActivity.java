package com.example.carnecertamobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button btnCarnes;

    LinearLayout cardChurrasco;
    LinearLayout cardPanela;
    LinearLayout cardHamburguer;
    LinearLayout cardBife;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardHamburguer = findViewById(R.id.cardHamburguer);
        cardChurrasco = findViewById(R.id.cardChurrasco);
        cardPanela = findViewById(R.id.cardPanela);
        cardBife = findViewById(R.id.cardBife);

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

        cardChurrasco.setOnClickListener(v -> {
            Intent tela = new Intent(
                    MainActivity.this,
                    Preferencias.class
            );

            tela.putExtra(
                    "categoria",
                    "churrasco"
            );

            startActivity(tela);

        });
        cardPanela.setOnClickListener(v -> {

            Intent tela = new Intent(
                    MainActivity.this,
                    Preferencias.class
            );

            tela.putExtra(
                    "categoria",
                    "panela"
            );

            startActivity(tela);

        });
        cardHamburguer.setOnClickListener(v -> {

            Intent tela = new Intent(
                    MainActivity.this,
                    Preferencias.class
            );

            tela.putExtra(
                    "categoria",
                    "hamburguer"
            );

            startActivity(tela);

        });
        cardBife.setOnClickListener(v -> {

            Intent tela = new Intent(
                    MainActivity.this,
                    Preferencias.class
            );

            tela.putExtra(
                    "categoria",
                    "bife"
            );

            startActivity(tela);

        });

    }

}