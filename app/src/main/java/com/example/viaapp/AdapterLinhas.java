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
    /*private Context context;
    private ArrayList<Linha> linhas;*/

    public AdapterLinhas(/*Context context, ArrayList<Linha> linhas*/FirebaseListOptions options){
        super(/*context, R.layout.item_lista, linhas*/options);

        /*this.context = context;
        this.linhas = linhas;*/
    }

    @Override
    protected void populateView(View v, Linha l, int position) {
        // Acessa os objetos gráficos dentro do desenho do item da lista:
        /*TextView lblNome  = v.findViewById(R.id.lblNome);
        TextView lblEmail = v.findViewById(R.id.lblEmail);
        // Coloca dados do objeto Contato (c) nesses objetos gráficos:
        lblNome.setText( c.getNome() );
        lblEmail.setText(c.getEmail());*/

        Button btnLinha = v.findViewById(R.id.btnLinha);
        btnLinha.setText("Linha " + l.getNome());
        btnLinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(v.getContext(), LinhaSelecionada.class);
                intent.putExtra("linha", l);
                v.getContext().startActivity(intent);

            }
        });
    }

    /*@Override
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
    }*/
}
