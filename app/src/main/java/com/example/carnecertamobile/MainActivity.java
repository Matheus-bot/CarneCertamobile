package com.example.carnecertamobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;


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

        CarneDatabase banco =
                CarneDatabase.getInstance(this);

        if(banco.carneDao()
                .buscarCarnes("churrasco", "macia")
                .isEmpty()) {

            // CHURRASCO MACIA
            banco.carneDao().inserir(new Carne("Picanha", "churrasco", "macia"));
            banco.carneDao().inserir(new Carne("Contra-filé", "churrasco", "macia"));
            banco.carneDao().inserir(new Carne("Ancho", "churrasco", "macia"));

            // CHURRASCO BARATA
            banco.carneDao().inserir(new Carne("Fraldinha", "churrasco", "barata"));
            banco.carneDao().inserir(new Carne("Acém", "churrasco", "barata"));
            banco.carneDao().inserir(new Carne("Maminha", "churrasco", "barata"));

            // CHURRASCO MAGRA
            banco.carneDao().inserir(new Carne("Patinho", "churrasco", "magra"));
            banco.carneDao().inserir(new Carne("Ponta de Alcatra", "churrasco", "magra"));
            banco.carneDao().inserir(new Carne("Coxão Mole", "churrasco", "magra"));

            // PANELA MACIA
            banco.carneDao().inserir(new Carne("Peixinho", "panela", "macia"));
            banco.carneDao().inserir(new Carne("Paleta", "panela", "macia"));
            banco.carneDao().inserir(new Carne("Acém", "panela", "macia"));

            // PANELA BARATA
            banco.carneDao().inserir(new Carne("Músculo", "panela", "barata"));
            banco.carneDao().inserir(new Carne("Acém", "panela", "barata"));
            banco.carneDao().inserir(new Carne("Pescoço", "panela", "barata"));

            // PANELA MAGRA
            banco.carneDao().inserir(new Carne("Patinho", "panela", "magra"));
            banco.carneDao().inserir(new Carne("Lagarto", "panela", "magra"));
            banco.carneDao().inserir(new Carne("Coxão Duro", "panela", "magra"));

            // HAMBURGUER MACIA
            banco.carneDao().inserir(new Carne("Fraldinha", "hamburguer", "macia"));
            banco.carneDao().inserir(new Carne("Acém", "hamburguer", "macia"));
            banco.carneDao().inserir(new Carne("Peito", "hamburguer", "macia"));

            // HAMBURGUER BARATA
            banco.carneDao().inserir(new Carne("Acém", "hamburguer", "barata"));
            banco.carneDao().inserir(new Carne("Peito", "hamburguer", "barata"));
            banco.carneDao().inserir(new Carne("Paleta", "hamburguer", "barata"));

            // HAMBURGUER MAGRA
            banco.carneDao().inserir(new Carne("Patinho", "hamburguer", "magra"));
            banco.carneDao().inserir(new Carne("Coxão Mole", "hamburguer", "magra"));
            banco.carneDao().inserir(new Carne("Lagarto", "hamburguer", "magra"));

            // BIFE MACIA
            banco.carneDao().inserir(new Carne("Contra-filé", "bife", "macia"));
            banco.carneDao().inserir(new Carne("Alcatra", "bife", "macia"));
            banco.carneDao().inserir(new Carne("Filé Mignon", "bife", "macia"));

            // BIFE BARATA
            banco.carneDao().inserir(new Carne("Coxão Mole", "bife", "barata"));
            banco.carneDao().inserir(new Carne("Patinho", "bife", "barata"));
            banco.carneDao().inserir(new Carne("Acém", "bife", "barata"));

            // BIFE MAGRA
            banco.carneDao().inserir(new Carne("Patinho", "bife", "magra"));
            banco.carneDao().inserir(new Carne("Lagarto", "bife", "magra"));
            banco.carneDao().inserir(new Carne("Coxão Mole", "bife", "magra"));
        }
        //DataBaseHelper banco = new DataBaseHelper(this);
        //banco.inserirCarnesIniciais();

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