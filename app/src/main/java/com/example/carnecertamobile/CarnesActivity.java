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
        if(categoria.equals("panela")
                && preferencia.equals("macia")) {

            txtCarne1.setText("Peixinho");
            txtCarne2.setText("Paleta");
            txtCarne3.setText("Acém");

        }
        if(categoria.equals("panela")
                && preferencia.equals("barata")) {

            txtCarne1.setText("Músculo");
            txtCarne2.setText("Acém");
            txtCarne3.setText("Pescoço");

        }
        if(categoria.equals("panela")
                && preferencia.equals("magra")) {

            txtCarne1.setText("Patinho");
            txtCarne2.setText("Lagarto");
            txtCarne3.setText("Coxão duro");

        }
        if(categoria.equals("hamburguer")
                && preferencia.equals("macia")) {

            txtCarne1.setText("Fraldinha");
            txtCarne2.setText("Acém");
            txtCarne3.setText("Peito");

        }
        if(categoria.equals("hamburguer")
                && preferencia.equals("barata")) {

            txtCarne1.setText("Acém");
            txtCarne2.setText("Peito");
            txtCarne3.setText("Paleta");

        }
        if(categoria.equals("hamburguer")
                && preferencia.equals("magra")) {

            txtCarne1.setText("Patinho");
            txtCarne2.setText("Coxão mole");
            txtCarne3.setText("Lagarto");

        }
        if(categoria.equals("bife")
                && preferencia.equals("macia")) {

            txtCarne1.setText("Contra-filé");
            txtCarne2.setText("Alcatra");
            txtCarne3.setText("Filé mignon");

        }
        if(categoria.equals("bife")
                && preferencia.equals("barata")) {

            txtCarne1.setText("Coxão mole");
            txtCarne2.setText("Patinho");
            txtCarne3.setText("Acém");

        }
        if(categoria.equals("bife")
                && preferencia.equals("magra")) {

            txtCarne1.setText("Patinho");
            txtCarne2.setText("Lagarto");
            txtCarne3.setText("Coxão mole");

        }

    }
}