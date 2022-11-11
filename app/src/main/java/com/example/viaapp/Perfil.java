package com.example.viaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Perfil extends AppCompatActivity {

    private Button btnMenu;
    private Button btnSair;
    private TextView txtPerfilEmail;
    private TextView txtPerfilNome;
    private TextView txtPerfilTelefone;

    private DatabaseReference BD = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        this.btnMenu = findViewById(R.id.btnMenu);
        this.btnSair = findViewById(R.id.btnSair);
        this.txtPerfilEmail = findViewById(R.id.txtPerfilEmail);
        this.txtPerfilNome = findViewById(R.id.txtPerfilNome);
        this.txtPerfilTelefone = findViewById(R.id.txtPerfilTelefone);

        if(usuario.getCurrentUser() != null){
            DatabaseReference dadosUsuario = BD.child("usuario").child(usuario.getCurrentUser().getUid());
            txtPerfilEmail.setText(usuario.getCurrentUser().getEmail());
            dadosUsuario.addValueEventListener(new EscutadorPerfil());
        }

        this.btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Menu.class);
                startActivity(i);
                finish();
            }
        });

        this.btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario.signOut();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private class EscutadorPerfil implements ValueEventListener {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            if ( dataSnapshot.exists()) {
                Usuario u = dataSnapshot.getValue(Usuario.class);
                Toast.makeText(Perfil.this, "Usuário: " + u.getEmail(), Toast.LENGTH_SHORT).show();
                txtPerfilNome.setText(u.getNome());
                txtPerfilTelefone.setText(u.getTelefone());
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) { }
    }
}
