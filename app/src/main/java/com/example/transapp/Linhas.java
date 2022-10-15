package com.example.transapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Linhas extends AppCompatActivity {

    private EditText txtBuscar;
    private Button btnLinha1;
    private Button btnLinha2;
    private Button btnLinha3;
    private Button btnLinha4;
    private Button btnMenu;
    private Button btnPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linhas);

        this.txtBuscar = findViewById(R.id.txtBuscar);
        this.btnLinha1 = findViewById(R.id.btnLinhas);
        this.btnLinha2 = findViewById(R.id.btnPerfil1);
        this.btnLinha3 = findViewById(R.id.btnSobre);
        this.btnLinha4 = findViewById(R.id.btnLinha4);
        this.btnMenu = findViewById(R.id.btnMenu);
        this.btnPerfil = findViewById(R.id.btnPerfil);

        this.btnLinha1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LinhaSelecionada.class);
                startActivity(i);
            }
        });

        this.btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Perfil.class);
                startActivity(i);
            }
        });

        this.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Menu.class);
                startActivity(i);
            }
        });
    }
}
