package org.iesch.a11_recyclerview_restaurantes;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.iesch.a11_recyclerview_restaurantes.Model.Restaurante;
import org.iesch.a11_recyclerview_restaurantes.databinding.FragmentRestauranteBinding;

import java.util.List;


public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    // Cambiamos de dummy a Restaurante ( en 3 sitios)
    private final List<Restaurante> mValues;

    //12
    private Context ctx = context;

    public MyRestauranteRecyclerViewAdapter(Context context, List<Restaurante> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentRestauranteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }
    //Dibuja la lista. Se ejecuta tantas veces como elemtnos en la lista

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //10 Rescatamos los datos del elemtno que ocupa la posicion position
        holder.txtRestaurante.setText(mValues.get(position).getNombre());
        holder.txtDireccion.setText(mValues.get(position).getNombre());
        holder.rateBarValoracion.setRating(mValues.get(position).getValoracion());

        // 11 Implementamos la carga de la imagen usando la linreria "GLIDE" (https://github.com/bumptech/glide: AL final, lo que esta en dependencias)
        Glide.with(ctx);

        //13

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    // Esca clase mapea el diseño de los objetos del layout donde definimos un elemento de la lista
    // Coge cada uno d elos elementos de nuestro layout y los asigna a una variable final del tipo que sea
    // Esta clase depende en gran medida del diseño que tengamos, así que vamos al XML
    public class ViewHolder extends RecyclerView.ViewHolder {
        //7 - Presonalizamos el diseño connforme al diseño
        public final TextView txtRestaurante;
        public final TextView txtDireccion;
        public final ImageView imgRestaurante;
        public final RatingBar rateBarValoracion;
        public Restaurante mItem;

        //Dentro de este metodo contructor recibiremos el parametro del alyou completo
        //y a partir de ahi podemos buscar el elmento en cuestion
        public ViewHolder(FragmentRestauranteBinding binding) {
            super(binding.getRoot());
           // 8 Con cada linea vinculamos cada elemento
            txtRestaurante = binding.txtRestaurante;
            txtDireccion = binding.txtDireccion;
            imgRestaurante = binding.imgRestaurante;
            rateBarValoracion = binding.rateBarValoracion;
        }

        // 9 Modificamos este metodo para que imprima el nombre del restaurante
        @Override
        public String toString() {
            return super.toString() + " '" + txtRestaurante.getText() + "'";
        }
    }
}