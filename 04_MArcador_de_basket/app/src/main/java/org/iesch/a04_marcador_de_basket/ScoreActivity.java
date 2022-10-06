package org.iesch.a04_marcador_de_basket;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.iesch.a04_marcador_de_basket.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    private ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Recojo lo que viene del intent

        int local = getIntent().getExtras().getInt("local");
        int visitor = getIntent().getExtras().getInt("visitor");

        binding.ScoreText.setText(getString(local) + " - " + getString(visitor));

        if (local > visitor) {
            binding.Ganadores.setText("Gano el equipo local");
        } else if (visitor > local) {
            binding.Ganadores.setText("Gano el equipo visitante");
        } else {
            binding.Ganadores.setText("Ha habido un empate");
        }


    }
}