package com.nathannicolau.guarani.app.utils;

public enum TipoPessoa {

    FISICA(0, "F", "Pessoa Física"),
    JURIDICA(1, "J", "Pessoa Jurídica");

    private int id;
    private String tipo;
    private String descricao;

    TipoPessoa(int id, String tipo, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public static TipoPessoa getTipoPessoa(String tipo) {
        for (TipoPessoa tipoPessoa : TipoPessoa.values()) {
            if (tipoPessoa.getTipo() == tipo) {
                return tipoPessoa;
            }
        }
        return FISICA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
