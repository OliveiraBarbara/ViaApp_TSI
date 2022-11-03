package com.example.viaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Cadastro extends AppCompatActivity {
    private DatabaseReference BD = FirebaseDatabase.getInstance().getReference();

    private EditText txtNome;
    private EditText txtPerfilTelefone;
    private EditText txtNovoEmail;
    private EditText txtSenha1;
    private Button btnNovoCadastro;

    //UsuariosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtNome = findViewById(R.id.txtNome);
        txtPerfilTelefone = findViewById(R.id.txtPerfilTelefone);
        txtNovoEmail = findViewById(R.id.txtNovoEmail);
        txtSenha1 = findViewById(R.id.txtSenha1);
        btnNovoCadastro = findViewById(R.id.btnNovoCadastro);

        btnNovoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome;
                String telefone;
                String email;
                String senha;

                nome = txtNome.getText().toString();
                telefone = txtPerfilTelefone.getText().toString();
                email = txtNovoEmail.getText().toString();
                senha = txtSenha1.getText().toString();

                Usuario usuario = new Usuario(nome, telefone, email, senha);

                BD.child("usuario").setValue(usuario);

                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });

        DatabaseReference usuario = BD.child("usuario");
        usuario.addValueEventListener(new EscutadorInserir());

    }

    // classe interna, escutador do botão Inserir
    private class EscutadorInserir implements ValueEventListener {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            // Os dados recuperados no Firebase vem dentro de um DataSnapshot.
            // No nosso caso, só vai ter um objeto lá dentro (objeto da classe Usuario).
            // Precisamos testar se veio alguma informação, isto é, se o dataSnapshot existe...
            if ( dataSnapshot.exists()) {
                // Recuperamos o objeto Usuario que veio dentro do dataSnapshot:
                Usuario u = dataSnapshot.getValue(Usuario.class);

            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) { }
    }
}
