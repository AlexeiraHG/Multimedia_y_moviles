package fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import org.iesch.a09_pokeapp.R;


public class DetailFragment extends Fragment {

    //Dleclaraciones
    private ImageView detailImageView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public DetailFragment() {
    }


    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    // 9 - establecemos la imagen que queremos en detailFragment
    public void setPokemonImage(int pokemonImageId) {
        detailImageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), pokemonImageId));
    }

    public void playPokemonSound(int pokemonSoundId) {
        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), pokemonSoundId);
        mediaPlayer.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //creamos el vew wn el onCreatView
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        detailImageView = view.findViewById(R.id.pokemon_detail_imageView);

        return view;
    }
}