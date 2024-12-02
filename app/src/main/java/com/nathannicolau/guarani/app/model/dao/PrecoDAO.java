package com.nathannicolau.guarani.app.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.nathannicolau.guarani.app.model.data.Preco;

import java.util.List;

@Dao
public interface PrecoDAO {

    @Query("SELECT * FROM PRECO")
    List<Preco> getTodosPrecos();

    @Query("SELECT * FROM PRECO WHERE PRP_CODIGO =:prpCodigo ORDER BY PRP_PRECOS DESC")
    List<Preco>getPrecosPorCodigo(String prpCodigo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPreco(Preco preco);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPrecos(List<Preco> preco);

}
