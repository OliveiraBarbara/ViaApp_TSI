package com.example.viaapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;

import java.util.ArrayList;

public class AdapterLinhas extends FirebaseListAdapter<Linha> {

    public AdapterLinhas(FirebaseListOptions options){
        super(options);

    }

    @Override
    protected void populateView(View v, Linha l, int position) {
        Button btnLinha = v.findViewById(R.id.btnLinha);
        btnLinha.setText(l.getNome());
        btnLinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(v.getContext(), LinhaSelecionada.class);
                intent.putExtra("linha", l);
                v.getContext().startActivity(intent);

            }
        });
    }
}
