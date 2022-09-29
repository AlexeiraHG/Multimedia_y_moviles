package org.iesch.a02_registro_de_superheroes;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import org.iesch.a02_registro_de_superheroes.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1 Obtener en un objeto de tipo bundle todos los datos traidos de origen
        Bundle extras = getIntent().getExtras();

        // 2 Crear variables en los que guardar los valores del "extras"
        String heroName = extras.getString("superhero_name");
        String alterego = extras.getString("alterego");
        String bio = extras.getString("bio");
        Float rating = extras.getFloat("rating");

        //Cargar variables en los campos de la datail activity
        binding.nombreHeroeText.setText(heroName);
        binding.TVAlterEgo.setText(alterego);
        binding.TVBio.setText(bio);
        binding.ratingBar.setRating(rating);

    }
}