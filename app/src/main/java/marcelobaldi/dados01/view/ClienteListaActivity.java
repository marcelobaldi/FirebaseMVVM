package marcelobaldi.dados01.view;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import marcelobaldi.dados01.R;
import marcelobaldi.dados01.adapter.ClienteAdapter;
import marcelobaldi.dados01.model.ClienteModel;
import marcelobaldi.dados01.support.Helper;

public class ClienteListaActivity extends AppCompatActivity {
    private RecyclerView            listaRecyclerView;
    private LinearLayoutManager     listaLayout         = new LinearLayoutManager(this);
    private ArrayList<ClienteModel> listaClientes       = new ArrayList<>();

    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_lista);
        carregarLista();
    }

    public void cliente_lista_btn_novo(View view){
        finish();
        startActivity(new Intent(getBaseContext(), ClienteActivity.class));
    }

    private void carregarLista(){
        listaClientes.clear();

        Helper.tabelaClientes().addValueEventListener(new ValueEventListener() {
            @Override public void onDataChange(@NonNull DataSnapshot snapshot) {
                String idS = ""; String nomeS = ""; String emailS = "";

                for (DataSnapshot item : snapshot.getChildren()) {
                    if (item.child("id").exists())    { idS    = item.child("id").getValue().toString();     }
                    if (item.child("nome").exists())  { nomeS   = item.child("nome").getValue().toString();  }
                    if (item.child("email").exists()) { emailS  = item.child("email").getValue().toString(); }

                    ClienteModel cliente = new ClienteModel(idS, nomeS, emailS);
                    listaClientes.add(cliente);

                    Log.d("meuLog", cliente.getListaClientes().toString());

                    if(!listaClientes.isEmpty()) {
                        listaRecyclerView = (RecyclerView) findViewById(R.id.listaClientesXml);
                        listaRecyclerView.setLayoutManager(listaLayout);

                        ClienteAdapter clienteAdapter = new ClienteAdapter(ClienteListaActivity.this, listaClientes);
                        listaRecyclerView.setAdapter(clienteAdapter);
                    }
                }
            }
            @Override public void onCancelled(@NonNull DatabaseError error) { }
        });
    }
}




//Realtime Database - Criar no Firebase
//- Projeto:    Teste
//- Módulo:     Realtime Database
//- Criar:      Criar Banco Dados
//- Servidor:   Brasil, América Sul, Estados Unidos, Etc
//- Segurança:  Modo Teste (Em 1 Mes Mudar Para Modo Bloqueado)

//Realtime Database - Adicionar ao Projeto
//- Android Studio / Tools / Firebase / Realtime Database / Get Started With Realtime Database
//- Connect to Firebase / Escolher o Projeto    (Depois Aparecerá:  "Connected"
//- Add the Realtime Database to your App       (Depois Aparecerá:  "Dependencies Set Up Correctly)
//- Build Gradle Project Dependencies: classpath 'com.google.gms:google-services:4.3.10'
//- Build Gradle Module  Plugin:       id 'com.google.gms.google-services'
//- Build Gradle Module  Dependencies: implementation 'com.google.firebase:firebase-core:20.0.2'
//- Build Gradle Module  Dependencies: implementation 'com.google.firebase:firebase-database:20.0.3'
//- Build Gradle Module  Dependencies: implementation 'com.google.firebase:firebase-storage:20.0.0'
//- Build Gradle Module  Dependencies: implementation 'com.google.firebase:firebase-auth:21.0.1'
//* Atualizar as Libs e Sincronizar
//* Regras de Segurança no BD Deve Estar Configurada (Permitida Para Testes). Depois Bloquear        ***

//Regras Segurança
//Para Todos (Modo Teste)
//- Read:   true,
//- Write:  true

//Só Para Usuários Autenticados (Padrão)
//- Read:   "auth != null",
//- Write:  "auth != null"


//Realtime Database - Conectar
//Get Reference = Volta para o nó Raiz;
//child = nome pasta
//Push  =   Cria um pasta (id único);
//salvar e atualizar é a mesma coisa !
//getkety = pega sua pasta
















