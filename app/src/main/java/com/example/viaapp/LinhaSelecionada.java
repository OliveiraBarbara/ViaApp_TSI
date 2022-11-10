package com.example.viaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LinhaSelecionada extends AppCompatActivity {

    private Button btnVerRota;
    private Button btnMenu;
    private Button btnPerfil;

    private TextView txtNomeLinha;
    private ListView listaInfoLinha;

    private Linha linha;

    private AdapterLinhaSelecionada adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linha_selecionada);

        this.btnVerRota = findViewById(R.id.btnVerRota);
        this.btnMenu = findViewById(R.id.btnMenu);
        this.btnPerfil = findViewById(R.id.btnPerfil);
        this.txtNomeLinha = findViewById(R.id.txtNomeLinha);
        this.listaInfoLinha = findViewById(R.id.listaInfoLinha);

        // Recuperando o objeto Intent que criou esta activity
        Intent i = getIntent();

        // Recuperando o objeto Pessoa que foi armazenado dentro do intent
        this.linha = (Linha) i.getSerializableExtra("linha");

        this.adaptador = new AdapterLinhaSelecionada(this, linha.getPontosParada());

        this.listaInfoLinha.setAdapter(adaptador);

        // Colocando as informações recuperadas na interface gráfica
        txtNomeLinha.setText("Linha " + linha.getNome());

        this.btnVerRota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Mapa.class);
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
