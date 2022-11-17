package org.iesch.a12_pokeapp_retrofit.Model;

import java.util.ArrayList;

public class PokemonRespuesta {
    //5 Tenemos que poner los atributos de aquella informacion que nos interesa del json
    // en nuestro caso nos interesan los results (array)
     private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
