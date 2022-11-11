package com.example.viaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Cadastro extends AppCompatActivity {
    private DatabaseReference BD = FirebaseDatabase.getInstance().getReference();

    private EditText txtNome;
    private EditText txtPerfilTelefone;
    private EditText txtNovoEmail;
    private EditText txtSenha1;
    private Button btnNovoCadastro;

    private FirebaseAuth usuarios = FirebaseAuth.getInstance();

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

        btnNovoCadastro.setOnClickListener(new EscutadorBotaoNovo());

        /*DatabaseReference usuario = BD.child("usuario");
        usuario.addValueEventListener(new EscutadorInserir());*/

    }

    private class EscutadorBotaoNovo implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String nome = txtNome.getText().toString();
            String telefone = txtPerfilTelefone.getText().toString();
            String email = txtNovoEmail.getText().toString();
            String senha = txtSenha1.getText().toString();

            DatabaseReference usuariosBd = BD.child("usuario");

            Usuario usuario = new Usuario(nome, telefone, email, senha);

            usuarios.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(Cadastro.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Cadastro.this, "Usuário criado e logado com sucesso!", Toast.LENGTH_SHORT).show();

                        String chave = usuariosBd.push().getKey();
                        usuariosBd.child(usuarios.getCurrentUser().getUid()).setValue(usuario);

                        Intent i = new Intent(getApplicationContext(), Linhas.class);
                        startActivity(i);
                    }else{
                        FirebaseAuthException exception = (FirebaseAuthException) task.getException();
                        Toast.makeText(Cadastro.this, "Erro: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    // classe interna, escutador do botão Inserir
    /*private class EscutadorInserir implements ValueEventListener {
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
    }*/
}
