package com.nathannicolau.guarani.app.model.repository;

import android.content.Context;

import androidx.sqlite.db.SimpleSQLiteQuery;

import com.nathannicolau.guarani.app.App;
import com.nathannicolau.guarani.app.model.AppDatabase;
import com.nathannicolau.guarani.app.model.dao.ClienteDAO;
import com.nathannicolau.guarani.app.model.data.Cliente;
import com.nathannicolau.guarani.app.model.vo.ClienteVO;
import com.nathannicolau.guarani.app.utils.FiltroPesquisaCliente;
import com.nathannicolau.guarani.app.utils.TipoPessoa;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private final ClienteDAO clienteDAO;

    public ClienteRepository() {
        clienteDAO = App.getDatabase().clienteDAO();
    }

    public List<ClienteVO> getClientes(FiltroPesquisaCliente filtro) {
        if(filtro.possuiQualquerFiltroInformado()) {
            StringBuilder sb = new StringBuilder(" SELECT * FROM CLIENTE WHERE ");
            if (filtro.getTipoPessoa() == TipoPessoa.FISICA) {
                sb.append(" CLI_PESSOA = 'F' ");
            } else {
                sb.append(" CLI_PESSOA = 'J' ");
            }

            if(filtro.possuiFiltroCnpjCpf() || filtro.possuiFiltroNomeFantasia() || filtro.possuiFiltroRazaoSocial()) {
                sb.append(" AND ");
            }

            if (filtro.possuiFiltroRazaoSocial()) {
                sb.append("CLI_RAZAOSOCIAL LIKE '%").append(filtro.getRazaoSocial()).append("%'");
            }
            if (filtro.possuiFiltroCnpjCpf()) {
                if (filtro.possuiFiltroRazaoSocial()) {
                    sb.append(" AND ");
                    sb.append(" CLI_CGCCPF LIKE '%").append(filtro.getCnpjCpf()).append("%'");
                } else {
                    sb.append(" CLI_CGCCPF LIKE '%").append(filtro.getCnpjCpf()).append("%'");
                }
            }
            if (filtro.possuiFiltroNomeFantasia()) {
                if (filtro.possuiFiltroRazaoSocial() || filtro.possuiFiltroCnpjCpf()) {
                    sb.append(" AND ");
                    sb.append(" CLI_NOMEFANTASIA LIKE '%").append(filtro.getNomeFantasia()).append("%'");
                } else {
                    sb.append(" CLI_NOMEFANTASIA LIKE '%").append(filtro.getNomeFantasia()).append("%'");
                }
            }
            String sql = sb.toString();
            List<Cliente> listaClientes = clienteDAO.getClientePorFiltros(new SimpleSQLiteQuery(sql));
            List<ClienteVO> listaClientesVO = new ArrayList<>();
            listaClientes.forEach(cliente -> {
                listaClientesVO.add(cliente.getClienteVO());
            });
            return listaClientesVO;

        } else {
            return new ArrayList<>();
        }

    }

    public void atualizarCliente(ClienteVO clienteVO) {
        clienteDAO.updateCliente(clienteVO.toClienteData());
    }

    public void excluirCliente(ClienteVO clienteVO) {
        clienteDAO.deleteClientePorCodigo(clienteVO.getCodigoCliente());
    }

    public void cadastrarCliente(ClienteVO clienteVO) {
        clienteDAO.insertCliente(clienteVO.toClienteData());
    }

    public String getNovoCodigoCliente() {
        String ultimoCodigoCliente = clienteDAO.getUltimoCodigoCliente();
        if(ultimoCodigoCliente == null) {
            return "1";
        } else {
            return String.valueOf(Integer.parseInt(ultimoCodigoCliente) + 1);
        }
    }


}
