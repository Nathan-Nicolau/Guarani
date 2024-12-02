package com.nathannicolau.guarani.app.model.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.nathannicolau.guarani.app.model.vo.ProdutoVO;

@Entity(tableName = "PRODUTO")
public class Produto {

    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "PRO_CODIGO")
    private String proCodigo;

    @ColumnInfo(name = "PRO_DESCRICAO")
    private String proDescricao;

    @ColumnInfo(name = "PRO_STATUS")
    private String proStatus;

    public Produto() {}

    public Produto(@NonNull String proCodigo, String proDescricao, String proStatus) {
        this.proCodigo = proCodigo;
        this.proDescricao = proDescricao;
        this.proStatus = proStatus;
    }

    public String getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(String proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getProDescricao() {
        return proDescricao;
    }

    public void setProDescricao(String proDescricao) {
        this.proDescricao = proDescricao;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    public ProdutoVO getProdutoVO() {
        ProdutoVO produtoVO = new ProdutoVO();
        produtoVO.setCodigo(proCodigo);
        produtoVO.setDescricao(proDescricao);
        return produtoVO;
    }

}
