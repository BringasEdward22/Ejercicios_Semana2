package sistemas.unc.edu.pe.apptomarfoto;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActividadContador extends AppCompatActivity {

    EditText etContador;
    Button btnIncrementar;
    int contador = 0;
    Handler handler = new Handler();
    Runnable restarRunnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_contador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        etContador = findViewById(R.id.etContador);
        btnIncrementar = findViewById(R.id.btnIncrementar);


        btnIncrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                etContador.setText(String.valueOf(contador));
            }
        });


        restarRunnable = new Runnable() {
            @Override
            public void run() {
                if (contador > 0) {
                    contador--;
                    etContador.setText(String.valueOf(contador));
                }
            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.postDelayed(restarRunnable, 1000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.removeCallbacks(restarRunnable);
    }
}

