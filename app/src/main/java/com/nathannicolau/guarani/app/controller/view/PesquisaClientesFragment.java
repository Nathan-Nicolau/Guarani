package com.nathannicolau.guarani.app.controller.view;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.nathannicolau.guarani.R;
import com.nathannicolau.guarani.app.controller.adapters.AdapterCliente;
import com.nathannicolau.guarani.app.model.data.Cliente;
import com.nathannicolau.guarani.app.model.repository.ClienteRepository;
import com.nathannicolau.guarani.app.model.vo.ClienteVO;
import com.nathannicolau.guarani.app.utils.FiltroPesquisaCliente;
import com.nathannicolau.guarani.app.utils.TipoPessoa;

import java.util.ArrayList;
import java.util.List;

public class PesquisaClientesFragment extends Fragment {

    private Spinner spnTipoPessoa;
    private TextInputEditText inputRazaoSocial;
    private TextInputEditText inputNomeFantasia;
    private TextInputEditText inputCnpj;
    private TextInputLayout tilCpfCnpj;
    private MaterialButton btnPesquisarClientes;
    private RecyclerView rvClientes;
    private LinearLayout layoutPesquisaCarregando;
    private TipoPessoa tipoPessoaSelecionada;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pesquisa_cliente, container, false);
        setupViews(view);
        setSpinnerAdapter();
        setListaClientesVazios();
        setOnClickListener();
        return view;
    }

    private void setupViews(View view) {
        this.spnTipoPessoa = view.findViewById(R.id.spn_tipo_pessoa);
        this.inputRazaoSocial = view.findViewById(R.id.input_razao_social);
        this.inputNomeFantasia = view.findViewById(R.id.input_nome_fantasia);
        this.inputCnpj = view.findViewById(R.id.input_cnpj);
        this.tilCpfCnpj = view.findViewById(R.id.til_cpf_cnpj);
        this.btnPesquisarClientes = view.findViewById(R.id.btn_pesquisar_clientes);
        this.rvClientes = view.findViewById(R.id.rv_clientes);
        this.layoutPesquisaCarregando = view.findViewById(R.id.layout_pesquisa_carregando);
    }

    private void setSpinnerAdapter() {
        spnTipoPessoa.setAdapter(new ArrayAdapter<>(getContext(), R.layout.spinner_adapter, TipoPessoa.values()));
    }

    private void setOnClickListener() {

        spnTipoPessoa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoPessoaSelecionada = TipoPessoa.values()[position];
                setListaClientesVazios();
                ajustarInputsPesquisaPorTipoPessoa();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnPesquisarClientes.setOnClickListener(v -> {
            setListaClientesVazios();
            if(validarFiltrosInformados()) {
                pesquisarClientes();
            } else {
                requireActivity().runOnUiThread(() -> {
                    Toast.makeText(getContext(), "Informe algum filtro para pesquisa", Toast.LENGTH_SHORT).show();
                });
            }
        });
    }

    private boolean validarFiltrosInformados() {
        boolean temFiltros;
        Editable razaoSocial = inputRazaoSocial.getText();
        Editable nomeFantasia = inputNomeFantasia.getText();
        Editable cnpj = inputCnpj.getText();
        if(tipoPessoaSelecionada == TipoPessoa.FISICA) {
            temFiltros = razaoSocial != null && cnpj != null;
        } else {
            temFiltros = razaoSocial != null && nomeFantasia != null && cnpj != null;
        }
        return temFiltros;
    }

    private void ajustarInputsPesquisaPorTipoPessoa() {
        if(tipoPessoaSelecionada == TipoPessoa.FISICA) {
            tilCpfCnpj.setHint(R.string.hint_cpf);
            inputNomeFantasia.setVisibility(View.GONE);
        } else {
            tilCpfCnpj.setHint(R.string.hint_cnpj);
            inputNomeFantasia.setVisibility(View.VISIBLE);
        }
    }

    private void setListaClientesVazios() {
        rvClientes.setLayoutManager(new LinearLayoutManager(getContext()));
        rvClientes.setAdapter(new AdapterCliente(requireActivity(),new ArrayList<>()));
    }

    private void setAnimationLoading(boolean visualizar) {
        layoutPesquisaCarregando.setVisibility(visualizar ? View.VISIBLE : View.GONE);
    }

    private void pesquisarClientes() {
        new Thread(() -> {

            requireActivity().runOnUiThread(() -> {
                setAnimationLoading(true);
            });

            FiltroPesquisaCliente filtro = new FiltroPesquisaCliente();
            filtro.setTipoPessoa(tipoPessoaSelecionada);
            if(inputRazaoSocial.getText() != null) {
                filtro.setRazaoSocial(inputRazaoSocial.getText().toString());
            }
            if(inputNomeFantasia.getText() != null) {
                filtro.setNomeFantasia(inputNomeFantasia.getText().toString());
            }
            if(inputCnpj.getText() != null) {
                filtro.setCnpjCpf(inputCnpj.getText().toString());
            }
            ClienteRepository clienteRepository = new ClienteRepository();
            List<ClienteVO> clientesVO = clienteRepository.getClientes(filtro);

            Handler handler = new Handler(getContext().getMainLooper());
            if(!clientesVO.isEmpty()) {
                handler.postDelayed(() -> {
                    setAnimationLoading(false);
                    rvClientes.setAdapter(new AdapterCliente(requireActivity(),clientesVO));
                },1500);
            } else {
                handler.postDelayed(() -> {
                    setAnimationLoading(false);
                    Toast.makeText(getContext(), "Nenhum cliente encontrado", Toast.LENGTH_SHORT).show();
                    rvClientes.setAdapter(new AdapterCliente(requireActivity(),new ArrayList<>()));
                },1500);
            }
        }).start();
    }
}
