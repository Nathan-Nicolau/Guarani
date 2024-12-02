package com.nathannicolau.guarani.app.model.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.nathannicolau.guarani.app.model.vo.ClienteVO;

@Entity(tableName = "CLIENTE")
public class Cliente {

    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "CLI_CODIGOCLIENTE")
    private String cliCodigocliente;

    @ColumnInfo(name = "CLI_PESSOA")
    private String cliPessoa;

    @ColumnInfo(name = "CLI_RAZAOSOCIAL")
    private String cliRazaoSocial;

    @ColumnInfo(name = "CLI_NOMEFANTASIA")
    private String cliNomefantasia;

    @ColumnInfo(name = "CLI_CGCCPF")
    private String cliCgccpf;

    @ColumnInfo(name = "CLI_EMAIL")
    private String cliEmail;

    @ColumnInfo(name = "CLI_EMAILSECUNDARIO")
    private String cliEmailSecundario;

    @ColumnInfo(name = "CLI_ENDERECO")
    private String cliEndereco;

    @ColumnInfo(name = "CLI_BAIRRO")
    private String cliBairro;

    @ColumnInfo(name = "CLI_NUMERO")
    private String cliNumero;

    @ColumnInfo(name = "CLI_ENDERECOENTREGA")
    private String cliEnderecoentrega;

    @ColumnInfo(name = "CLI_BAIRROENTREGA")
    private String cliBairroentrega;

    @ColumnInfo(name = "CLI_NUMEROENTREGA")
    private String cliNumeroentrega;

    @ColumnInfo(name = "CLI_ENDERECOCOBRANCA")
    private String cliEnderecocobranca;

    @ColumnInfo(name = "CLI_BAIRROCOBRANCA")
    private String cliBairrocobranca;

    @ColumnInfo(name = "CLI_NUMEROCOBRANCA")
    private String cliNumerocobranca;

    public Cliente() {
    }

    public Cliente(@NonNull String cliCodigocliente, String cliPessoa, String cliRazaoSocial, String cliNomefantasia, String cliCgccpf, String cliEmail, String cliEmailSecundario, String cliEndereco, String cliBairro, String cliNumero, String cliEnderecoentrega, String cliBairroentrega, String cliNumeroentrega, String cliEnderecocobranca, String cliBairrocobranca, String cliNumerocobranca) {
        this.cliCodigocliente = cliCodigocliente;
        this.cliPessoa = cliPessoa;
        this.cliRazaoSocial = cliRazaoSocial;
        this.cliNomefantasia = cliNomefantasia;
        this.cliCgccpf = cliCgccpf;
        this.cliEmail = cliEmail;
        this.cliEmailSecundario = cliEmailSecundario;
        this.cliEndereco = cliEndereco;
        this.cliBairro = cliBairro;
        this.cliNumero = cliNumero;
        this.cliEnderecoentrega = cliEnderecoentrega;
        this.cliBairroentrega = cliBairroentrega;
        this.cliNumeroentrega = cliNumeroentrega;
        this.cliEnderecocobranca = cliEnderecocobranca;
        this.cliBairrocobranca = cliBairrocobranca;
        this.cliNumerocobranca = cliNumerocobranca;
    }

    public String getCliCodigocliente() {
        return cliCodigocliente;
    }

    public void setCliCodigocliente(String cliCodigocliente) {
        this.cliCodigocliente = cliCodigocliente;
    }

    public String getCliPessoa() {
        return cliPessoa;
    }

    public void setCliPessoa(String cliPessoa) {
        this.cliPessoa = cliPessoa;
    }

    public String getCliRazaoSocial() {
        return cliRazaoSocial;
    }

    public void setCliRazaoSocial(String cliRazaoSocial) {
        this.cliRazaoSocial = cliRazaoSocial;
    }

    public String getCliNomefantasia() {
        return cliNomefantasia;
    }

    public void setCliNomefantasia(String cliNomefantasia) {
        this.cliNomefantasia = cliNomefantasia;
    }

    public String getCliCgccpf() {
        return cliCgccpf;
    }

    public void setCliCgccpf(String cliCgccpf) {
        this.cliCgccpf = cliCgccpf;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliEmailSecundario() {
        return cliEmailSecundario;
    }

    public void setCliEmailSecundario(String cliEmailSecundario) {
        this.cliEmailSecundario = cliEmailSecundario;
    }

    public String getCliEndereco() {
        return cliEndereco;
    }

    public void setCliEndereco(String cliEndereco) {
        this.cliEndereco = cliEndereco;
    }

    public String getCliBairro() {
        return cliBairro;
    }

    public void setCliBairro(String cliBairro) {
        this.cliBairro = cliBairro;
    }

    public String getCliNumero() {
        return cliNumero;
    }

    public void setCliNumero(String cliNumero) {
        this.cliNumero = cliNumero;
    }

    public String getCliEnderecoentrega() {
        return cliEnderecoentrega;
    }

    public void setCliEnderecoentrega(String cliEnderecoentrega) {
        this.cliEnderecoentrega = cliEnderecoentrega;
    }

    public String getCliBairroentrega() {
        return cliBairroentrega;
    }

    public void setCliBairroentrega(String cliBairroentrega) {
        this.cliBairroentrega = cliBairroentrega;
    }

    public String getCliNumeroentrega() {
        return cliNumeroentrega;
    }

    public void setCliNumeroentrega(String cliNumeroentrega) {
        this.cliNumeroentrega = cliNumeroentrega;
    }

    public String getCliEnderecocobranca() {
        return cliEnderecocobranca;
    }

    public void setCliEnderecocobranca(String cliEnderecocobranca) {
        this.cliEnderecocobranca = cliEnderecocobranca;
    }

    public String getCliBairrocobranca() {
        return cliBairrocobranca;
    }

    public void setCliBairrocobranca(String cliBairrocobranca) {
        this.cliBairrocobranca = cliBairrocobranca;
    }

    public String getCliNumerocobranca() {
        return cliNumerocobranca;
    }

    public void setCliNumerocobranca(String cliNumerocobranca) {
        this.cliNumerocobranca = cliNumerocobranca;
    }

    public ClienteVO getClienteVO() {
        ClienteVO clienteVO = new ClienteVO();
        clienteVO.setCodigoCliente(cliCodigocliente);
        clienteVO.setCliPessoa(cliPessoa);
        clienteVO.setRazaoSocial(cliRazaoSocial);
        clienteVO.setNomeFantasia(cliNomefantasia);
        clienteVO.setCpfCnpj(cliCgccpf);
        clienteVO.setEmailPrincipal(cliEmail);
        clienteVO.setEmailSecundario(cliEmailSecundario);
        clienteVO.setEnderecoPrincipal(cliEndereco);
        clienteVO.setBairroEnderecoPrincipal(cliBairro);
        clienteVO.setNumeroEnderecoPrincipal(cliNumero);
        clienteVO.setEnderecoEntrega(cliEnderecoentrega);
        clienteVO.setBairroEnderecoEntrega(cliBairroentrega);
        clienteVO.setNumeroEnderecoEntrega(cliNumeroentrega);
        clienteVO.setEnderecoCobranca(cliEnderecocobranca);
        clienteVO.setBairroEnderecoCobranca(cliBairrocobranca);
        clienteVO.setNumeroEnderecoCobranca(cliNumerocobranca);
        return clienteVO;
    }


}
