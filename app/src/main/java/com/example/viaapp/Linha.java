package com.example.viaapp;

import java.util.ArrayList;

public class Linha {
    private String nome;
    private double valorPassagem;
    private String rota;
    private ArrayList<String> pontosParada;
    private String horarioFuncionamento;
    private String diasFuncionamento;

    public Linha(String nome, double valorPassagem, String rota, ArrayList<String> pontosParada, String horarioFuncionamento, String diasFuncionamento) {
        this.nome = nome;
        this.valorPassagem = valorPassagem;
        this.rota = rota;
        this.pontosParada = pontosParada;
        this.horarioFuncionamento = horarioFuncionamento;
        this.diasFuncionamento = diasFuncionamento;
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

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getDiasFuncionamento() {
        return diasFuncionamento;
    }

    public void setDiasFuncionamento(String diasFuncionamento) {
        this.diasFuncionamento = diasFuncionamento;
    }
}
