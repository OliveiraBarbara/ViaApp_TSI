package com.example.transapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;

public class Linhas extends AppCompatActivity {

    private EditText txtBuscar;
    private Button btnLinha1;
    private Button btnLinha2;
    private Button btnLinha3;
    private Button btnLinha4;
    private Button btnMenu;
    private Button btnPerfil;
    private ListView listaLinhas;

    private ArrayList<Linha> linhas = new ArrayList<Linha>();

    private AdapterLinhas adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linhas);

        this.txtBuscar = findViewById(R.id.txtBuscar);
        this.btnLinha1 = findViewById(R.id.btnLinhas);
        this.btnMenu = findViewById(R.id.btnMenu);
        this.btnPerfil = findViewById(R.id.btnPerfil);
        this.listaLinhas = findViewById(R.id.listaLinhas);

        this.adaptador = new AdapterLinhas(this, this.linhas);

        this.listaLinhas.setAdapter(adaptador);

        this.btnLinha1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = "Teste";
                double valorPassagem = 4.88;
                String rota = "do ponto A ao B";
                ArrayList<String> pontosParada = new ArrayList<String>();
                pontosParada.add("A");
                pontosParada.add("B");
                Date inicio = new Date();
                Date fim = new Date();

                Linha linha = new Linha(nome, valorPassagem, rota, pontosParada, inicio, fim);

                linhas.add(linha);

                adaptador.notifyDataSetChanged();

                /*Intent i = new Intent(getApplicationContext(), LinhaSelecionada.class);
                startActivity(i);*/
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
