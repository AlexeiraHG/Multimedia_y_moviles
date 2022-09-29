package org.iesch.a02_registro_de_superheroes;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import org.iesch.a02_registro_de_superheroes.databinding.ActivityDetailBinding;
import org.iesch.a02_registro_de_superheroes.model.Superhero;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1 Obtener en un objeto de tipo bundle todos los datos traidos de origen
        Bundle extras = getIntent().getExtras();

        // 2v1 Crear variables en los que guardar los valores del "extras"
//        String heroName = extras.getString("superhero_name");
//        String alterego = extras.getString("alterego");
//        String bio = extras.getString("bio");
//        Float rating = extras.getFloat("rating");

        //2v2 Recibir el objeto superhero de extras
        Superhero superhero = extras.getParcelable("superhero");

        // 3v1 Cargar variables en los campos de la datail activity
//        binding.nombreHeroeText.setText(heroName);
//        binding.TVAlterEgo.setText(alterego);
//        binding.TVBio.setText(bio);
//        binding.ratingBar.setRating(rating);

        // 3v2 Cargar variables en los campos del objeto superhero
        binding.nombreHeroeText.setText(superhero.getName());
        binding.TVAlterEgo.setText(superhero.getAlterego());
        binding.TVBio.setText(superhero.getBio());
        binding.ratingBar.setRating(superhero.getPower());

    }
}