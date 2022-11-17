package org.iesch.a12_pokeapp_retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.iesch.a12_pokeapp_retrofit.Model.Pokemon;

import java.util.ArrayList;

//Se crea el adaptador que implementa la clase adapter
public class ListaPokemonAdpatader extends RecyclerView.Adapter<ListaPokemonAdpatader.VieHolder> {
    // 5
    private ArrayList<Pokemon> listaPokemon;

    //20
    private Context context;

    //9
    public ListaPokemonAdpatader(Context context){
        this.context = context;
        listaPokemon = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaPokemonAdpatader.VieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 8
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);

        return new VieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPokemonAdpatader.VieHolder holder, int position) {
        //7
        Pokemon p = listaPokemon.get(position);
        holder.nombreTxt.setText(p.getName());
        // 19 Luego se mete aqui la imagen con GLIDE
        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/&quot;" + p.getNumber() + ".png")
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(holder.fotoIv);
    }

    @Override
    public int getItemCount() {
        // 6

        return listaPokemon.size();
    }

    public void adicionarPokemon(ArrayList<Pokemon> listaPokemon) {
        // 15 permitimos que junte el arrray que llega con el adaptador
        listaPokemon.addAll(listaPokemon);

        //Con este metodo actualizarwmos el recycler view en la pantalla
        notifyDataSetChanged();
    }

    public class VieHolder extends RecyclerView.ViewHolder {
//        4
        private ImageView fotoIv;
        private TextView nombreTxt;
        public VieHolder(@NonNull View itemView) {
            super(itemView);
            //4b
            fotoIv =itemView.findViewById(R.id.fotoIv);
            nombreTxt = itemView.findViewById(R.id.nombreTxt);
        }

    }
}
