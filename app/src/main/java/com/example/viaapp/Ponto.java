package com.example.viaapp;

import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class Ponto implements Serializable {
    private String nome;
    private double latitude;
    private double longitude;
    private String endereco;

    public Ponto(){

    }

    public Ponto(String nome, double latitude, double longitude, String endereco) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getEndereco() {
        return endereco;
    }
}
