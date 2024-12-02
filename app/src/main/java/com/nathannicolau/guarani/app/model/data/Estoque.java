package com.nathannicolau.guarani.app.model.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ESTOQUE")
public class Estoque {

    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "ESE_CODIGO")
    private String eseCodigo;

    @ColumnInfo(name = "ESE_ESTOQUE")
    private Integer eseEstoque;

    public Estoque() {
    }

    public Estoque(@NonNull String eseCodigo, Integer eseEstoque) {
        this.eseCodigo = eseCodigo;
        this.eseEstoque = eseEstoque;
    }

    public Integer getEseEstoque() {
        return eseEstoque;
    }

    public void setEseEstoque(Integer eseEstoque) {
        this.eseEstoque = eseEstoque;
    }

    public String getEseCodigo() {
        return eseCodigo;
    }

    public void setEseCodigo(String eseCodigo) {
        this.eseCodigo = eseCodigo;
    }
}
