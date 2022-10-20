package org.iesch.a07_lista_simple_personalizada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//1 Para ser un adaptador debe extender de BaseAdapter
public class Adaptador extends BaseAdapter {

    //2 Creamos algunos atributos  necesarios par aesta clase
    private ArrayList<Pelicula> listaPelis;
    private Context contex;

    //3 Generamos el consttructor


    public Adaptador(ArrayList<Pelicula> listaPelis, Context contex) {
        this.listaPelis = listaPelis;
        this.contex = contex;
    }

    //4 Este metodo le indica a la listView cuantos elementos va a tener
    @Override
    public int getCount() {
        return listaPelis.size();
    }

    //5 Nos da la posicion
    @Override
    public Object getItem(int i) {
        return listaPelis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //6 Aqui se cre acada ite, y se le asignan valores de cada elemento a cada item
    //Se ejecuta tantas veces como elemntos haya en la lista
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(contex).inflate(R.layout.item_lista, null);

        //7 Se crea cada elemento que va a obtener el item
        ImageView imgCartel = view.findViewById(R.id.imgCartel);
        TextView tvTitulo  = view.findViewById(R.id.tvTitulo);
        TextView tvAno  = view.findViewById(R.id.tvAno);

        //8 Creamos el elemento peliculas
        Pelicula pelicula = (Pelicula) getItem(i);

        //8 Se rellena con datos cada elemento
        imgCartel.setImageResource(pelicula.getImgfoto());
        tvTitulo.setText(pelicula.getTitulo());
        tvAno.setText(pelicula.getAno());

        return view;
    }
}
