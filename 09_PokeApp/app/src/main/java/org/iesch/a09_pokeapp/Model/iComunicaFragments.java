package org.iesch.a09_pokeapp.Model;

import org.iesch.a09_pokeapp.Model.Pokemon;

public interface iComunicaFragments {
    // 8 - Esta interfaz sirve como puente para comunicar los fragments
    public void enviarPokemon(Pokemon pokemon);
}