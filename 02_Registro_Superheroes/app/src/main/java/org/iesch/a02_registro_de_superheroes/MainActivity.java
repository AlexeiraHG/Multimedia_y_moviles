package org.iesch.a02_registro_de_superheroes;

import androidx.appcompat.app.AppCompatActivity;
import org.iesch.a02_registro_de_superheroes.databinding.ActivityMainBinding;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.saveButton.setOnClickListener(v ->{
            // 3 Captar informacion en las vista main
            String superHeroName = binding.nombreHeroEdit.getText().toString();
            String alterEgo = binding.alterEgoEdit.getText().toString();
            String bio = binding.bioEdit.getText().toString();
            Float rating = binding.powerBar.getRating();

            abrirDetailActivity(superHeroName, alterEgo, bio, rating);
        });
    }

    private void abrirDetailActivity(String superHeroName, String alterEgo,  String bio, Float rating) {

        // 1 Se crea objeto de tipo intent y se le dice donde se esta y a donde se quiee ir
        Intent irADetalle = new Intent(this, DetailActivity.class);

        // 3.5 Añadimos al Intent toda la info que queramos pasar, se le pasa una llave (string) y un value
        irADetalle.putExtra("superhero_name", superHeroName);
        irADetalle.putExtra("alterego", alterEgo);
        irADetalle.putExtra("bio", bio);
        irADetalle.putExtra("rating", rating);

        // 2 Se llama a StarActivity para ir a DetailActivity
        startActivity(irADetalle);


    }
}