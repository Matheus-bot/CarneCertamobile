package com.example.carnecertamobile;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CarnesActivity extends AppCompatActivity {

    TextView txtLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnes);

        txtLista = findViewById(R.id.txtLista);

        DataBaseHelper banco = new DataBaseHelper(this);

        String carnes = banco.listarCarnes();

        txtLista.setText(carnes);

    }
}