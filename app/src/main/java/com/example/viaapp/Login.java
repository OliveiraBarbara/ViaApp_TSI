package com.example.viaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private Button btnEntrarGoogle;
    private EditText txtPerfilEmail;
    private EditText txtSenha;
    private Button btnEntrar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btnEntrarGoogle = findViewById(R.id.btnEntrarGoogle);
        this.txtPerfilEmail = findViewById(R.id.txtPerfilEmail);
        this.txtSenha = findViewById(R.id.txtSenha);
        this.btnEntrar2 = findViewById(R.id.btnEntrar2);

        this.btnEntrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Linhas.class);
                startActivity(i);
            }
        });
    }
}
