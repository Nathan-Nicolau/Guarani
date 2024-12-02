package com.nathannicolau.guarani.app.controller.dialogs;

import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nathannicolau.guarani.R;
import com.nathannicolau.guarani.app.controller.view.PesquisaClientesFragment;
import com.nathannicolau.guarani.app.model.repository.ClienteRepository;
import com.nathannicolau.guarani.app.model.vo.ClienteVO;
import com.nathannicolau.guarani.app.utils.TipoPessoa;

import java.sql.ClientInfoStatus;

public class DialogEditarCliente extends Dialog  {

    private final ClienteVO clienteEdicao;
    private TextInputEditText inputEditRazaoSocial;
    private TextInputEditText inputEditCpfCnpj;
    private TextInputEditText inputEditNomeFantasia;
    private TextInputEditText inputEditEmailPrincipal;
    private TextInputEditText inputEditEmailSecundario;
    private TextInputEditText inputEditEnderecoPrincipal;
    private TextInputEditText inputEditNumeroPrincipal;
    private TextInputEditText inputEditBairroPrincipal;
    private TextInputEditText inputEditEnderecoEntrega;
    private TextInputEditText inputEditNumeroEntrega;
    private TextInputEditText inputEditBairroEntrega;
    private TextInputEditText inputEditEnderecoCobranca;
    private TextInputEditText inputEditNumeroCobranca;
    private MaterialButton btnCancelarEdicao;
    private MaterialButton btnSalvarEdicao;
    private Spinner spnTipoPessoaEdicao;

    private Context context;

    public DialogEditarCliente(@NonNull Context context, ClienteVO clienteEdicao) {
        super(context);
        this.context = context;
        this.clienteEdicao = clienteEdicao;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setContentView(R.layout.dialog_editar_cliente);
        inputEditRazaoSocial = findViewById(R.id.input_edit_razao_social);
        inputEditCpfCnpj = findViewById(R.id.input_edit_cpf_cnpj);
        inputEditNomeFantasia = findViewById(R.id.input_edit_nome_fantasia);
        inputEditEmailPrincipal = findViewById(R.id.inout_edit_email_principal);
        inputEditEmailSecundario = findViewById(R.id.input_edit_email_secundario);
        inputEditEnderecoPrincipal = findViewById(R.id.input_edit_endereco_principal);
        inputEditNumeroPrincipal = findViewById(R.id.input_edit_numero_principal);
        inputEditBairroPrincipal = findViewById(R.id.input_edit_bairro_principal);
        inputEditEnderecoEntrega = findViewById(R.id.input_edit_endereco_entrega);
        inputEditNumeroEntrega = findViewById(R.id.input_edit_numero_entrega);
        inputEditBairroEntrega = findViewById(R.id.input_edit_bairro_entrega);
        inputEditEnderecoCobranca = findViewById(R.id.input_edit_endereco_cobranca);
        inputEditNumeroCobranca = findViewById(R.id.input_edit_numero_cobranca);
        spnTipoPessoaEdicao = findViewById(R.id.spn_tipo_pessoa_edicao);
        btnCancelarEdicao = findViewById(R.id.btn_cancelar_edicao);
        btnSalvarEdicao = findViewById(R.id.btn_salvar_edicao);
        atribuirValores();
        setOnClickListeners();
        getWindow().setLayout(
                (int) (context.getResources().getDisplayMetrics().widthPixels * 0.9),
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
    }

    private void atribuirValores() {
        if(!clienteEdicao.getRazaoSocial().isEmpty()) {
            inputEditRazaoSocial.setText(clienteEdicao.getRazaoSocial());
        }
        if(!clienteEdicao.getCpfCnpj().isEmpty()) {
            inputEditCpfCnpj.setText(clienteEdicao.getCpfCnpj());
        }
        if(!clienteEdicao.getNomeFantasia().isEmpty()) {
            inputEditNomeFantasia.setText(clienteEdicao.getNomeFantasia());
        }

        if(!clienteEdicao.getEmailPrincipal().isEmpty()) {
            inputEditEmailPrincipal.setText(clienteEdicao.getEmailPrincipal());
        }
        if(!clienteEdicao.getEmailSecundario().isEmpty()) {
            inputEditEmailSecundario.setText(clienteEdicao.getEmailSecundario());
        }

        if(!clienteEdicao.getEnderecoPrincipal().isEmpty()) {
            inputEditEnderecoPrincipal.setText(clienteEdicao.getEnderecoPrincipal());
        }

        if(!clienteEdicao.getNumeroEnderecoPrincipal().isEmpty()) {
            inputEditNumeroPrincipal.setText(clienteEdicao.getNumeroEnderecoPrincipal());
        }

        if(!clienteEdicao.getBairroEnderecoPrincipal().isEmpty()) {
            inputEditBairroPrincipal.setText(clienteEdicao.getBairroEnderecoPrincipal());
        }

        if(!clienteEdicao.getEnderecoEntrega().isEmpty()) {
            inputEditEnderecoEntrega.setText(clienteEdicao.getEnderecoEntrega());
        }

        if(!clienteEdicao.getNumeroEnderecoEntrega().isEmpty()) {
            inputEditNumeroEntrega.setText(clienteEdicao.getNumeroEnderecoEntrega());
        }

        if(!clienteEdicao.getBairroEnderecoEntrega().isEmpty()) {
            inputEditBairroEntrega.setText(clienteEdicao.getBairroEnderecoEntrega());
        }

        if(!clienteEdicao.getEnderecoCobranca().isEmpty()) {
            inputEditEnderecoCobranca.setText(clienteEdicao.getEnderecoCobranca());
        }

        if(!clienteEdicao.getNumeroEnderecoCobranca().isEmpty()) {
            inputEditNumeroCobranca.setText(clienteEdicao.getNumeroEnderecoCobranca());
        }

        if(!clienteEdicao.getBairroEnderecoCobranca().isEmpty()) {
            inputEditBairroEntrega.setText(clienteEdicao.getBairroEnderecoCobranca());
        }

        if(!clienteEdicao.getCliPessoa().isEmpty()) {
            TipoPessoa tipoPessoa = TipoPessoa.getTipoPessoa(clienteEdicao.getCliPessoa());
            spnTipoPessoaEdicao.setAdapter(new ArrayAdapter<>(getContext(), R.layout.spinner_adapter, TipoPessoa.values()));
            spnTipoPessoaEdicao.setSelection(tipoPessoa.ordinal());
        }

        spnTipoPessoaEdicao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                validarCamposTipoPessoa();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void validarCamposTipoPessoa() {
        TipoPessoa tipoPessoa = TipoPessoa.getTipoPessoa(clienteEdicao.getCliPessoa());
        inputEditNomeFantasia.setVisibility(tipoPessoa == TipoPessoa.FISICA ? View.GONE : View.VISIBLE);
    }

    private void setOnClickListeners() {
        btnCancelarEdicao.setOnClickListener(v -> dismiss());
        btnSalvarEdicao.setOnClickListener(v -> {
            salvarClienteEditado();
            dismiss();
        });
    }

    private void salvarClienteEditado() {
        new Thread(() -> {
            ClienteRepository clienteRepository = new ClienteRepository();
            clienteRepository.atualizarCliente(getClienteEdicao());
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(() -> {
                Toast.makeText(getContext(),"Cliente editado com sucesso!",Toast.LENGTH_SHORT).show();
            });
        }).start();
    }

    public ClienteVO getClienteEdicao() {
        clienteEdicao.setRazaoSocial(inputEditRazaoSocial.getText().toString());
        clienteEdicao.setCpfCnpj(inputEditCpfCnpj.getText().toString());
        clienteEdicao.setNomeFantasia(inputEditNomeFantasia.getText().toString());
        clienteEdicao.setEmailPrincipal(inputEditEmailPrincipal.getText().toString());
        clienteEdicao.setEmailSecundario(inputEditEmailSecundario.getText().toString());
        clienteEdicao.setEnderecoPrincipal(inputEditEnderecoPrincipal.getText().toString());
        clienteEdicao.setNumeroEnderecoPrincipal(inputEditNumeroPrincipal.getText().toString());
        clienteEdicao.setBairroEnderecoPrincipal(inputEditBairroPrincipal.getText().toString());
        clienteEdicao.setEnderecoEntrega(inputEditEnderecoEntrega.getText().toString());
        clienteEdicao.setNumeroEnderecoEntrega(inputEditNumeroEntrega.getText().toString());
        clienteEdicao.setBairroEnderecoEntrega(inputEditBairroEntrega.getText().toString());
        clienteEdicao.setEnderecoCobranca(inputEditEnderecoCobranca.getText().toString());
        clienteEdicao.setNumeroEnderecoCobranca(inputEditNumeroCobranca.getText().toString());
        clienteEdicao.setBairroEnderecoCobranca(inputEditBairroEntrega.getText().toString());
        clienteEdicao.setCliPessoa(spnTipoPessoaEdicao.getSelectedItem().toString());

        return clienteEdicao;
    }

}
