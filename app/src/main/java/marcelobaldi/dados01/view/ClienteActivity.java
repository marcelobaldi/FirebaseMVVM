package marcelobaldi.dados01.view;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import marcelobaldi.dados01.R;
import marcelobaldi.dados01.model.ClienteModel;
import marcelobaldi.dados01.support.Helper;

public class ClienteActivity extends AppCompatActivity {
    private EditText        id, nome, email;
    private ClienteModel    clientemodel = new ClienteModel();

    @Override protected void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        id     =  (EditText)  findViewById(R.id.cliente_edt_id);
        nome   =  (EditText)  findViewById(R.id.cliente_edt_nome);
        email  =  (EditText)  findViewById(R.id.cliente_edt_email);

        Intent intentVindo = getIntent();
        if(intentVindo.getExtras() != null) {
            clientemodel = (ClienteModel) intentVindo.getExtras().getSerializable("chaveCliente");
            id.setText(String.valueOf(clientemodel.getId()));
            nome.setText(clientemodel.getNome());
            email.setText(clientemodel.getEmail());
        }
    }

    @Override public void onBackPressed () {
        super.onBackPressed();
        startActivity(new Intent(getBaseContext(), ClienteListaActivity.class));
    }

    public void cliente_btn_salvar(View view){
        String nomeS  = nome.getText().toString();
        String emailS = email.getText().toString();

        DatabaseReference novoReg = Helper.tabelaClientes().push();
        novoReg.child("id").setValue(novoReg.getKey());
        novoReg.child("nome").setValue(nomeS);
        novoReg.child("email").setValue(emailS);
        Toast.makeText(getBaseContext(), "Salvo", Toast.LENGTH_LONG).show();
        finish();
        startActivity(new Intent(getBaseContext(), ClienteListaActivity.class));
    }
    
}