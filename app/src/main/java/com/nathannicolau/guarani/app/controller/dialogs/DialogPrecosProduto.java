package com.nathannicolau.guarani.app.controller.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nathannicolau.guarani.R;
import com.nathannicolau.guarani.app.controller.adapters.AdapterPrecoProduto;
import com.nathannicolau.guarani.app.model.vo.PrecoVO;

import java.util.ArrayList;
import java.util.List;

public class DialogPrecosProduto extends Dialog {

    private Context context;
    private List<PrecoVO> precosProduto;
    private RecyclerView rvListaPrecos;
    private LinearLayout layoutPrecosProduto;

    public DialogPrecosProduto(@NonNull Context context, List<PrecoVO> listaPrecos) {
        super(context);
        this.context = context;
        this.precosProduto = listaPrecos;
        init();
    }

    private void init() {
        setContentView(R.layout.dialog_precos_produto);
        layoutPrecosProduto = findViewById(R.id.layout_produtos);
        getWindow().setLayout((int) (context.getResources().getDisplayMetrics().widthPixels * 0.9), ViewGroup.LayoutParams.WRAP_CONTENT);

        precosProduto.forEach( preco -> {
            setListaPrecos(preco);
        });

    }

    private void setListaPrecos(PrecoVO precoVO) {
        LinearLayout layoutPreco = new LinearLayout(context);
        layoutPreco.setOrientation(LinearLayout.HORIZONTAL);
        layoutPreco.setGravity(Gravity.CENTER_VERTICAL);
        ImageView imageView = new ImageView(context);
        TextView textView = new TextView(context);
        imageView.setImageResource(R.drawable.ic_money_outlined_24dp);
        imageView.setColorFilter(R.color.verde_primario);
        imageView.setImageTintMode(PorterDuff.Mode.ADD);
        textView.setText(precoVO.getPrpPrecosVO());
        textView.setTextSize(14);
        layoutPreco.addView(imageView);
        layoutPreco.addView(textView);
        layoutPrecosProduto.addView(layoutPreco);
    }


}
