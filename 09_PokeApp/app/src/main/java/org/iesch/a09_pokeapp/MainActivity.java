package org.iesch.a09_pokeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.iesch.a09_pokeapp.Model.Pokemon;
import org.iesch.a09_pokeapp.Model.iComunicaFragments;
import org.iesch.a09_pokeapp.fragments.DetailFragment;

public class MainActivity extends AppCompatActivity implements iComunicaFragments, View.OnClickListener {

    DetailFragment detalleFragmentPokemon;
    private TextView imageTextView;
    private TextView stastTextView;
    private Pokemon selectedPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista Pokemon");

        imageTextView.setDrawingCacheBackgroundColor(ContextCompat.getColor
                (this, com.google.android.material.R.color.design_dark_default_color_on_primary));
        stastTextView.setDrawingCacheBackgroundColor(ContextCompat.getColor
                (this, com.google.android.material.R.color.design_dark_default_color_on_secondary));

        //declaramos los botones
        imageTextView = findViewById(R.id.activity_main_image_opcion_tv);
        stastTextView = findViewById(R.id.activity_main_opcion_estadisticas_tv);

        imageTextView.setOnClickListener(this);
        stastTextView.setOnClickListener(this);

    }

    @Override
    public void enviarPokemon(Pokemon pokemon) {
        //Toast.makeText(this, pokemon.getName(), Toast.LENGTH_SHORT).show();
        selectedPokemon = pokemon;
        //Aqui haremos toda la logica necesaria para comunicar los fragments
//        detalleFragmentPokemon = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.pokemon_detail_fragment);
//        detalleFragmentPokemon.setPokemonImage(pokemon.getImageurl());
//        detalleFragmentPokemon.playPokemonSound(pokemon.getSoundId());
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId){
            case R.id.activity_main_image_opcion_tv:
                imageTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_primary));
                stastTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_secondary));
                break;
            case R.id.activity_main_opcion_estadisticas_tv:
                stastTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_primary));
                imageTextView.setBackgroundColor(ContextCompat.getColor(this, com.google.android.material.R.color.design_dark_default_color_secondary));
                break;
        }
    }
}