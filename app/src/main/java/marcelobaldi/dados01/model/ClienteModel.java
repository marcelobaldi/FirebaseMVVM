package marcelobaldi.dados01.model;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;

import marcelobaldi.dados01.view.ClienteListaActivity;
import marcelobaldi.dados01.support.Helper;

public class ClienteModel implements Serializable {
    //Atributos
    private String  id;
    private String  nome;
    private String  email;
    private ArrayList<ClienteModel> listaClientes;

    //Construtor (Vazio, Sem ID, Com ID)
    public ClienteModel() {
        listaClientes = new ArrayList<ClienteModel>();
    }
    public ClienteModel(String nome, String email) {
        this.nome = nome;
        this.email = email;
        listaClientes = new ArrayList<ClienteModel>();
    }
    public ClienteModel(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        listaClientes = new ArrayList<ClienteModel>();
    }

    //GetterSetter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public ArrayList<ClienteModel> getListaClientes() { return listaClientes; }
    public void setListaClientes(ArrayList<ClienteModel> listaClientes) { this.listaClientes = listaClientes; }

//    //Database CRUD
//    public void salvarModel(ClienteModel clienteV){
//        //Salvar
//        DatabaseReference novoReg = Helper.tabelaClientes().push();
//            //Pegar Nó Criado
//            String id     = novoReg.getKey();
//
//            //Pegar Dados Vindo
//            String nome   = clienteV.getNome();
//            String email  = clienteV.getEmail();
//
//            //Converer Campo Chave Para Minúsculo
//            String emailConvert = email.toLowerCase();
//
//            //Instanciar Objeto
//            ClienteModel cliente = new ClienteModel(id, nome, emailConvert);
//
//            //Gravar Dados
//            novoReg.setValue(cliente);
//
//        //Retornar ID Salvao "Gambiarra"
//        //ClienteListaActivity.clienteSalvo(cliente);
//    }
//    public void buscarTodos (){
//        Helper.tabelaClientes().addValueEventListener(new ValueEventListener() {
//            @Override public void onDataChange(@NonNull DataSnapshot snapshotX) {
//                //Variáveis
//                String idS = ""; String nomeS = ""; String idadeS = "";     //String Pegar Dados
//                ClienteModel cliente = new ClienteModel();                  //Objeto Colocar Dados
//
//                //Pegar Dados e Setar Objeto
//                for(DataSnapshot item : snapshotX.getChildren()){
//                    if(item.child("id").exists()) {
//                        idS    = String.valueOf(item.child("id").getValue());
//                        cliente.setId(idS);
//                    }
//                    if(item.child("nome").exists()) {
//                        nomeS  = String.valueOf(item.child("nome").getValue());
//                        cliente.setNome(nomeS);
//                    }
//                    if(item.child("idade").exists()) {
//                        idadeS = String.valueOf(item.child("idade").getValue());
//                        cliente.setIdade(Integer.parseInt(idadeS));         // ***
//                    }
//                    listaClientes.add(cliente);
//                }
//
//                //Devolver (CHAMAR MÉTODO)
//                ClienteListaActivity.buscarTodos(listaClientes);
//            }
//            @Override public void onCancelled(@NonNull DatabaseError error) { }
//        });
//    }
//    public static void buscarPorEmailModel(String email){                  //Se mais de um resultado, então lista, senão pau!!!
//        //Converter Para Minúsculo (Conforme Gravado no BD)
//        String emailMinusculo = email.toLowerCase();
//
//        Query buscaEmail = Helper.tabelaClientes().orderByChild("email").equalTo(emailMinusculo);
//        buscaEmail.addValueEventListener(new ValueEventListener() {
//            @Override public void onDataChange(@NonNull DataSnapshot snapshotX) {
//                //Variáveis
//                String idS = ""; String nomeS = ""; String emailS = ""; String idadeS = "";         //String Pegar Dados
//                ClienteModel cliente = new ClienteModel();                                          //Classe Colocar Dados
//
//                //Pegar Dados e Setar Objeto
//                for(DataSnapshot item : snapshotX.getChildren()){
//                    if(item.child("id").exists()) {
//                        idS    = String.valueOf(item.child("id").getValue());
//                        cliente.setId(idS);
//                    }
//                    if(item.child("nome").exists()) {
//                        nomeS  = String.valueOf(item.child("nome").getValue());
//                        cliente.setNome(nomeS);
//                    }
//                    if(item.child("email").exists()) {
//                        emailS  = String.valueOf(item.child("email").getValue());
//                        cliente.setEmail(emailS);
//                    }
//                    if(item.child("idade").exists()) {
//                        idadeS = String.valueOf(item.child("idade").getValue());
//                        cliente.setIdade(Integer.parseInt(idadeS));                     // ***
//                    }
//                }
//
//
//
//                //Log.d("meuLog", cliente.toString());
//
//                //Devolver (CHAMAR MÉTODO)
//                ClienteController clienteController = new ClienteController();
//                clienteController.clienteRetornado(cliente);
//              //  Log.d("meuLog", cliente.getNome());
//            }
//            @Override public void onCancelled(@NonNull DatabaseError error) { }
//        });
//
//    }
//    public void deletar(String idV){
//        Helper.tabelaClientes().child(idV).removeValue();
//    }
}


