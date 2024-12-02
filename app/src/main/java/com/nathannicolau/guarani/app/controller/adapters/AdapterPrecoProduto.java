package com.nathannicolau.guarani.app.controller.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nathannicolau.guarani.R;
import com.nathannicolau.guarani.app.model.vo.PrecoVO;

import java.util.List;

public class AdapterPrecoProduto extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<PrecoVO> listaPrecos;

    public AdapterPrecoProduto(List<PrecoVO> listaPrecos) {
        this.listaPrecos = listaPrecos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_preco_produto, parent, false);
        return new PrecoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PrecoViewHolder viewHolderPrecoProduto = (PrecoViewHolder) holder;
        PrecoVO precoVO = listaPrecos.get(position);
        viewHolderPrecoProduto.tvPreco.setText(precoVO.getPrpPrecosVO());
    }

    @Override
    public int getItemCount() {
        return listaPrecos.size();
    }

    public static class PrecoViewHolder extends RecyclerView.ViewHolder {

        TextView tvPreco;

        public PrecoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPreco = itemView.findViewById(R.id.tv_preco_produto);
        }
    }
}
