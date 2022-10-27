package org.iesch.a09_pokeapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.iesch.a09_pokeapp.Model.Stats;
import org.iesch.a09_pokeapp.R;


public class StatsFragment extends Fragment {


    private static final String POKEMON_STATS = "pokemon_stats";


    public StatsFragment() {

    }


    public static StatsFragment newInstance(Stats pokemonStats) {
        StatsFragment fragment = new StatsFragment();
        // A este bundle le vamos a meter los datos de los Stats
        Bundle args = new Bundle();
        args.putParcelable(POKEMON_STATS, pokemonStats);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        //capturamos los stats
        TextView hpTextView = view.findViewById(R.id.fragment_stats_hp);
        TextView ataqueTextView = view.findViewById(R.id.fragment_stats_ataque);
        TextView defensaTextView = view.findViewById(R.id.fragment_stats_defensa);
        TextView velocidadTextView = view.findViewById(R.id.fragment_stats_velocidad);

        if (getArguments()!=null){
            Stats pokemonStats = getArguments().getParcelable(POKEMON_STATS);

            //ahora llenamos los views con las stats
            hpTextView.setText(pokemonStats.getHp());
            ataqueTextView.setText(pokemonStats.getAttack());
            defensaTextView.setText(pokemonStats.getDefence());
            velocidadTextView.setText(pokemonStats.getSpeed());
        }



        return view;
    }
}