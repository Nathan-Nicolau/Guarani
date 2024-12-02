package com.nathannicolau.guarani.app.controller.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.nathannicolau.guarani.R;
import com.nathannicolau.guarani.app.controller.dialogs.DialogPrecosProduto;
import com.nathannicolau.guarani.app.model.vo.ProdutoVO;

import java.util.List;

public class AdapterProduto extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ProdutoVO> produtoVOS;

    public AdapterProduto(Context context,List<ProdutoVO> produtoVOS) {
        this.produtoVOS = produtoVOS;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_produto, parent, false);
        return new ProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProdutoVO produtoVO = produtoVOS.get(position);
        ProdutoViewHolder produtoViewHolder = (ProdutoViewHolder) holder;
        produtoViewHolder.codigo.setText(String.valueOf(produtoVO.getCodigo()));
        produtoViewHolder.descricao.setText(produtoVO.getDescricao());
        produtoViewHolder.estoque.setText(String.valueOf(produtoVO.getEstoque()));
        setOnClickListener(produtoViewHolder.card, produtoVO);
    }

    private void setOnClickListener(MaterialCardView card, ProdutoVO produtoVO) {
        card.setOnClickListener( v -> {
            DialogPrecosProduto precosProduto = new DialogPrecosProduto(context, produtoVO.getListaPrecos());
            precosProduto.show();
        });
    }

    @Override
    public int getItemCount() {
        return produtoVOS.size();
    }

    public static class ProdutoViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView card;
        TextView codigo;
        TextView descricao;
        TextView estoque;

        public ProdutoViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_produto);
            codigo = itemView.findViewById(R.id.tv_codigo_produto);
            descricao = itemView.findViewById(R.id.tv_descricao_produto);
            estoque = itemView.findViewById(R.id.tv_estoque_produto);
        }
    }
}
