package org.iesch.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.iesch.login.databinding.ActivityMainBinding;

public class  MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.IniBtn.setOnClickListener(v -> {

            //Si hay texto en el campo de user y de contraseña
            if (binding.ETUser.getText().length() >0 && binding.ETContraseA.getText().length() > 0) {

                //Crear intent de esta activity a la de bienvenida
                Intent irABienvenida = new Intent(this, BienvenidaActivity.class);

                //Manndar con el putextra el texto del user
                irABienvenida.putExtra("user", binding.ETUser.getText().toString());

                //LLamar al intent
                startActivity(irABienvenida);
            }else {
                //Sino informar al usuario con un toast de rellenar los campos
                Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_SHORT).show();
            }
        });


    }
}