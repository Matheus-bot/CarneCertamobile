package com.example.carnecertamobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CarnesActivity extends AppCompatActivity {

    TextView txtLista;
    EditText edtCarne;

    Button btnAdicionar;
    Button btnLimpar;

    DataBaseHelper banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnes);

        txtLista = findViewById(R.id.txtLista);

        edtCarne = findViewById(R.id.edtCarne);

        btnAdicionar = findViewById(R.id.btnAdicionar);

        btnLimpar = findViewById(R.id.btnLimpar);

        banco = new DataBaseHelper(this);

        atualizarLista();

        btnAdicionar.setOnClickListener(v -> {

            String nomeCarne = edtCarne.getText().toString();

            if(!nomeCarne.isEmpty()) {

                banco.inserirCarne(nomeCarne);

                edtCarne.setText("");

                atualizarLista();

            }

        });

        btnLimpar.setOnClickListener(v -> {

            banco.limparCarnes();

            txtLista.setText("");

        });

    }

    private void atualizarLista() {

        String carnes = banco.listarCarnes();

        txtLista.setText(carnes);

    }
}