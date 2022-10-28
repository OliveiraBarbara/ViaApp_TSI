package com.example.transapp;

import java.util.ArrayList;
import java.util.Date;

public class Linha {
    private String nome;
    private double valorPassagem;
    private String rota;
    private ArrayList<String> pontosParada;
    private Date inicio;
    private Date fim;

    public Linha(String nome, double valorPassagem, String rota, ArrayList<String> pontosParada, Date inicio, Date fim) {
        this.nome = nome;
        this.valorPassagem = valorPassagem;
        this.rota = rota;
        this.pontosParada = pontosParada;
        this.inicio = inicio;
        this.fim = fim;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(double valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public ArrayList<String> getPontosParada() {
        return pontosParada;
    }

    public void setPontosParada(ArrayList<String> pontosParada) {
        this.pontosParada = pontosParada;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
}
