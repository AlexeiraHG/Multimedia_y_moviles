package org.iesch.mi_proyecto_firebase_dam;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.iesch.mi_proyecto_firebase_dam.R;

public class HomeActivity extends AppCompatActivity {

    TextView tvEmail;
    TextView tvMetodo;
    Button LogoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvEmail = findViewById(R.id.emailTxt);
        tvMetodo = findViewById(R.id.metodoTxt);
        LogoutBtn = findViewById(R.id.logoutButton);

        // 1 Obtener info del intent de Login
        InfoDeLogin();

    }

    private void InfoDeLogin() {
        //Recuperamos la info de loginActivity
        //Bundle B =
    }
}