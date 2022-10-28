package com.example.transapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cursoradapter.widget.CursorAdapter;

public class UsuariosAdapter extends CursorAdapter {

    public UsuariosAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.activity_perfil, parent, false);

        return v;
    }

    @SuppressLint("Range")
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtNome = view.findViewById( R.id.txtNome );
        TextView txtTelefone = view.findViewById( R.id.txtPerfilTelefone );
        TextView txtNovoEmail = view.findViewById( R.id.txtNovoEmail );
        TextView txtSenha = view.findViewById( R.id.txtSenha1 );

        String nome  = cursor.getString(cursor.getColumnIndex( "nome"  ));
        String telefone  = cursor.getString(cursor.getColumnIndex( "telefone"  ));
        String email = cursor.getString(cursor.getColumnIndex( "email" ));
        String senha  = cursor.getString(cursor.getColumnIndex( "senha"  ));

        /*
        txtNome.setText( nome );
        lblEmail.setText( email );*/
    }
}
