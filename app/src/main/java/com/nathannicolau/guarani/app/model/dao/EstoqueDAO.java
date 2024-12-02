package com.nathannicolau.guarani.app.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.nathannicolau.guarani.app.model.data.Estoque;

import java.util.List;

@Dao
public interface EstoqueDAO {

    @Query("SELECT * FROM ESTOQUE")
    List<Estoque> getTodosEstoque();

    @Query("SELECT * FROM ESTOQUE WHERE ESE_CODIGO = :eseCodigo")
    Estoque getEstoquePorCodigo(String eseCodigo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEstoque(Estoque estoque);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserEstoques(List<Estoque> estoques);

}
