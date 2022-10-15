package com.example.transapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    private Button btnLinhas;
    private Button btnPerfil1;
    private Button btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.btnLinhas = findViewById(R.id.btnLinhas);
        this.btnPerfil1 = findViewById(R.id.btnPerfil1);
        this.btnSobre = findViewById(R.id.btnSobre);

        this.btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Sobre.class);
                startActivity(i);
            }
        });

        this.btnPerfil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Perfil.class);
                startActivity(i);
            }
        });

        this.btnLinhas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Linhas.class);
                startActivity(i);
            }
        });

    }
}