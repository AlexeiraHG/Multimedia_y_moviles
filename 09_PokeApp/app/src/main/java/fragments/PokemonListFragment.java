package fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import org.iesch.a09_pokeapp.Model.Pokemon;
import org.iesch.a09_pokeapp.Model.PokemonListAdapter;
import org.iesch.a09_pokeapp.Model.iComunicaFragments;
import org.iesch.a09_pokeapp.R;

import java.util.ArrayList;


public class PokemonListFragment extends Fragment {

    // Declaraciones necesarias
    private ListView lvPokemon;
    private PokemonListAdapter Adaptador;
    private ArrayList<Pokemon> pokemonList = new ArrayList<>();
    View view;
    
    //Declaro la interfaz que voy a utilizar para comunicar los fragments
    iComunicaFragments interfaz;




    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public PokemonListFragment() {
    }


    public static PokemonListFragment newInstance(String param1, String param2) {
        PokemonListFragment fragment = new PokemonListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 1 Creamos una vista que es la que vamos a devolver
        view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);

        // 2 A partir de esta vista vamos a obtener tosdos los views del fragmento
        lvPokemon = view.findViewById(R.id.ListaPokemon);

        // 3 Traemos los datos del mainActivity
        pokemonList.add(new Pokemon("1", "Bulbasaur", Pokemon.Type.PLANT, R.raw.bulbasaur, R.raw.bulbasaur));
        pokemonList.add(new Pokemon("2", "Ivysaur", Pokemon.Type.PLANT, R.raw.ivysaur, R.raw.ivysaur));
        pokemonList.add(new Pokemon("3", "Venuasaur", Pokemon.Type.PLANT, R.raw.venuasaur, R.raw.venuasaur));
        pokemonList.add(new Pokemon("4", "Charmander", Pokemon.Type.FIRE, R.raw.charmander, R.raw.charmander));
        pokemonList.add(new Pokemon("5", "Charmeleon", Pokemon.Type.FIRE, R.raw.charmeleon, R.raw.charmeleon));
        pokemonList.add(new Pokemon("6", "Charizard", Pokemon.Type.FIRE, R.raw.charizard, R.raw.charizard));
        pokemonList.add(new Pokemon("7", "Squirtle", Pokemon.Type.WATER, R.raw.squirtle, R.raw.squirtle));
        pokemonList.add(new Pokemon("8", "Blastoise", Pokemon.Type.WATER, R.raw.blastoise, R.raw.blastoise));
        pokemonList.add(new Pokemon("25", "Pikachu", Pokemon.Type.ELECTRIC, R.raw.pikachu, R.raw.pikachu));
        pokemonList.add(new Pokemon("26", "Raichu", Pokemon.Type.ELECTRIC, R.raw.raichu, R.raw.raichu));

        //Cuando nos pida un contexto desde un fragmento lo haremos usando getActivity
        Adaptador = new PokemonListAdapter(getActivity(), pokemonList, R.id.pokemonListFragment);

        lvPokemon.setAdapter(Adaptador);

        lvPokemon.setOnItemClickListener((adapterView, view, i, l) -> {
            Pokemon selectedPokemon = (Pokemon)  Adaptador.getItem(i);
            if (selectedPokemon != null){
                //Toast.makeText(getActivity(), selectedPokemon.getName(), Toast.LENGTH_SHORT).show();
                //interfaz.enviarPokemon(selectedPokemon)
                ;
            }
        });

        return view;
    }
}