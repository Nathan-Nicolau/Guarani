package com.nathannicolau.guarani.app.utils;

public class FiltroPesquisaCliente {

    private TipoPessoa tipoPessoa;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpjCpf;

    public boolean possuiFiltroRazaoSocial() {
        return !razaoSocial.isEmpty();
    }

    public boolean possuiFiltroNomeFantasia() {
        return !nomeFantasia.isEmpty();
    }

    public boolean possuiFiltroCnpjCpf() {
        return !cnpjCpf.isEmpty();
    }

    public boolean possuiQualquerFiltroInformado() {
        return possuiFiltroRazaoSocial() || possuiFiltroNomeFantasia() || possuiFiltroCnpjCpf();
    }


    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }
}
