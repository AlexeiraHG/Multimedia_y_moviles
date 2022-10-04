package org.iesch.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FORMA DE CAMBIAR TITULO DE UN ACTIVITY
        setTitle(getString(R.string.contraseña));
    }
}