package marcelobaldi.dados01.support;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Helper {

    public static DatabaseReference tabelaClientes(){
        FirebaseDatabase bdfirebase    = FirebaseDatabase.getInstance();
        DatabaseReference tabClientes  = bdfirebase.getReference().child("Clientes");
        return  tabClientes;
    }

}
