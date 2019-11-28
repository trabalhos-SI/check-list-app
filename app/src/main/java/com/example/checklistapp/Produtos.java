package com.example.checklistapp;

public class Produtos {

    public int id;
    public String nome;
    public double valor;
    public String categoria;
    public String mercado;
    public boolean selecionado = false;

    public Produtos(int id, String nome, double valor, String categoria, String mercado, boolean selecionado) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
        this.mercado = mercado;
        this.selecionado = selecionado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

}
