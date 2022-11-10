package com.example.viaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterLinhaSelecionada extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> pontos;

    public AdapterLinhaSelecionada(Context context, ArrayList<String> pontos){
        super(context, R.layout.infos_linha_lista, pontos);

        this.context = context;
        this.pontos = pontos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());

        View itemView = li.inflate(R.layout.infos_linha_lista, parent, false);
        TextView txtPonto = itemView.findViewById(R.id.txtPonto5);

        txtPonto.setText(txtPonto.getText() + this.pontos.get(position));

        return itemView;
    }
}
