package com.nathannicolau.guarani.app.model.repository;

import android.content.Context;
import android.os.Handler;

import androidx.sqlite.db.SimpleSQLiteQuery;

import com.nathannicolau.guarani.app.App;
import com.nathannicolau.guarani.app.model.AppDatabase;
import com.nathannicolau.guarani.app.model.dao.EstoqueDAO;
import com.nathannicolau.guarani.app.model.dao.PrecoDAO;
import com.nathannicolau.guarani.app.model.dao.ProdutoDAO;
import com.nathannicolau.guarani.app.model.data.Estoque;
import com.nathannicolau.guarani.app.model.data.Preco;
import com.nathannicolau.guarani.app.model.data.Produto;
import com.nathannicolau.guarani.app.model.vo.PrecoVO;
import com.nathannicolau.guarani.app.model.vo.ProdutoVO;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ProdutoRepository {

    private final ProdutoDAO produtoDAO;
    private final EstoqueDAO estoqueDAO;
    private final PrecoDAO precoDAO;
    private List<ProdutoVO> listaProdutosVO;

    public ProdutoRepository() {
        AppDatabase db = App.getDatabase();
        produtoDAO = db.produtoDAO();
        estoqueDAO = db.estoqueDAO();
        precoDAO = db.precoDAO();
    }

    public List<ProdutoVO> getProdutosPorStatus(String status) {

        List<ProdutoVO> listaProdutosVO = new ArrayList<>();
        List<Produto> listaProdutosEncontrados = produtoDAO.getTodosProdutosPorStatus(status);
        if(!listaProdutosEncontrados.isEmpty()) {
            listaProdutosEncontrados.forEach(produto -> {
                listaProdutosVO.add(produto.getProdutoVO());
            });
        }

        listaProdutosVO.forEach( produtoVO  -> {
            Estoque estoque = estoqueDAO.getEstoquePorCodigo(produtoVO.getCodigo());
            produtoVO.setEstoque(estoque.getEseEstoque());
        });

        listaProdutosVO.forEach( produtoVO -> {
            List<Preco> listaPrecosEncontrados = precoDAO.getPrecosPorCodigo(produtoVO.getCodigo());
            if(!listaPrecosEncontrados.isEmpty()) {
                List<PrecoVO> listaPrecos = new ArrayList<>();
                listaPrecosEncontrados.forEach( preco -> {
                    listaPrecos.add(preco.getPrecoVO());
                });
                produtoVO.setListaPrecos(listaPrecos);
            }
        });

        return listaProdutosVO;
    }

    public void inserirProdutos() {
        Thread t = new Thread(() -> produtoDAO.insertProduto(new Produto("WP001507","PRODUTO WP001507","N")));
        t.start();
    }

}
