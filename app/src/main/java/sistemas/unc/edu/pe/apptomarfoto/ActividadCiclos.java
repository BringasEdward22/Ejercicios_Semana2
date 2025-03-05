package sistemas.unc.edu.pe.apptomarfoto;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ActividadCiclos extends AppCompatActivity {

    TextView lbEstado;
    List<String> lista= new ArrayList();
    ListView lvListaEstados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_actividad_ciclos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lbEstado=findViewById(R.id.lbEstado);
        lvListaEstados=findViewById(R.id.lvListaEstados);
        mensaje("Creacion");
    }

    private void mensaje(String estado) {
        lbEstado.setText(estado);
        Log.d("Estado",estado);
        lista.add(estado);
        //la variable lista se va a presentar en el listView
        lvListaEstados.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lista));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mensaje("Inicio");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mensaje("Ejecución");

    }

    @Override
    protected void onPause() {
        super.onPause();
        mensaje("Pausa");
        /*finish();
        if (isFinishing())
            mensaje("Finalizado"); */
    }

    @Override
    protected void onStop() {
        super.onStop();
        mensaje("Detenido");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isFinishing())
            mensaje("Finalizado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mensaje("Re-Inicio");
    }
}