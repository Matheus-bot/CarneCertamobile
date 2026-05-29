package com.example.carnecertamobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class TeladeLogin extends AppCompatActivity {

    EditText edtEmail;
    EditText edtSenha;

    Button btnEntrar;
    Button btnCadastrar;
    Button btnGoogle;

    FirebaseAuth auth;

    GoogleSignInClient googleSignInClient;

    private final int RC_SIGN_IN = 100;


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

        GoogleSignInOptions googleSignInOptions =
                new GoogleSignInOptions.Builder(
                        GoogleSignInOptions.DEFAULT_SIGN_IN
                )
                        .requestIdToken(getString(R.string.default_web_client_id))
                        .requestEmail()
                        .build();

        googleSignInClient =
                GoogleSignIn.getClient(
                        this,
                        googleSignInOptions
                );


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

            Intent signInIntent =
                    googleSignInClient.getSignInIntent();

            startActivityForResult(
                    signInIntent,
                    RC_SIGN_IN
            );

        });

    }
    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            @Nullable Intent data
    ) {

        super.onActivityResult(
                requestCode,
                resultCode,
                data
        );

        if(requestCode == RC_SIGN_IN) {

            Toast.makeText(
                    this,
                    "Login Google iniciado",
                    Toast.LENGTH_SHORT
            ).show();

        }
    }
}