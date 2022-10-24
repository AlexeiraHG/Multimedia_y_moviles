package org.iesch.a09_pokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.iesch.a09_pokeapp.Model.Pokemon;
import org.iesch.a09_pokeapp.Model.PokemonListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //9
    private ListView lvPokemon;
    private PokemonListAdapter Adaptador;
    private ArrayList<Pokemon> pokemonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //10 - Lo enlazo

        lvPokemon = findViewById(R.id.listaPokemon);

        // 11 -

        pokemonList.add(new Pokemon("1", "Bulbasaur", Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("2", "Ivysaur", Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("3", "Venuasaur", Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("4", "Charmander", Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("5", "Chameleon", Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("6", "Charizard", Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("7", "Squirtle", Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("8", "Blastoise", Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("25", "Pikachu", Pokemon.Type.ELECTRIC));
        pokemonList.add(new Pokemon("26", "Raichu", Pokemon.Type.ELECTRIC));

        // 12 -

        Adaptador = new PokemonListAdapter(this, pokemonList, R.id.listaPokemon);

        // 13 - Asignamos el adpatador al list view
        lvPokemon.setAdapter(Adaptador);

        //14 - Me creo un metodo para tener control sobre el elemento que selecciono
        lvPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pokemon selectedPokemnon = (Pokemon)  Adaptador.getItem(i);
                if (selectedPokemnon != null){
                    Toast.makeText(MainActivity.this, selectedPokemnon.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}