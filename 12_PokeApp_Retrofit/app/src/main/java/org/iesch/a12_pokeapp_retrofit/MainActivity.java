package org.iesch.a12_pokeapp_retrofit;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.iesch.a12_pokeapp_retrofit.Model.Pokemon;
import org.iesch.a12_pokeapp_retrofit.Model.PokemonRespuesta;
import org.iesch.a12_pokeapp_retrofit.PokeApi.PokeApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // 1 Creamos una instancia de retrofit
    private Retrofit retrofit;

    //10
    private RecyclerView recyclerView;
    private ListaPokemonAdpatader listaPokemonAdpatador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2 accesible la clase
        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/") //Parte que no cambia de la url de la base de datos/API que necesitamos
                .addConverterFactory(GsonConverterFactory.create()) // definicion de como se formastea nuestra respuesta (gson. json)
                .build();

        //it 11 Hacemos las configuraciones iniciales en eñl recivcly view
        recyclerView = findViewById(R.id.recyclerView);
        listaPokemonAdpatador = new ListaPokemonAdpatader(this);
        recyclerView.setAdapter(listaPokemonAdpatador);

        //12 nuetsro grid queremos que tenga 3 columnas
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);

        //13 lo asignamos al recycler
        recyclerView.setLayoutManager(layoutManager);


        //14

        offset= 0;
        obtenerDatos(offset);


    }
    //3 creamos un metodo que se encargara de obtenre los datos
    private void obtenerDatos(int offset){
        //La manera de trabajar con retrofit es crearnos una interfaz de java que se pondran todos los metodos a usar

        //7 usamos la interfaz que acabamdo de crear
        PokeApiService service = retrofit.create(PokeApiService.class);

        // 8 Nuestra variable service ya puede llamar a la variable que acabamos de crear
        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemon(20,20);

        //9 usaremos el metodo enque para manejar los resultados en sus metodos internos
        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            // Este metodo se ejecuta cuando llega la respuesta a la consulta que hicimos
            // (que hace en caso de que la api responda "onResponse" o por alguna razon ha falladp "onFailure")
            // que se ejecute el onResponse no significa que todo haya ido bien
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                if (response.isSuccessful()){
                   // 10 Me genero un pokemon respuesta igual a lo obtenido
                   PokemonRespuesta pokemonRespuesta = response.body();

                    // 11 Array de los pokemon con lo que obtuvimos en la respuesta
                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();


                    //14 cuando recibimos los datos ya no se muestran por consola
//                    sino que se mandan al adpatador por medio de un metodo
                    listaPokemonAdpatador.adicionarPokemon(listaPokemon);

//                    for (int i = 0; i < listaPokemon.size(); i++) {
//                        Pokemon p = listaPokemon.get(i);
//                        Log.i("LISTA POKEMON", "Pokemon: " + p.getName());
//                    }
                } else {
                    Log.i("POKEMON", "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                Log.i("POKEMON", "onFailure: " + t.getMessage());
            }
        });
    }
}