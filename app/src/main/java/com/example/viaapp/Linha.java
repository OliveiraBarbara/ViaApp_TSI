package com.example.viaapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Linha implements Serializable {
    private String nome;
    private double valorPassagem;
    private ArrayList<Ponto> pontosParada;
    private ArrayList<String> horarioFuncionamento;
    private String diasFuncionamento;

    public Linha(){

    }

    public Linha(String nome, double valorPassagem, ArrayList<Ponto> pontosParada, ArrayList<String> horarioFuncionamento, String diasFuncionamento) {
        this.nome = nome;
        this.valorPassagem = valorPassagem;
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

    public ArrayList<Ponto> getPontosParada() {
        return pontosParada;
    }

    public void setPontosParada(ArrayList<Ponto> pontosParada) {
        this.pontosParada = pontosParada;
    }

    public ArrayList<String> getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(ArrayList<String> horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getDiasFuncionamento() {
        return diasFuncionamento;
    }

    public void setDiasFuncionamento(String diasFuncionamento) {
        this.diasFuncionamento = diasFuncionamento;
    }
}
