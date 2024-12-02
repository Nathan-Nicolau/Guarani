package com.nathannicolau.guarani.app.model.vo;

import com.nathannicolau.guarani.app.model.data.Cliente;

public class ClienteVO {

    private String codigoCliente;
    private String cliPessoa;
    private String razaoSocial;
    private String nomeFantasia;
    private String cpfCnpj;
    private String emailPrincipal;
    private String emailSecundario;
    private String enderecoPrincipal;
    private String bairroEnderecoPrincipal;
    private String numeroEnderecoPrincipal;
    private String enderecoEntrega;
    private String bairroEnderecoEntrega;
    private String numeroEnderecoEntrega;
    private String enderecoCobranca;
    private String bairroEnderecoCobranca;
    private String numeroEnderecoCobranca;

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCliPessoa() {
        return cliPessoa;
    }

    public void setCliPessoa(String cliPessoa) {
        this.cliPessoa = cliPessoa;
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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    public String getEmailSecundario() {
        return emailSecundario;
    }

    public void setEmailSecundario(String emailSecundario) {
        this.emailSecundario = emailSecundario;
    }

    public String getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(String enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public String getBairroEnderecoPrincipal() {
        return bairroEnderecoPrincipal;
    }

    public void setBairroEnderecoPrincipal(String bairroEnderecoPrincipal) {
        this.bairroEnderecoPrincipal = bairroEnderecoPrincipal;
    }

    public String getNumeroEnderecoPrincipal() {
        return numeroEnderecoPrincipal;
    }

    public void setNumeroEnderecoPrincipal(String numeroEnderecoPrincipal) {
        this.numeroEnderecoPrincipal = numeroEnderecoPrincipal;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getBairroEnderecoEntrega() {
        return bairroEnderecoEntrega;
    }

    public void setBairroEnderecoEntrega(String bairroEnderecoEntrega) {
        this.bairroEnderecoEntrega = bairroEnderecoEntrega;
    }

    public String getNumeroEnderecoEntrega() {
        return numeroEnderecoEntrega;
    }

    public void setNumeroEnderecoEntrega(String numeroEnderecoEntrega) {
        this.numeroEnderecoEntrega = numeroEnderecoEntrega;
    }

    public String getEnderecoCobranca() {
        return enderecoCobranca;
    }

    public void setEnderecoCobranca(String enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
    }

    public String getBairroEnderecoCobranca() {
        return bairroEnderecoCobranca;
    }

    public void setBairroEnderecoCobranca(String bairroEnderecoCobranca) {
        this.bairroEnderecoCobranca = bairroEnderecoCobranca;
    }

    public String getNumeroEnderecoCobranca() {
        return numeroEnderecoCobranca;
    }

    public void setNumeroEnderecoCobranca(String numeroEnderecoCobranca) {
        this.numeroEnderecoCobranca = numeroEnderecoCobranca;
    }

    public boolean ehPessoaFisica() {
        return cliPessoa != null && cliPessoa.equals("F");
    }

    public boolean ehPessoaJuridica() {
        return cliPessoa != null && cliPessoa.equals("J");
    }

    public Cliente toClienteData() {
        Cliente cliente = new Cliente();
        cliente.setCliCodigocliente(codigoCliente);
        cliente.setCliPessoa(cliPessoa);
        cliente.setCliRazaoSocial(razaoSocial);
        cliente.setCliNomefantasia(nomeFantasia);
        cliente.setCliCgccpf(cpfCnpj);
        cliente.setCliEmail(emailPrincipal);
        cliente.setCliEmailSecundario(emailSecundario);
        cliente.setCliEndereco(enderecoPrincipal);
        cliente.setCliBairro(bairroEnderecoPrincipal);
        cliente.setCliNumero(numeroEnderecoPrincipal);
        cliente.setCliEnderecoentrega(enderecoEntrega);
        cliente.setCliBairroentrega(bairroEnderecoEntrega);
        cliente.setCliNumeroentrega(numeroEnderecoEntrega);
        cliente.setCliEnderecocobranca(enderecoCobranca);
        cliente.setCliBairrocobranca(bairroEnderecoCobranca);
        cliente.setCliNumerocobranca(numeroEnderecoCobranca);
        return cliente;
    }
}
