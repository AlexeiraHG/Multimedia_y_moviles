package org.iesch.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.iesch.login.databinding.ActivityBienvenidaBinding;

public class BienvenidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBienvenidaBinding binding = ActivityBienvenidaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtener en un objeto de tipo bundle todos los datos traidos de origen
        Bundle extras = getIntent().getExtras();

        // Recibir el objeto superhero de extras
        String userName = extras.getString("user");

        //Agregar el texto de bienvenida al texto
        binding.TVBienvenida.setText(R.string.bienvenida);

        //Agregar nombre del usuario al texto
        binding.TVBienvenida.append(" " + userName + "!");


        //FORMA DE CAMBIAR TITULO DE UN ACTIVITY
        setTitle(userName);
    }
}