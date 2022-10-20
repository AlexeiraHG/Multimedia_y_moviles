package org.iesch.a07_lista_simple_personalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //9 Declaro listview y adaptador
    private ListView lvPeliculas;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //10 enlazo
        lvPeliculas = findViewById(R.id.lvLista);
        adaptador = new Adaptador(obtenerListaPelicula(), this);

        //12 Asignamos el adaptador al listView
        lvPeliculas.setAdapter(adaptador);

    }

    // 11 Metodo para crear la lista de peliculas
    private ArrayList<Pelicula> obtenerListaPelicula(){
        ArrayList<Pelicula> listaPelicula = new ArrayList<>();
        listaPelicula.add(new Pelicula(R.drawable.fiestasalchicha, "LA FIESTA DE LA SALCHICHA", "2016"));
        listaPelicula.add(new Pelicula(R.drawable.hoteltransilvania, "HOTEL TRANSILVANIA", "2018"));
        listaPelicula.add(new Pelicula(R.drawable.jurassicpark, "JURASSIC PARK", "1992"));
        listaPelicula.add(new Pelicula(R.drawable.regeresoalfuturo, "REGRESO AL FUTURO", "1988"));
        listaPelicula.add(new Pelicula(R.drawable.shrek, "SHREK", "2015"));
        listaPelicula.add(new Pelicula(R.drawable.titanic, "TITANIC", "1997"));
        listaPelicula.add(new Pelicula(R.drawable.ultimallamada, "ULTIMA LLAMADA", "2017"));
        return listaPelicula;
    }
}