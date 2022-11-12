package com.example.viaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class InfoPontosAdapter implements GoogleMap.InfoWindowAdapter {
    private Context context;
    private TextView txt_title;
    private TextView txt_address;

    public InfoPontosAdapter(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        Ponto place;

        if(marker.getTag() != null){
            place = (Ponto) marker.getTag();
        }else{
            return null;
        }

        View view = LayoutInflater.from(context).inflate(R.layout.custom_info_pontos, null);

        txt_title = view.findViewById(R.id.txt_title);
        txt_address = view.findViewById(R.id.txt_address);

        txt_title.setText(place.getNome());
        txt_address.setText(place.getEndereco());

        return view;
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        return null;
    }
}
