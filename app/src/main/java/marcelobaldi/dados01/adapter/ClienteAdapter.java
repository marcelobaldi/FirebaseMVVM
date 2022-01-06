package marcelobaldi.dados01.adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import marcelobaldi.dados01.R;
import marcelobaldi.dados01.model.ClienteModel;
import marcelobaldi.dados01.view.ClienteActivity;


public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteHolder> {
    //Atributos
    private Context                     contexto;
    private ArrayList<ClienteModel>     listaClientes;

    //Construtor
    public ClienteAdapter(Context contexto, ArrayList<ClienteModel> listaClientes) {
        this.contexto = contexto;
        this.listaClientes = listaClientes;
    }

    //Lista - Configurações
    @NonNull @Override public ClienteHolder onCreateViewHolder(@NonNull ViewGroup vX, int vY){
        View view = LayoutInflater.from(vX.getContext()).inflate(R.layout.adapter_cliente_linha, vX, false);
        ClienteHolder clienteHolder = new ClienteHolder(view);
        return clienteHolder;
    }

    //Lista - Tamanho
    @Override public int getItemCount() {
        return listaClientes.size();
    }

    //Linha - Ações
    @Override public void onBindViewHolder(@NonNull ClienteHolder cH, @SuppressLint("RecyclerView") final int iZ) {
        //Lista - Lista e Objetos Linha
        ClienteModel clienteModel = listaClientes.get(iZ);
        cH.nome.setText(clienteModel.getNome());
        cH.email.setText(clienteModel.getEmail());

        //Linha - Ação Nos Objetos
        cH.nome.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
            Toast.makeText(contexto, String.valueOf(listaClientes.get(iZ).getNome()),Toast.LENGTH_LONG).show();
        }});

        //Linha - Ação Na Linha (itemView)
        cH.itemView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
            Intent intentX  = new Intent(contexto, ClienteActivity.class);
            intentX.putExtra("chaveCliente", listaClientes.get(iZ));
            contexto.startActivity(intentX);
        }});
    }

    //Linha - Objetos
    public static class ClienteHolder extends RecyclerView.ViewHolder{
        //Atributos
        public TextView  nome, email;

        //Construtor
        public ClienteHolder(@NonNull View itemView) {
            super(itemView);
            nome  = (TextView) itemView.findViewById(R.id.cliente_linha_txt_nome);
            email = (TextView) itemView.findViewById(R.id.cliente_linha_txt_email);
        }
    }
}



//Classe Adapter
//- Conceito:       Configuração da Respectiva Lista Recyclerview;
//- Observação:     Receber a Lista do Objeto e o Contexto (poderes activity - Toast, Intent)

////////////////////////////////////////////////////////////////////////////////////////////////////

//Criar Classe Adapter
//- Criar Classe Java Normal
//- Fazer Herança da Classe Interna RecyclerView.Adapter, Contendo Sua Sub Classe Holder
//- Implementar os 3 Métodos Sugeridos Pela IDE (OnCreateViewHolder, OnBindViewHolder, GetItemCount)
//* A Sua Sub Classe Holder Ainda Não Existe, Mas Necessita Ser Criada (Conforme o Nome Dado);

////////////////////////////////////////////////////////////////////////////////////////////////////

//Criar Classe Secundária Holder
//- Criar Sub Classe Holder, Com o Mesmo Nome Informado na Herança da Sua Classe;
//- Identificar Objetos da Linha da Lista (Declarar como atributos desta sub classe);
//- Criar Construtor Vazio Desta Sub Classe, e Correlacionar (Atributos Declarados x Objetos XML)
//* Esta Sub Classe Poderia Estar Em Arquivo Separado Também (eu não prefiro)

////////////////////////////////////////////////////////////////////////////////////////////////////

//Atributos e Construtor
//- Atributos:      Lista do Objeto (Dados) e Contexto (Variável Com Poder Activity - Toast, Intent)
//- Construtor:     Com Tais Atributos, Para Quando Esta Classe For Instanciada, Já os Passar;
//* Observação:     Alguns Comandos da Activity (startActivity), Agora São Via Contexto Recebido;

////////////////////////////////////////////////////////////////////////////////////////////////////

//- OnCreateViewHolder:     Arquivo XML (Linha da Lista) e Sua Sub Classe Holder
//- OnBindViewHolder:       Configuração da Linha da Lista
//- GetItemCount:           Tamanho da Lista


