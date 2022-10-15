package com.example.transapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastro extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtPerfilTelefone;
    private EditText txtNovoEmail;
    private EditText txtSenha1;
    private Button btnNovoCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        this.txtNome = findViewById(R.id.txtNome);
        this.txtPerfilTelefone = findViewById(R.id.txtPerfilTelefone);
        this.txtNovoEmail = findViewById(R.id.txtNovoEmail);
        this.txtSenha1 = findViewById(R.id.txtSenha1);
        this.btnNovoCadastro = findViewById(R.id.btnNovoCadastro);

        this.btnNovoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });

    }
}
