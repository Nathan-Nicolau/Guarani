package com.nathannicolau.guarani.app.controller.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.nathannicolau.guarani.R;
import com.nathannicolau.guarani.app.controller.dialogs.DialogEditarCliente;
import com.nathannicolau.guarani.app.model.repository.ClienteRepository;
import com.nathannicolau.guarani.app.model.vo.ClienteVO;

import java.util.ArrayList;
import java.util.List;

public class AdapterCliente extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ClienteVO> listaClientes;
    private Context context;

    public AdapterCliente(Context context,List<ClienteVO> listaClientes) {
        this.context = context;
        this.listaClientes = listaClientes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cliente, parent, false);
        return new ViewHolderCliente(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ClienteVO clienteVO = listaClientes.get(position);
        ViewHolderCliente viewHolderCliente = (ViewHolderCliente) holder;
        viewHolderCliente.tvRazaoSocial.setText(clienteVO.getRazaoSocial());
        if(clienteVO.ehPessoaJuridica()) {
            viewHolderCliente.tvNomeFantasia.setVisibility(View.VISIBLE);
            viewHolderCliente.tvNomeFantasia.setText(clienteVO.getNomeFantasia());
            viewHolderCliente.labelCpfCnpj.setText("CNPJ");
        } else {
            viewHolderCliente.labelCpfCnpj.setText("CPF");
            viewHolderCliente.tvNomeFantasia.setVisibility(View.GONE);
        }
        viewHolderCliente.tvCpfCnpj.setText(clienteVO.getCpfCnpj());
        viewHolderCliente.tvEmailPrincipal.setText(clienteVO.getEmailPrincipal());
        viewHolderCliente.tvEmailSecundario.setText(clienteVO.getEmailSecundario());

        viewHolderCliente.btnEditarCliente.setOnClickListener(v -> {
            DialogEditarCliente dialogEditarCliente = new DialogEditarCliente(context, clienteVO);
            dialogEditarCliente.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    Handler handler = new Handler(context.getMainLooper());
                    handler.postDelayed(() -> {
                        notifyDataSetChanged();
                    },100);
                }
            });
            dialogEditarCliente.show();
        });

        viewHolderCliente.btnExcluirCliente.setOnClickListener(v -> {
            new Thread(() -> {
                ClienteRepository clienteRepository = new ClienteRepository();
                clienteRepository.excluirCliente(clienteVO);
                listaClientes.remove(clienteVO);
                Handler handler = new Handler(context.getMainLooper());
                handler.postDelayed(() -> {
                    viewHolderCliente.cardCliente.setVisibility(View.GONE);
                },100);
            }).start();
        });

    }

    @Override
    public int getItemCount() {
        return listaClientes.size();
    }

    public class ViewHolderCliente extends RecyclerView.ViewHolder {
        MaterialCardView cardCliente;
        TextView tvRazaoSocial, tvNomeFantasia, tvCpfCnpj, tvEmailPrincipal, tvEmailSecundario;
        TextView labelNomeFantasia, labelCpfCnpj;
        MaterialButton btnEditarCliente, btnExcluirCliente;

        public ViewHolderCliente(@NonNull View itemView) {
            super(itemView);
            cardCliente = itemView.findViewById(R.id.card_cliente);
            tvRazaoSocial = itemView.findViewById(R.id.tv_razao_social);
            tvNomeFantasia = itemView.findViewById(R.id.tv_nome_fantasia);
            tvCpfCnpj = itemView.findViewById(R.id.tv_cpf_cnpj);
            tvEmailPrincipal = itemView.findViewById(R.id.tv_email_principal);
            tvEmailSecundario = itemView.findViewById(R.id.tv_email_secundario);
            labelNomeFantasia = itemView.findViewById(R.id.label_nome_fantasia);
            labelCpfCnpj = itemView.findViewById(R.id.label_cpf_cnpj);
            btnEditarCliente = itemView.findViewById(R.id.btn_editar_cliente);
            btnExcluirCliente = itemView.findViewById(R.id.btn_excluir_cliente);
        }
    }

}
