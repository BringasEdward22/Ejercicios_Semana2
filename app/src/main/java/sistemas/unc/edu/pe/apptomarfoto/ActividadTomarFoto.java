package sistemas.unc.edu.pe.apptomarfoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActividadTomarFoto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void tomarDoto(View boton){
        //declarar un objeto intento de tipo genérico
        Intent oIntento = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Ejecutar INtento
        startActivityIfNeeded(oIntento,100);
    }
    // Escribir un metodo para capturar la imagen

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent oIntento) {
        super.onActivityResult(requestCode, resultCode, oIntento);
        if(requestCode==100){ //si el servicio esta funcionando
            if(resultCode==RESULT_OK){ //si usan el servicio
                Bitmap oImagen = (Bitmap) oIntento.getExtras().get("data");
                ImageView foto = findViewById(R.id.imgFoto);
                foto.setImageBitmap(oImagen);

            }
        }
    }
}