package com.nathannicolau.guarani.app.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Update;
import androidx.sqlite.db.SupportSQLiteQuery;

import com.nathannicolau.guarani.app.model.data.Cliente;

import java.util.List;

@Dao
public interface ClienteDAO {

    @Query("SELECT MAX(CLI_CODIGOCLIENTE) FROM CLIENTE")
    String getUltimoCodigoCliente();

    @Query("SELECT * FROM CLIENTE")
    List<Cliente> getAll();

    @RawQuery(observedEntities = Cliente.class)
    List<Cliente> getClientePorFiltros(SupportSQLiteQuery query);

    @Query("SELECT * FROM CLIENTE WHERE CLI_RAZAOSOCIAL LIKE :razaoSocial")
    List<Cliente> getClientesPorRazaoSocial(String razaoSocial);

    @Query("SELECT * FROM CLIENTE WHERE CLI_NOMEFANTASIA LIKE :nomeFantasia")
    List<Cliente> getClientesPorNomeFantasia(String nomeFantasia);

    @Query("SELECT * FROM CLIENTE WHERE CLI_CGCCPF LIKE :cpfCnpj")
    List<Cliente> getClientesPorCpfCnpj(String cpfCnpj);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCliente(Cliente cliente);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertClientes(List<Cliente> clientes);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCliente(Cliente cliente);

    @Update
    void updateAll(List<Cliente> clientes);

    @Query("DELETE FROM CLIENTE WHERE CLI_CODIGOCLIENTE LIKE :codigoCliente")
    void deleteClientePorCodigo(String codigoCliente);

}
