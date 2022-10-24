package org.iesch.a09_pokeapp.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.iesch.a09_pokeapp.R;

import java.util.ArrayList;

// 2 - Creo el pokemon list adapter que ha de extemder de BaseAdapter
public class PokemonListAdapter extends BaseAdapter {

    //3 - Atributos necesarioa para la clase
    private Context context;
    private ArrayList<Pokemon> pokemonLst;
    private int layoutID;

    // 4 - Genero el constructor del adaptador
    public PokemonListAdapter(Context context, ArrayList<Pokemon> pokemonLst, int layoutID) {
        this.context = context;
        this.pokemonLst = pokemonLst;
        this.layoutID = layoutID;
    }

    // 5 - Modifico los metodos que sean necesarios
    @Override
    public int getCount() {
        return pokemonLst.size();
    }

    @Override
    public Object getItem(int i) {
        return pokemonLst.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    // 6 - En getView vamos a crear cad item
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Pokemon pokemon = (Pokemon) getItem(i);

        // 7 -
        view = LayoutInflater.from(context).inflate(R.layout.pokemon_list_item, null);
        TextView pokemonIdTV = view.findViewById(R.id.pokemon_list_id_textView);
        TextView pokemonNameTV = view.findViewById(R.id.pokemon_list_name_text_view);
        ImageView pokemonTypeIV = view.findViewById(R.id.pokemon_list_item_type_image);


        // 8 - LLenamos la lista de elementos

        pokemonIdTV.setText(pokemon.getId());
        pokemonNameTV.setText(pokemon.getName());
        final Pokemon.Type type = pokemon.getType();
        // en vase al superpodere se le asigna un iciono u otro
        switch (type) {
            case FIRE:
                pokemonTypeIV.setImageResource(R.drawable.fire);
                break;
            case PLANT:
                pokemonTypeIV.setImageResource(R.drawable.plant);
                break;
            case WATER:
                pokemonTypeIV.setImageResource(R.drawable.water);
                break;
            case ELECTRIC:
                pokemonTypeIV.setImageResource(R.drawable.electric);
                break;
        }


        return view;
    }
}
