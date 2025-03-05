package sistemas.unc.edu.pe.apptomarfoto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActividadValidacion extends AppCompatActivity {

    EditText etNombre;
    RadioGroup rgGenero;
    RadioButton rbMasculino, rbFemenino;
    CheckBox cbAceptar;
    Button btnValidar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_validacion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNombre = findViewById(R.id.etNombre);
        rgGenero = findViewById(R.id.rgGenero);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        cbAceptar = findViewById(R.id.cbAceptar);
        btnValidar = findViewById(R.id.btnValidar);


        rbFemenino.setChecked(true);


        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDatos();
            }
        });
    }

    private void validarDatos() {
        String nombre = etNombre.getText().toString().trim();


        if (nombre.isEmpty()) {
            etNombre.setError("Ingrese su nombre");
            etNombre.requestFocus();
            return;
        }


        int idSeleccionado = rgGenero.getCheckedRadioButtonId();
        String genero = "";
        if (idSeleccionado == R.id.rbMasculino) {
            genero = "Masculino";
        } else if (idSeleccionado == R.id.rbFemenino) {
            genero = "Femenino";
        }


        if (!cbAceptar.isChecked()) {
            Toast.makeText(this, "Debe aceptar los términos y condiciones", Toast.LENGTH_SHORT).show();
            return;
        }

        // Si todo está correcto, mostrar un mensaje con los datos ingresados
        String mensaje = "Nombre: " + nombre + "\nGénero: " + genero + "\nAceptó términos: Sí";
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        etNombre.setText("");
        rbMasculino.setChecked(true);
        cbAceptar.setChecked(false);
    }
}
