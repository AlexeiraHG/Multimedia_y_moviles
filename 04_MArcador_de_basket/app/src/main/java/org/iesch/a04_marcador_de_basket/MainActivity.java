package org.iesch.a04_marcador_de_basket;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import org.iesch.a04_marcador_de_basket.ViewModel.MainViewModel;
import org.iesch.a04_marcador_de_basket.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    //Variables de puntos
//    private int localScore = 0;
//    private int visitorScore = 0;

    // MVVM 5 Variable de tipo viewModel para usar en el mainactivity
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Añadir binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        // MVVM 6 - El vm se instancia de forma diferente a otros objetos. El provider se encarga de acciones automaticamente
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        //LD 6 - Entran en juego los observers
        viewModel.getLocalScore().observe(this, locaScoreInteger ->{
            //Este entero es el valor dle mutable live data que estamos obsrevando
            binding.LocalScoreText.setText(String.valueOf(locaScoreInteger));
        });
        viewModel.getVisitorScore().observe(this, VisitorScoreInteger ->{
            //Este entero es el valor dle mutable live data que estamos obsrevando
            binding.VisitScoreText.setText(String.valueOf(VisitorScoreInteger));
        });


        //Metodo para cargar los botones
        setUpBtn();
    }

    // LV 6 - Al cambiar los valores cambiaran los texView asi que ya no es necesario hacerlo de forma manual
    // siempre que ocurra un cambio en los valores, se activará su observer y cambiará de valor
    // ahora al girar la pantalla no se borraran los datos ya que no van aunados al ciclo de vida de app sino
    // al livedata (por eso estan comentados todas las lineas en las que s eusa el binding para cambiar el texto de la activity)


    // MVVM 7 - Tomamos las variables del viewmodel en vez de las locales
    private void setUpBtn() {
        // restar puntuacion local
        binding.LocalMinusBtn.setOnClickListener(v -> {
            viewModel.decreaseLocal();
            //binding.LocalScoreText.setText(String.valueOf(viewModel.getLocalScore()));
        });


        binding.VisitMinusBtn.setOnClickListener(v -> {
            viewModel.decreaseVisitor();
           // binding.VisitScoreText.setText(String.valueOf(viewModel.getVisitorScore()));
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
        intent.putExtra("local", viewModel.getLocalScore().getValue());
        intent.putExtra("visitor", viewModel.getVisitorScore().getValue());
        startActivity(intent);
    }

    //Metodo sumar
    private void addPointsToScore(int point, boolean isLocal) {
        viewModel.addPointsToScore(point, isLocal);
        if (isLocal) {
//           localScore += point;
            //binding.LocalScoreText.setText(String.valueOf(viewModel.getLocalScore()));//
        } else {
//           visitorScore += point;
            //binding.VisitScoreText.setText(String.valueOf(viewModel.getVisitorScore()));
        }
    }

    //Resetear marcadores
    private void ResetScore() {
//        localScore = 0;
//        visitorScore = 0;
        viewModel.ResetScore();
        //binding.LocalScoreText.setText(String.valueOf(viewModel.getLocalScore()));
        //binding.VisitScoreText.setText(String.valueOf(viewModel.getLocalScore()));
    }


}