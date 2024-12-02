package com.nathannicolau.guarani.app.controller.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.nathannicolau.guarani.R;
import com.nathannicolau.guarani.app.model.data.Cliente;
import com.nathannicolau.guarani.app.model.repository.ClienteRepository;
import com.nathannicolau.guarani.app.model.vo.ClienteVO;
import com.nathannicolau.guarani.app.utils.TipoPessoa;

public class CadastroClienteFragment extends Fragment {

    private Spinner spTipoPessoa;
    private TextInputLayout tilNomeFantasia;
    private TextInputLayout tilCnpj;
    private TextInputEditText inputNomeFantasia;
    private TextInputEditText inputCnpj;
    private TextInputEditText inputRazaoSocial;
    private TextInputEditText inputEmailPrincipal;
    private TextInputEditText inputEmailSecundario;
    private TextInputEditText inputEnderecoPrincipal;
    private TextInputEditText inputBairroPrincipal;
    private TextInputEditText inputNumeroPrincipal;
    private TextInputEditText inputEnderecoEntrega;
    private TextInputEditText inputBairroEntrega;
    private TextInputEditText inputNumeroEntrega;
    private TextInputEditText inputEnderecoCobranca;
    private TextInputEditText inputBairroCobranca;
    private TextInputEditText inputNumeroCobranca;
    private MaterialButton btnCadastrar;
    private TipoPessoa tipoPessoaSelecionada;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cadastro_cliente, container, false);
        setupViews(view);
        setSpinnerAdapter();
        setOnClickListener();
        ajustarTipoPessoaSelecionada();
        return view;
    }

    private void setupViews(View view) {
        spTipoPessoa = view.findViewById(R.id.sp_tipo_pessoa_cadastro);
        tilNomeFantasia = view.findViewById(R.id.til_nome_fantasia);
        tilCnpj = view.findViewById(R.id.til_cpf_cnpj);
        inputNomeFantasia = view.findViewById(R.id.input_cadastro_nome_fantasia);
        inputCnpj = view.findViewById(R.id.input_cadastro_cpf_cnpj);
        inputRazaoSocial = view.findViewById(R.id.input_cadastro_razao_social);
        inputEmailPrincipal = view.findViewById(R.id.input_cadastro_email_principal);
        inputEmailSecundario = view.findViewById(R.id.input_cadastro_email_secundario);
        inputEnderecoPrincipal = view.findViewById(R.id.input_cadastro_endereco_principal);
        inputBairroPrincipal = view.findViewById(R.id.input_cadastro_bairro_principal);
        inputNumeroPrincipal = view.findViewById(R.id.input_cadastro_numero_principal);
        inputEnderecoEntrega = view.findViewById(R.id.input_cadastro_endereco_entrega);
        inputBairroEntrega = view.findViewById(R.id.input_cadastro_bairro_entrega);
        inputNumeroEntrega = view.findViewById(R.id.input_cadastro_numero_entrega);
        inputEnderecoCobranca = view.findViewById(R.id.input_cadastro_endereco_cobranca);
        inputBairroCobranca = view.findViewById(R.id.input_cadastro_bairro_cobranca);
        inputNumeroCobranca = view.findViewById(R.id.input_cadastro_numero_cobranca);
        btnCadastrar = view.findViewById(R.id.btn_cadastrar);
    }

    private void setSpinnerAdapter() {
        spTipoPessoa.setAdapter(new ArrayAdapter<>(getContext(),R.layout.spinner_adapter, TipoPessoa.values()));
        spTipoPessoa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoPessoaSelecionada = TipoPessoa.values()[position];
                ajustarTipoPessoaSelecionada();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void ajustarTipoPessoaSelecionada() {
        if(tipoPessoaSelecionada == TipoPessoa.FISICA) {
            tilCnpj.setHint(getContext().getString(R.string.hint_cadastrar_cpf));
            tilNomeFantasia.setVisibility(View.GONE);
        } else {
            tilCnpj.setHint(getContext().getString(R.string.hint_cadastrar_cnpj));
            tilNomeFantasia.setVisibility(View.VISIBLE);
        }
    }

    private ClienteVO getCadastroNovoCliente() {
        Cliente cliente = new Cliente();
        cliente.setCliRazaoSocial(inputRazaoSocial.getText().toString());
        cliente.setCliPessoa(tipoPessoaSelecionada.getTipo().toString());
        cliente.setCliNomefantasia(inputNomeFantasia.getText().toString());
        cliente.setCliCgccpf(inputCnpj.getText().toString());
        cliente.setCliEmail(inputEmailPrincipal.getText().toString());
        cliente.setCliEmailSecundario(inputEmailSecundario.getText().toString());
        cliente.setCliEndereco(inputEnderecoPrincipal.getText().toString());
        cliente.setCliBairro(inputBairroPrincipal.getText().toString());
        cliente.setCliNumero(inputNumeroPrincipal.getText().toString());
        cliente.setCliEnderecoentrega(inputEnderecoEntrega.getText().toString());
        cliente.setCliBairroentrega(inputBairroEntrega.getText().toString());
        cliente.setCliNumeroentrega(inputNumeroEntrega.getText().toString());
        cliente.setCliEnderecocobranca(inputEnderecoCobranca.getText().toString());
        cliente.setCliBairrocobranca(inputBairroCobranca.getText().toString());
        cliente.setCliNumerocobranca(inputNumeroCobranca.getText().toString());
        return cliente.getClienteVO();
    }

    private void limparCampos() {
        inputRazaoSocial.setText("");
        inputNomeFantasia.setText("");
        inputCnpj.setText("");
        inputEmailPrincipal.setText("");
        inputEmailSecundario.setText("");
        inputEnderecoPrincipal.setText("");
        inputBairroPrincipal.setText("");
        inputNumeroPrincipal.setText("");
        inputEnderecoEntrega.setText("");
        inputBairroEntrega.setText("");
        inputNumeroEntrega.setText("");
        inputEnderecoCobranca.setText("");
        inputBairroCobranca.setText("");
        inputNumeroCobranca.setText("");
        spTipoPessoa.setSelection(0);
    }

    private void setOnClickListener() {
        btnCadastrar.setOnClickListener(v -> {
            new Thread(() -> {
                try {
                    ClienteVO clienteNovo = getCadastroNovoCliente();
                    ClienteRepository clienteRepository = new ClienteRepository();
                    String novoCodigo = clienteRepository.getNovoCodigoCliente();
                    clienteNovo.setCodigoCliente(novoCodigo);
                    clienteRepository.cadastrarCliente(clienteNovo);
                    requireActivity().runOnUiThread(() -> {
                        Toast.makeText(getContext(), "Cliente cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                        limparCampos();
                    });
                    } catch (Exception e) {
                        requireActivity().runOnUiThread(() -> {
                            Toast.makeText(getContext(), "Erro ao cadastrar cliente!", Toast.LENGTH_SHORT).show();
                            limparCampos();
                        });
                    }
            }).start();
        });
    }


}
