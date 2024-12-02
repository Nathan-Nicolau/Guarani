package com.nathannicolau.guarani.app.model.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.nathannicolau.guarani.app.model.vo.PrecoVO;

import java.math.BigDecimal;

@Entity(tableName = "PRECO")
public class Preco {

    @PrimaryKey()
    @ColumnInfo(name = "ID_PRECO")
    @NonNull
    private String idPreco;

    @ColumnInfo(name = "PRP_CODIGO")
    private String prpCodigo;

    @ColumnInfo(name = "PRP_PRECOS")
    private String prpPrecos;

    public String getIdPreco() {
        return idPreco;
    }

    public void setIdPreco(String idPreco) {
        this.idPreco = idPreco;
    }

    public String getPrpCodigo() {
        return prpCodigo;
    }

    public void setPrpCodigo(String prpCodigo) {
        this.prpCodigo = prpCodigo;
    }

    public String getPrpPrecos() {
        return prpPrecos;
    }

    public void setPrpPrecos(String prpPrecos) {
        this.prpPrecos = prpPrecos;
    }

    public Preco() {
    }

    public Preco(String preco,String prpCodigo, String prpPrecos) {
        this.idPreco = preco;
        this.prpCodigo = prpCodigo;
        this.prpPrecos = prpPrecos;
    }

    public PrecoVO getPrecoVO() {
        PrecoVO precoVO = new PrecoVO();
        precoVO.setIdPreco(idPreco);
        precoVO.setPrpCodigoVO(prpCodigo);
        precoVO.setPrpPrecosVO(prpPrecos);
        return precoVO;
    }


}
