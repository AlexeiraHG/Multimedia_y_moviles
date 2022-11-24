package org.iesch.mi_proyecto_firebase_dam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {
    //1 log
    private FirebaseAnalytics mFirebaseAnalytics;

    //1 Autenticacion
    private FirebaseAuth mAuth;

    TextView etEmail;
    TextView etPassword;
    Button btnRegistrar;
    Button btnLogin;



    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            //3.1 Autenticacion (Si el usuario esta logeado, ira directo a home)
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.emailTxt);
        etPassword = findViewById(R.id.passwdTxt);
        btnRegistrar = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);

        // 2 log: Codigo para crear eventos cada  que se entra a esta activciity
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("DAM2", "Aplicacion iniciada");
        mFirebaseAnalytics.logEvent("DAM2", bundle);

        // 2 Autenticacion
            // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // 3.2
        btnRegistrar.setOnClickListener(view -> {
            registrarConEmailPassword();
        });

    }


    // 3.2.1 Autenticacion
    private void registrarConEmailPassword(){
        String _email = etEmail.getText().toString();
        String _password = etPassword.getText().toString();

        mAuth.createUserWithEmailAndPassword(_email, _password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FIREBASE", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(loginActivity.this, "Usuario registrado.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("FIREBASE", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(loginActivity.this, "Error al registrar el usuario.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }


}