package com.example.cadastrodeprodutos.model;

import java.io.Serializable;

public class Produtos implements Serializable  {
    private Long id;
    private String nomeProduto;
    private String DescricaoProduto;
    private int quantidade;

    @Override
    public String toString () {
        return nomeProduto.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return DescricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        DescricaoProduto = descricaoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
