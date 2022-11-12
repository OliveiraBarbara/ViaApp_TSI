package com.example.viaapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    private Button btnEntrarGoogle;
    private EditText txtPerfilEmail;
    private EditText txtSenha;
    private Button btnEntrar2;

    private DatabaseReference BD = FirebaseDatabase.getInstance().getReference();

    private FirebaseAuth usuarios = FirebaseAuth.getInstance();

    private GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btnEntrarGoogle = findViewById(R.id.btnEntrarGoogle);
        this.txtPerfilEmail = findViewById(R.id.txtPerfilEmail);
        this.txtSenha = findViewById(R.id.txtSenha);
        this.btnEntrar2 = findViewById(R.id.btnEntrar2);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("730393928411-7fr187iv4lvbs61ekgg2ns1f5lk00q8l.apps.googleusercontent.com")
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        btnEntrarGoogle.setOnClickListener(new EscutadorBotaoEntrarGoogle());
        btnEntrar2.setOnClickListener(new EscutadorBotaoEntrar());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 1){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(intent);
            try{
                GoogleSignInAccount conta = task.getResult(ApiException.class);
                loginComGoogle(conta);
            } catch (ApiException exception){
                Toast.makeText(Login.this, "Nenhuma conta do Google logada no dispositivo!", Toast.LENGTH_LONG).show();
                Log.d("erro: ", exception.toString());
            }
        }
    }

    private void loginComGoogle(GoogleSignInAccount conta){
        AuthCredential credential = GoogleAuthProvider.getCredential(conta.getIdToken(), null);
        DatabaseReference usuariosBd = BD.child("usuario");

        Usuario usuario = new Usuario(conta.getGivenName(), conta.getEmail());

        usuarios.signInWithCredential(credential).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    usuariosBd.child(usuarios.getCurrentUser().getUid()).setValue(usuario);

                    Toast.makeText(Login.this, "Usuário logado com conta Google!", Toast.LENGTH_SHORT).show();

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

    private class EscutadorBotaoEntrarGoogle implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent i = googleSignInClient.getSignInIntent();
            startActivityForResult(i, 1);
        }
    }
}
