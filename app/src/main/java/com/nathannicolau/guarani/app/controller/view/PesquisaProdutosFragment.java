package com.nathannicolau.guarani.app.controller.view;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.nathannicolau.guarani.R;
import com.nathannicolau.guarani.app.controller.adapters.AdapterProduto;
import com.nathannicolau.guarani.app.model.repository.ProdutoRepository;
import com.nathannicolau.guarani.app.model.vo.ProdutoVO;
import com.nathannicolau.guarani.app.utils.StatusProduto;

import java.util.ArrayList;
import java.util.List;

public class PesquisaProdutosFragment extends Fragment {

    private Spinner spnStatusProduto;
    private MaterialButton btnPesquisarProdutos;
    private RecyclerView rvListaProdutos;
    private LinearLayout layoutPesquisaCarregando;
    private ArrayList<String> listaStatusProduto;
    private StatusProduto statusSelecionado;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pesquisa_produtos, container, false);
        setupViews(view);
        initValues();
        setOnClickListener();
        return view;
    }

    private void initValues() {
        statusSelecionado = StatusProduto.NORMAL;
    }

    private void setupViews(View view) {
        spnStatusProduto = view.findViewById(R.id.spn_status_produto);
        btnPesquisarProdutos = view.findViewById(R.id.btn_pesquisar_produtos);
        rvListaProdutos = view.findViewById(R.id.rv_lista_produtos);
        layoutPesquisaCarregando = view.findViewById(R.id.layout_pesquisa_carregando);
        setSpinnerAdapter();
        setListaProdutosVazios();
    }

    private void setOnClickListener() {
        btnPesquisarProdutos.setOnClickListener(v -> {
            pesquisarProdutosPorStatus();
        });
    }

    private void setSpinnerAdapter() {
        listaStatusProduto = new ArrayList<>();
        listaStatusProduto.add("Normal");
        listaStatusProduto.add("Para estoque");
        listaStatusProduto.add("Lançamento");
        listaStatusProduto.add("Promoção");
        setOnItemSelectedSpinner();
        spnStatusProduto.setAdapter(new ArrayAdapter<>(getContext(), R.layout.spinner_adapter, listaStatusProduto));
    }

    private void setOnItemSelectedSpinner() {
        spnStatusProduto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                statusSelecionado = StatusProduto.getStatusProdutoPorCodigo(position);
                setListaProdutosVazios();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setListaProdutosVazios() {
        List<ProdutoVO> listaProdutoVOS = new ArrayList<>();
        //Realizar pesquisa de produtos
        setRecyclerViewAdapter(listaProdutoVOS);
    }

    private void pesquisarProdutosPorStatus() {
        new Thread(() -> {

            requireActivity().runOnUiThread(() -> {
                setAnimationLoading(true);
            });

            List<ProdutoVO> listaProdutosEncontrados = new ArrayList<>();

            ProdutoRepository produtoRepository = new ProdutoRepository();
            listaProdutosEncontrados = produtoRepository.getProdutosPorStatus(statusSelecionado.getStatus());
            if(!listaProdutosEncontrados.isEmpty()) {
                List<ProdutoVO> finalListaProdutosEncontrados = listaProdutosEncontrados;
                requireActivity().runOnUiThread(() -> {
                    setAnimationLoading(false);
                    setRecyclerViewAdapter(finalListaProdutosEncontrados);
                });
            } else {
                Handler handler = new Handler(getContext().getMainLooper());
                handler.postDelayed(() -> {
                    setAnimationLoading(false);
                    setListaProdutosVazios();
                    Toast.makeText(getContext(),"Nenhum produto encontrado com o status informado",Toast.LENGTH_LONG).show();
                },800);
            }
        }).start();
    }

    private void setAnimationLoading(boolean visualizar) {
        layoutPesquisaCarregando.setVisibility(visualizar ? View.VISIBLE : View.GONE);
    }

    private void setRecyclerViewAdapter(List<ProdutoVO> produtoVOS) {
        rvListaProdutos.setLayoutManager(new LinearLayoutManager(getContext()));
        rvListaProdutos.setAdapter(new AdapterProduto(getContext(), produtoVOS));
    }
}
