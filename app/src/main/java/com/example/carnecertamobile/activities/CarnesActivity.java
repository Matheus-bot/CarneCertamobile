package com.example.carnecertamobile.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carnecertamobile.R;
import com.example.carnecertamobile.database.CarneDatabase;
import com.example.carnecertamobile.model.Carne;



import java.util.List;


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

        CarneDatabase banco =
                CarneDatabase.getInstance(this);

        List<Carne> carnes =
                banco.carneDao().buscarCarnes(
                        categoria,
                        preferencia
                );

        if (carnes.size() >= 3) {

            txtCarne1.setText(
                    carnes.get(0).getNome()
            );

            txtCarne2.setText(
                    carnes.get(1).getNome()
            );

            txtCarne3.setText(
                    carnes.get(2).getNome()
            );

        }


    }
}