package org.iesch.a12_pokeapp_retrofit.PokeApi;

import org.iesch.a12_pokeapp_retrofit.Model.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeApiService {
    // 4 En esta ocasion solo vamos a acceder al listado de los pokemons
    //El tipo de retorno SIEMPRE va a ser un objeto de tipo Call
    //Tenemos que especificar que accion usara y con que URL
    @GET ("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);
}
