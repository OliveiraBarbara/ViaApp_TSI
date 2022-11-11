package com.example.viaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class Linhas extends AppCompatActivity {

    private EditText txtBuscar;
    private Button btnMenu;
    private Button btnPerfil;
    private ListView listaLinhas;

    private ArrayList<Linha> linhas = new ArrayList<Linha>();

    private AdapterLinhas adaptador;

    private DatabaseReference BD = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linhas);

        this.txtBuscar = findViewById(R.id.txtBuscar);
        this.btnMenu = findViewById(R.id.btnMenu);
        this.btnPerfil = findViewById(R.id.btnPerfil);
        this.listaLinhas = findViewById(R.id.listaInfoLinha);

        DatabaseReference dados = BD.child("linha");

        FirebaseListOptions<Linha> options = new FirebaseListOptions.Builder<Linha>()
                .setLayout(R.layout.item_lista)
                .setQuery(dados, Linha.class)
                .setLifecycleOwner(this)
                .build();

        adaptador = new AdapterLinhas(options);

        this.listaLinhas.setAdapter(adaptador);

        dados.addValueEventListener(new EscutadorLinhas());

        listaLinhas.setAdapter(adaptador);

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

    private class EscutadorLinhas implements ValueEventListener {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            if ( dataSnapshot.exists()) {

                Linha l = dataSnapshot.getValue(Linha.class);
                Linha linha = new Linha(l.getNome(), l.getValorPassagem(), l.getRota(), l.getPontosParada(), l.getHorarioFuncionamento(), l.getDiasFuncionamento());

                linhas.add(linha);
                adaptador.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) { }
    }
}
