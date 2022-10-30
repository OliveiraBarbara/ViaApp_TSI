package com.example.transapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class AdapterLinhas extends ArrayAdapter<Linha> {
    private Context context;
    private ArrayList<Linha> linhas;

    public AdapterLinhas(Context context, ArrayList<Linha> linhas){
        super(context, R.layout.item_lista, linhas);

        this.context = context;
        this.linhas = linhas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());

        View itemView = li.inflate(R.layout.item_lista, parent, false);

        Button btnLinha = itemView.findViewById(R.id.btnLinha);

        btnLinha.setText("Linha " + this.linhas.get(position).getNome());

        btnLinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LinhaSelecionada.class);
                context.startActivity(intent);
            }
        });

        return itemView;
    }
}
