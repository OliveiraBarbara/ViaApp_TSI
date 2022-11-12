package com.example.viaapp;

import com.google.android.gms.maps.model.LatLng;

public class Ponto {
    private String nome;
    private LatLng latLng;
    private String endereco;

    public Ponto(String nome, LatLng latLng, String endereco) {
        this.nome = nome;
        this.latLng = latLng;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
