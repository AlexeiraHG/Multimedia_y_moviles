package org.iesch.a04_marcador_de_basket;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.iesch.a04_marcador_de_basket.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    //Variables de puntos
    private int localScore = 0;
    private int visitorScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Añadir binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //Metodo para cargar los botones
        setUpBtn();

    }

    private void setUpBtn() {
        // restar puntuacion local
        binding.LocalMinusBtn.setOnClickListener(v -> {
            if (localScore > 0) {
                localScore--;
                binding.LocalScoreText.setText(String.valueOf(localScore));
            }
        });

        binding.VisitMinusBtn.setOnClickListener(v -> {
            if (visitorScore > 0) {
                visitorScore--;
                binding.LocalScoreText.setText(String.valueOf(visitorScore));
            }
        });

        //Botones de sumar
        binding.LocalSumar1Btn.setOnClickListener(view -> {
            addPointsToScore(1, true);
        });
        binding.LocalSumar2Btn.setOnClickListener(view -> {
            addPointsToScore(2, true);
        });

        binding.VisitSumar1Btn.setOnClickListener(view -> {
            addPointsToScore(1, false);
        });
        binding.VisitSumar2Btn.setOnClickListener(view -> {
            addPointsToScore(2, false);
        });

        binding.restartBtn.setOnClickListener(view -> {
            ResetScore();
        });


        binding.ResultBtn.setOnClickListener(view -> {
            EndGame();
        });
    }

    //Metodo final del juego
    private void EndGame() {
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("local", localScore);
        intent.putExtra("visitor", visitorScore);
        startActivity(intent);
    }

    //Metodo sumar
    private void addPointsToScore(int point, boolean isLocal) {
        if (isLocal) {
            localScore += point;
            binding.LocalScoreText.setText(String.valueOf(localScore));
        } else {
            visitorScore += point;
            binding.VisitScoreText.setText(String.valueOf(visitorScore));
        }
    }

    //Resetear marcadores
    private void ResetScore() {
        localScore = 0;
        visitorScore = 0;
        binding.LocalScoreText.setText(String.valueOf(localScore));
        binding.VisitScoreText.setText(String.valueOf(visitorScore));
    }


}