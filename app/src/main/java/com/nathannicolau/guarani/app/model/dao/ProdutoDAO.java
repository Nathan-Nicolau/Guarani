package com.nathannicolau.guarani.app.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import com.nathannicolau.guarani.app.model.data.Produto;
import java.util.List;

@Dao
public interface ProdutoDAO {

    @Query("SELECT * FROM PRODUTO")
    List<Produto> getTodosProdutos();

    @Query("SELECT * FROM PRODUTO WHERE PRO_STATUS = :status")
    List<Produto> getTodosProdutosPorStatus(String status);

    @Query("SELECT * FROM PRODUTO WHERE PRO_CODIGO = :codigo")
    Produto getProdutoPorCodigo(String codigo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduto(Produto produto);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProdutos(List<Produto> produtos);

}
