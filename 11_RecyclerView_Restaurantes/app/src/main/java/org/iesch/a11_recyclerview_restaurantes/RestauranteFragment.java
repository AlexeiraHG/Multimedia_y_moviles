package org.iesch.a11_recyclerview_restaurantes;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.iesch.a11_recyclerview_restaurantes.Model.Restaurante;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class RestauranteFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters

    private int mColumnCount = 1;

    // 3
    ArrayList<Restaurante> restauranteList;

    //3.5 Declaracion de addatador
    MyRestauranteRecyclerViewAdapter adaptadorRestaurantes;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            // 4 - Nos creamos una lista de Restaurantes
            restauranteList = new ArrayList<>();
            // 6 - Llenamos de restaurantes el tema
            restauranteList.add(new Restaurante("Pizzer??a Don Topo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsh-vwIw4nZLQ5lUJf-hnz7uQiEykeKqMfeg&usqp=CAU", 4.0f,"Teruel. Spain"));
            restauranteList.add(new Restaurante("Sam Doner Kebab", "", 3.0f,"Teruel. Spain"));
            restauranteList.add(new Restaurante("Bar de Cella Kiosko", "", 1.0f,"Cella - Teruel. Spain"));
            restauranteList.add(new Restaurante("Bar IES Chomon", "", 5.0f,"Teruel. Spain"));
            restauranteList.add(new Restaurante("Bar la Mina", "", 4.0f,"Teruel. Spain"));
            // se lo asignamos al adapter


            // 3 - Asociar el adaptador al RecyclerView
            adaptadorRestaurantes = new MyRestauranteRecyclerViewAdapter(getActivity(), restauranteList);
            recyclerView.setAdapter(adaptadorRestaurantes);
            // y eliminamos el paquete generado de dummyContent
        }
        return view;
    }
}