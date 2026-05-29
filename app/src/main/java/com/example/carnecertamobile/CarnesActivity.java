package com.example.carnecertamobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CarnesActivity extends AppCompatActivity {

    Button btnVoltar;
    TextView txtCarne1;
    TextView txtCarne2;
    TextView txtCarne3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnes);

        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(v -> {
            finish();
        });

        txtCarne1 = findViewById(R.id.txtCarne1);
        txtCarne2 = findViewById(R.id.txtCarne2);
        txtCarne3 = findViewById(R.id.txtCarne3);

        String categoria =
                getIntent().getStringExtra("categoria");

        String preferencia =
                getIntent().getStringExtra("preferencia");

        if(categoria.equals("churrasco")
                && preferencia.equals("macia")) {

            txtCarne1.setText("Picanha");
            txtCarne2.setText("Contra-filé");
            txtCarne3.setText("Ancho");

        }
        if(categoria.equals("churrasco")
                && preferencia.equals("barata")) {

            txtCarne1.setText("Fraldinha");
            txtCarne2.setText("Acém");
            txtCarne3.setText("Maminha");

        }
        if(categoria.equals("churrasco")
                && preferencia.equals("magra")) {

            txtCarne1.setText("Patinho");
            txtCarne2.setText("Ponta de Alcatra");
            txtCarne3.setText("Coxão mole");

        }

    }
}