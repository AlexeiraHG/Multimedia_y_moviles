package org.iesch.a02_registro_de_superheroes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import org.iesch.a02_registro_de_superheroes.databinding.ActivityMainBinding;
import org.iesch.a02_registro_de_superheroes.model.Superhero;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Bitmap foto;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //BOTON GUARDAR
        binding.saveButton.setOnClickListener(v ->{
            // 3 Captar informacion en las vista main
            String superHeroName = binding.nombreHeroEdit.getText().toString();
            String alterEgo = binding.alterEgoEdit.getText().toString();
            String bio = binding.bioEdit.getText().toString();
            Float rating = binding.powerBar.getRating();

            abrirDetailActivity(superHeroName, alterEgo, bio, rating);
        });

        //Funcion al pulsar en ekl icono de la cámara
        binding.heroImage.setOnClickListener(v -> {
            abrirCamara();
        });
    }

    //Creo la funcion onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 9 - Si hacemos click en el "back" de la camara recibiremos un result_CANCEL, y si hacemos la foto un RESULT_OK
        if ( resultCode == Activity.RESULT_OK && requestCode == 1000 )
        {
            if ( data != null){
                foto = data.getExtras().getParcelable("data");
                // Se lo asignamos a la ImageView que tenemos
                // 10 - Asigno el Bitmap a la foto
                binding.heroImage.setImageBitmap(foto);
            } else {
                Toast.makeText(this, "Error haciendo la foto", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void abrirCamara() {
        Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camaraIntent, 1000);
    }

    private void abrirDetailActivity(String superHeroName, String alterEgo,  String bio, Float rating) {

        // 1 Se crea objeto de tipo intent y se le dice donde se esta y a donde se quiee ir
        Intent irADetalle = new Intent(this, DetailActivity.class);

        // 3.5v1 Añadimos al Intent toda la info que queramos pasar, se le pasa una llave (string) y un value
//        irADetalle.putExtra("superhero_name", superHeroName);
//        irADetalle.putExtra("alterego", alterEgo);
//        irADetalle.putExtra("bio", bio);
//        irADetalle.putExtra("rating", rating);

        // 3.5v2 Nos creamos un objeto de tipo Superhero
        Superhero superhero = new Superhero(superHeroName, alterEgo, bio, rating);
        irADetalle.putExtra("superhero", superhero);
        irADetalle.putExtra("foto", foto);

        // 2 Se llama a StarActivity para ir a DetailActivity
        startActivity(irADetalle);


    }
}