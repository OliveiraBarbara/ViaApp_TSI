package com.example.viaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnEntrar;
    private Button btnCadastrar;

    private FirebaseAuth usuarios = FirebaseAuth.getInstance();

    /*private Linha linha;

    private DatabaseReference BD = FirebaseDatabase.getInstance().getReference();

    private ArrayList<Ponto> pontos = new ArrayList<>();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*DatabaseReference linhaBd = BD.child("linha");

        ArrayList<String> hr = new ArrayList<>();
        hr.add("07:45");
        hr.add("12:30");
        hr.add("18:00");

        pontos.add(new Ponto("UFMS", -20.7821109,-51.6683511, "Av. Ranulpho Marques Leal, 3484 - Interlagos, Três Lagoas - MS"));
        pontos.add(new Ponto("Terminal Rodoviário", -20.7749812,-51.698669, "Av. Antônio Trajano, 2180 - Centro, Três Lagoas - MS"));

        linha = new Linha("Estudantes", 6.85, pontos, hr, "Segunda a Sexta");

        String chave = linhaBd.push().getKey();
        linhaBd.child(chave).setValue(linha);*/

        if (usuarios.getCurrentUser() != null) {
            Intent i = new Intent(getApplicationContext(), Linhas.class);
            startActivity(i);
        }

        this.btnEntrar = findViewById(R.id.btnEntrar);
        this.btnCadastrar = findViewById(R.id.btnCadastrar);

        this.btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();
            }
        });

        this.btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Cadastro.class);
                startActivity(i);
                finish();
            }
        });
    }
}