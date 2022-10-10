package org.iesch.a05_dashboard_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import org.iesch.a05_dashboard_menu.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

   ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUpMenu();
    }

    private void setUpMenu() {
        binding.rellayCalculadora.setOnClickListener(view -> {
            Intent intent = new Intent(this, CalculadoraActivity.class);
            startActivity(intent);
        });

        binding.rellayAmigos.setOnClickListener(view -> {
            Intent intent = new Intent(this, UsersActivity.class);
            startActivity(intent);
        });

        binding.rellayPerro.setOnClickListener(view -> {
            Intent intent = new Intent(this, EdadCaninaActivity.class);
            startActivity(intent);
        });

        binding.rellayQuizzes.setOnClickListener(view -> {
            Intent intent = new Intent(this, QuizzesActivity.class);
            startActivity(intent);
        });

        binding.rellayGaleria.setOnClickListener(view -> {
            Intent intent = new Intent(this, GalleryActivity.class);
            startActivity(intent);
        });

        binding.rellayMapas.setOnClickListener(view -> {
            Intent intent = new Intent(this, MapasActivity.class);
            startActivity(intent);
        });

        binding.rellayRestaurantes.setOnClickListener(view -> {
            Intent intent = new Intent(this, RestaurantesActivity.class);
            startActivity(intent);
        });

        binding.rellaySettings.setOnClickListener(view -> {
            Intent intent = new Intent(this, HerramientasActivity.class);
            startActivity(intent);
        });
    }
}