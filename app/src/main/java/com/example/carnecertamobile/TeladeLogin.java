package com.example.carnecertamobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class TeladeLogin extends AppCompatActivity {

    EditText edtEmail;
    EditText edtSenha;

    Button btnEntrar;
    Button btnCadastrar;
    Button btnGoogle;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telade_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);

        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnGoogle = findViewById(R.id.btnGoogle);

        auth = FirebaseAuth.getInstance();

        btnEntrar.setOnClickListener(v -> {

            String email = edtEmail.getText().toString();
            String senha = edtSenha.getText().toString();

            if(email.isEmpty() || senha.isEmpty()) {

                Toast.makeText(
                        this,
                        "Preencha todos os campos",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            auth.signInWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(task -> {

                        if(task.isSuccessful()) {

                            Toast.makeText(
                                    this,
                                    "Login realizado",
                                    Toast.LENGTH_SHORT
                            ).show();

                            Intent tela = new Intent(
                                    TeladeLogin.this,
                                    MainActivity.class
                            );

                            startActivity(tela);

                        } else {

                            Toast.makeText(
                                    this,
                                    "Erro no login",
                                    Toast.LENGTH_SHORT
                            ).show();

                        }

                    });

        });

        btnCadastrar.setOnClickListener(v -> {

            String email = edtEmail.getText().toString();
            String senha = edtSenha.getText().toString();

            if(email.isEmpty() || senha.isEmpty()) {

                Toast.makeText(
                        this,
                        "Preencha todos os campos",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            auth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(task -> {

                        if(task.isSuccessful()) {

                            Toast.makeText(
                                    this,
                                    "Conta criada",
                                    Toast.LENGTH_SHORT
                            ).show();

                        } else {

                            Toast.makeText(
                                    this,
                                    "Erro ao cadastrar",
                                    Toast.LENGTH_SHORT
                            ).show();

                        }

                    });

        });

        btnGoogle.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "Google Login será implementado",
                    Toast.LENGTH_SHORT
            ).show();

        });

    }
}