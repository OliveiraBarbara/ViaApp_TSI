package com.example.transapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastro extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtPerfilTelefone;
    private EditText txtNovoEmail;
    private EditText txtSenha1;
    private Button btnNovoCadastro;

    SQLiteDatabase bd;

    Cursor cursor;

    UsuariosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        this.txtNome = findViewById(R.id.txtNome);
        this.txtPerfilTelefone = findViewById(R.id.txtPerfilTelefone);
        this.txtNovoEmail = findViewById(R.id.txtNovoEmail);
        this.txtSenha1 = findViewById(R.id.txtSenha1);
        this.btnNovoCadastro = findViewById(R.id.btnNovoCadastro);


        // Abrindo ou criando o banco de dados
        bd = openOrCreateDatabase("usuarios", MODE_PRIVATE, null);
        // String para comandos SQL
        String cmd;
        // Criar a tabela, se a mesma não existir
        cmd = "CREATE TABLE IF NOT EXISTS usuarios (nome VARCHAR, telefone VARCHAR, email VARCHAR, senha VARCHAR)";
        // Executa comando no bd
        bd.execSQL( cmd );

        // Consulta para gerar o Cursor
        cursor = bd.rawQuery("SELECT _rowid_ _id, nome, email FROM usuarios", null);
        // Criar o adapter, passando o contexto e o cursor
        adapter = new UsuariosAdapter(this, cursor);


        this.btnNovoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EscutadorInserir();
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });

    }

    // classe interna, escutador do botão Inserir
    private class EscutadorInserir implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // Variáveis para pegar os dados
            String nome, telefone, email, senha;
            // Pegando os dados na interface
            nome = txtNome.getText().toString();
            telefone = txtPerfilTelefone.getText().toString();
            email = txtNovoEmail.getText().toString();
            senha = txtSenha1.getText().toString();
            // Montando SQL para inserir dados
            String cmd = "INSERT INTO usuarios (nome, telefone, email, senha) VALUES ('";
            cmd = cmd + nome;
            cmd = cmd + "', '";
            cmd = cmd + telefone;
            cmd = cmd + "', '";
            cmd = cmd + email;
            cmd = cmd + "', '";
            cmd = cmd + senha;
            cmd = cmd + "')";
            // Executando comando
            bd.execSQL( cmd );
            // Limpando a interface
            txtNome.setText("");
            txtPerfilTelefone.setText("");
            txtNovoEmail.setText("");
            txtSenha1.setText("");
            // Trocando o cursor do adapter
            cursor = bd.rawQuery( "SELECT _rowid_ _id, nome, telefone, email, senha FROM usuarios", null );
            adapter.changeCursor(cursor);
        }
    }
}
