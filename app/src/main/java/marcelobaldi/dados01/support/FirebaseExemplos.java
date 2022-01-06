package marcelobaldi.dados01.support;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import marcelobaldi.dados01.R;
import marcelobaldi.dados01.model.ClienteModel;

public class FirebaseExemplos extends AppCompatActivity {
    private RecyclerView        listaRecyclerView;
    private LinearLayoutManager listaLayout         = new LinearLayoutManager(this);



    ClienteModel cliente = new ClienteModel();
    String nomePego;
    String nomePego2;

    //Conectar 1
    //FirebaseDatabase bdfirebase    = FirebaseDatabase.getInstance();
    //DatabaseReference tabClientes  = bdfirebase.getReference().child("Clientes");

    //Conectar 2
    DatabaseReference tabClientes = FirebaseDatabase.getInstance().getReference().child("Clientes");


    //Método Inicial
  // @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);setContentView(R.layout.activity_main);
        //Salvar - Manual
//        DatabaseReference novoReg = tabClientes.push();
//            novoReg.child("id").setValue(novoReg.getKey());         //O Próprio Nó
//            novoReg.child("nome").setValue("Dog Belinha");
//            novoReg.child("idade").setValue(16);

        //Salvar - Classe Model
//        DatabaseReference novoReg = tabClientes.push();
//            String id = novoReg.getKey();
//            ClienteModel cliente = new ClienteModel(id,"Kleber", 38);
//            novoReg.setValue(cliente);


        // salvar campo chave (email) to lower case, para depois poder recuperar . não sei/erro to ignore case  ***

        ////////////////////////////////////////////////////////////////////////////////////////////

        //Buscar - Lista (Value Event)
//        tabClientes.addValueEventListener(new ValueEventListener() {
//        @Override public void onDataChange(@NonNull DataSnapshot snapshot) {
//            Log.d("meuLog", snapshot.getValue().toString());    //Pegar Sua Referência
//        } @Override public void onCancelled(@NonNull DatabaseError error) { }});

        //Buscar - Específico (Value Event)
//        tabClientes.child("-Msepn-eZQsFl_rkXpDo").addValueEventListener(new ValueEventListener() {
//        @Override public void onDataChange(@NonNull DataSnapshot snapshot) {
//            //Log.d("meuLog", snapshot.getValue().toString());
//            cliente = snapshot.getValue(ClienteModel.class);                //Pegar Sua Referencia
//            nomePego = snapshot.child("nome").getValue().toString();        //Pegar Campo
//            nomePego2 = cliente.getNome();
//            //buscar(cliente);
//            Log.d("meuLog", String.valueOf(nomePego2));
//        }@Override public void onCancelled(@NonNull DatabaseError error) { }});


        ////////////////////////////////////////////////////////////////////////////////////////////

        //Buscar - Filtros (Query) - e Primeiro Ordenar Para Depois Filtrar             //  case sensitive ???

        //Igual
//        String nomeX = "kleBer";
//        String nomeXY = nomeX.toLowerCase();
//        Query usuarioMarcelo = tabClientes.orderByChild("nome").equalTo(nomeXY);
//
//        usuarioMarcelo.addValueEventListener(new ValueEventListener() {
//            @Override public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                String id = ""; String nome = ""; String idade = ""; Integer idI = 0;
//                for(DataSnapshot item : snapshot.getChildren()){
//                    if(item.child("idade").exists()){
//                        id    = String.valueOf(item.child("idade").getValue());
//                        idI = Integer.parseInt(id);
//                    }else
//                        id = "não existe";
//
//                  //  id    = String.valueOf(item.child("id").getValue());
////                    nome  = String.valueOf(item.child("nome").getValue());
////                    idade = String.valueOf(item.child("idade").getValue());
////                    break;
//                }
//                Log.d("meuLog", String.valueOf(idI) + " " + nome + " " + idade);
//                //cliente.setNome(nome);
//                //buscar(cliente);
//            }
//            @Override public void onCancelled(@NonNull DatabaseError error) { }
//        });

        //Log.d("meuLog", cliente.getNome());       //não funciona

        //Limitar Busca pelos Primeiros
//        Query usuarioMarcelo = tabClientes.orderByKey().limitToFirst(2);
//        usuarioMarcelo.addValueEventListener(new ValueEventListener() {
//            @Override public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d("meuLog", snapshot.getValue().toString());
//            }
//            @Override public void onCancelled(@NonNull DatabaseError error) { }
//        });


        //Limitar Busca Pelos Últimos
//        Query usuarioMarcelo = tabClientes.orderByKey().limitToLast(2);       //retorna 2
//        usuarioMarcelo.addValueEventListener(new ValueEventListener() {
//            @Override public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d("meuLog", snapshot.getValue().toString());
//            }
//            @Override public void onCancelled(@NonNull DatabaseError error) { }
//        });

        //A partir de (maior ou igual a) - números
//        Query usuarioMarcelo = tabClientes.orderByChild("idade").startAt(38);
//        usuarioMarcelo.addValueEventListener(new ValueEventListener() {
//            @Override public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d("meuLog", snapshot.getValue().toString());
//            }
//            @Override public void onCancelled(@NonNull DatabaseError error) { }
//        });

        //menor ou igual a - números
//        Query usuarioMarcelo = tabClientes.orderByChild("idade").endAt(18);
//        usuarioMarcelo.addValueEventListener(new ValueEventListener() {
//            @Override public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d("meuLog", snapshot.getValue().toString());
//            }
//            @Override public void onCancelled(@NonNull DatabaseError error) { }
//        });

        //Entre dois valores - números
//        Query usuarioMarcelo = tabClientes.orderByChild("idade").startAt(38).endAt(42);
//        usuarioMarcelo.addValueEventListener(new ValueEventListener() {
//            @Override public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d("meuLog", snapshot.getValue().toString());
//            }
//            @Override public void onCancelled(@NonNull DatabaseError error) { }
//        });


        //String - Começar com "Mar"  =  não funciona direito !!!!
//        Query usuarioMarcelo = tabClientes.orderByChild("nome").startAt("Mar").endAt("Mar" + "\uf8ff");
//        usuarioMarcelo.addValueEventListener(new ValueEventListener() {
//            @Override public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d("meuLog", snapshot.getValue().toString());
//            }
//            @Override public void onCancelled(@NonNull DatabaseError error) { }
//        });

        //String - Entre 2 valores
//        Query usuarioMarcelo = tabClientes.orderByChild("nome").startAt("M").endAt("P");
//        usuarioMarcelo.addValueEventListener(new ValueEventListener() {
//            @Override public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d("meuLog", snapshot.getValue().toString());
//            }
//            @Override public void onCancelled(@NonNull DatabaseError error) { }
//        });




        //Deletar
        //Buscar - Específico (Value Event)
        //tabClientes.child("-MseygKBBZ-ife60Yy23").removeValue();

      //  ClienteModel clienteModel = new ClienteModel();
    //    clienteModel.buscarPorNome("marcelo");
     //   clienteModel.buscarTodos();

      //  ClienteModel cliente = new ClienteModel("Keity", "MarCeloBaldi@ig.cOm", 40);
        //cliente.salvar(cliente);

       // ClienteController clienteController = new ClienteController();
      //  clienteController.buscarPorEmailController("marCeloBaldi@ig.com");

     //   ClienteModel cliente2 = new ClienteModel();
     //   cliente2.buscarPorEmailModel("marcelobaldi@ig.com2");

     //   ClienteController clienteController = new ClienteController();
      //  clienteController.buscarPorEmailController(cliente);


  //  }


    static public void buscar(ClienteModel cliente){
        if(cliente.getId() != null) {
      //      Log.d("meuLog", cliente.getId() + " " + cliente.getNome() + " " + cliente.getIdade().toString());
        }else{
            Log.d("meuLog", "Cliente Não Encontrado");
        }
    }
    static public void buscarTodos(ArrayList<ClienteModel> listaClientes) {
        Log.d("meuLog", listaClientes.get(0).getNome());
    }
    static public void clienteSalvo(ClienteModel cliente){
        Log.d("meuLog", cliente.getNome() + " " + "Salvo");
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
















