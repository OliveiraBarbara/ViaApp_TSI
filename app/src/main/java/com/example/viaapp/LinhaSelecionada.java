package com.example.viaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LinhaSelecionada extends AppCompatActivity {

    private Button btnVerRota;
    private Button btnMenu;
    private Button btnPerfil;

    private TextView txtNomeLinha;
    private TextView txtHorario;
    private TextView txtDiaFunc;
    private TextView txtValorPassagem;

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
        this.txtHorario = findViewById(R.id.txtHorario3);
        this.txtDiaFunc = findViewById(R.id.txtDiaFunc);
        this.txtValorPassagem = findViewById(R.id.txtValorPassagem);

        this.listaInfoLinha = findViewById(R.id.listaInfoLinha);

        // Recuperando o objeto Intent que criou esta activity
        Intent i = getIntent();

        // Recuperando o objeto Linha que foi armazenado dentro do intent
        this.linha = (Linha) i.getSerializableExtra("linha");

        this.adaptador = new AdapterLinhaSelecionada(this, Utility.preencheArrayString(linha.getPontosParada()));

        this.listaInfoLinha.setAdapter(adaptador);

        // Colocando as informações recuperadas na interface gráfica
        txtNomeLinha.setText(linha.getNome());

        txtHorario.setText(Utility.concatenaHorarios(linha));
        txtDiaFunc.setText(linha.getDiasFuncionamento());
        txtValorPassagem.setText(Double.toString(linha.getValorPassagem()));

        this.btnVerRota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Mapa.class);
                i.putExtra("linha", linha);
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

        Utility.setListViewHeightBasedOnChildren(listaInfoLinha);
    }
}