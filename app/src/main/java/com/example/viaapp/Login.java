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
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    private Button btnEntrarGoogle;
    private EditText txtPerfilEmail;
    private EditText txtSenha;
    private Button btnEntrar2;

    private FirebaseAuth usuarios = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btnEntrarGoogle = findViewById(R.id.btnEntrarGoogle);
        this.txtPerfilEmail = findViewById(R.id.txtPerfilEmail);
        this.txtSenha = findViewById(R.id.txtSenha);
        this.btnEntrar2 = findViewById(R.id.btnEntrar2);

        btnEntrar2.setOnClickListener(new EscutadorBotaoEntrar());

    }

    private class EscutadorBotaoEntrar implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String email = txtPerfilEmail.getText().toString();
            String senha = txtSenha.getText().toString();

            usuarios.signInWithEmailAndPassword(email, senha).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Login.this, "Usuário logado com sucesso!", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(getApplicationContext(), Linhas.class);
                        startActivity(i);
                        finish();
                    }else{
                        FirebaseAuthException exception = (FirebaseAuthException) task.getException();
                        Toast.makeText(Login.this, "Erro: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
