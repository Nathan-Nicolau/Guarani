package com.nathannicolau.guarani.app.model.vo;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoVO {

    private String codigo;
    private String descricao;
    private Integer estoque;
    private Float precoMinimo;
    private Float precoMaximo;
    private List<PrecoVO> listaPrecos;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Float getPrecoMinimo() {
        Float precoMinimoEncontrado = 0f;
        if(listaPrecos != null) {
            listaPrecos.forEach( precoVO -> {
                if(Float.parseFloat(precoVO.getPrpPrecosVO()) < precoMinimoEncontrado.floatValue()) {
                    precoMinimo = Float.parseFloat(precoVO.getPrpPrecosVO());
                }
            });
        }
        return precoMinimo;
    }

    public void setPrecoMinimo(Float precoMinimo) {
        this.precoMinimo = precoMinimo;
    }

    public Float getPrecoMaximo() {
        BigDecimal precoMaximoEncontrado =  BigDecimal.ZERO;
        if(listaPrecos != null) {
            listaPrecos.forEach( precoVO -> {
                if(Float.parseFloat(precoVO.getPrpPrecosVO()) > precoMaximoEncontrado.floatValue()) {
                    precoMaximo = Float.parseFloat(precoVO.getPrpPrecosVO());
                }
            });
        }
        return precoMaximo;
    }

    public void setPrecoMaximo(Float precoMaximo) {
        this.precoMaximo = precoMaximo;
    }

    public List<PrecoVO> getListaPrecos() {
        return listaPrecos;
    }

    public void setListaPrecos(List<PrecoVO> listaPrecos) {
        this.listaPrecos = listaPrecos;
    }
}
