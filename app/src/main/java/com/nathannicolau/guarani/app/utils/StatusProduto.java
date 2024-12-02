package com.nathannicolau.guarani.app.utils;

public enum StatusProduto {

    NORMAL(0,"N","NORMAL"),
    PARA_ESTOQUE(1,"PE","PARA ESTOQUE"),
    LANCAMENTO(2,"L","LANÇAMENTO"),
    PROMOCAO(3,"P","PROMOCAO");

    private int id;
    private String status;
    private String descricao;

    StatusProduto(int id,String status, String descricao) {
        this.id = id;
        this.status = status;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static StatusProduto getStatusProdutoPorCodigo(int codigo) {
        for(StatusProduto statusProduto : StatusProduto.values()) {
            if(statusProduto.getId() == codigo) {
                return statusProduto;
            }
        }
        return NORMAL;
    }

}
