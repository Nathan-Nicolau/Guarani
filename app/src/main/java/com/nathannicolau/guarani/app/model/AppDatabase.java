package com.nathannicolau.guarani.app.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nathannicolau.guarani.app.model.dao.ClienteDAO;
import com.nathannicolau.guarani.app.model.dao.EstoqueDAO;
import com.nathannicolau.guarani.app.model.dao.PrecoDAO;
import com.nathannicolau.guarani.app.model.dao.ProdutoDAO;
import com.nathannicolau.guarani.app.model.data.Cliente;
import com.nathannicolau.guarani.app.model.data.Estoque;
import com.nathannicolau.guarani.app.model.data.Preco;
import com.nathannicolau.guarani.app.model.data.Produto;

@Database(entities = {Produto.class, Cliente.class, Estoque.class, Preco.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;
    public abstract ClienteDAO clienteDAO();
    public abstract EstoqueDAO estoqueDAO();
    public abstract PrecoDAO precoDAO();
    public abstract ProdutoDAO produtoDAO();

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "guarani").build();
                }
            }
        }
        return INSTANCE;
    }
}
