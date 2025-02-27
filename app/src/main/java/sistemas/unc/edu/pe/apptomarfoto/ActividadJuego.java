package sistemas.unc.edu.pe.apptomarfoto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

import Models.Jugada;
import Models.Papel;
import Models.Piedra;
import Models.Tijera;

public class ActividadJuego extends AppCompatActivity {

    RadioGroup grupoOpciones;
    Button btnJugar;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_juego);

        grupoOpciones=findViewById(R.id.grupoOpciones);
        btnJugar=findViewById(R.id.btnJugar);
        tvResultado=findViewById(R.id.tvResultado);


        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugar();
            }
        });
    }

    private void jugar() {
        int seleccionUsuario = grupoOpciones.getCheckedRadioButtonId();
        Jugada jugadaUsuario = obtenerJugadaUsuario(seleccionUsuario);

        if (jugadaUsuario == null) {
            tvResultado.setText("Selecciona una opción");
            return;
        }

        Jugada jugadaDispositivo = obtenerJugadaDispositivo();

        String resultado = jugadaUsuario.comparar(jugadaDispositivo);
        tvResultado.setText("Tú: " + jugadaUsuario.getNombre() + " | Móvil: " + jugadaDispositivo.getNombre() + "\n" + resultado);
    }

    private Jugada obtenerJugadaUsuario(int seleccion) {
        if (seleccion == R.id.rbPiedra) return new Piedra();
        else if (seleccion == R.id.rbPapel) return new Papel();
        else if (seleccion == R.id.rbTijera) return new Tijera();
        return null;
    }

    private Jugada obtenerJugadaDispositivo() {
        Jugada[] jugadas = { new Piedra(), new Papel(), new Tijera() };
        Random random = new Random();
        return jugadas[random.nextInt(jugadas.length)];
    }
}