package org.iesch.a00_calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import org.iesch.a00_calculadora.databinding.ActivityMainBinding;


public class CalculadoraActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.sum.setOnClickListener(v -> {

            double num1Int = 0;
            String numero1 = binding.num1.getText().toString();
            if (!numero1.isEmpty()) {
                num1Int = Double.parseDouble(numero1);
            } else {
                Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_LONG).show();
            }

            double num2Int = 0;
            String numero2 = binding.num2.getText().toString();
            if (!numero2.isEmpty()) {
                num2Int = Double.parseDouble(numero2);
            } else {
                Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_LONG).show();
            }

            double resultado = num1Int + num2Int;
            String resultadoTexto = resultado + "";
            binding.resultado.setText(resultadoTexto);

        });

        binding.res.setOnClickListener(v -> {

            double num1Int = 0;
            String numero1 = binding.num1.getText().toString();
            if (!numero1.isEmpty()) {
                num1Int = Double.parseDouble(numero1);
            } else {
                Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_LONG).show();
            }

            double num2Int = 0;
            String numero2 = binding.num2.getText().toString();
            if (!numero2.isEmpty()) {
                num2Int = Double.parseDouble(numero2);
            } else {
                Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_LONG).show();
            }

            double resultado = num1Int - num2Int;
            String resultadoTexto = resultado + "";
            binding.resultado.setText(resultadoTexto);

        });

        binding.mul.setOnClickListener(v -> {
            double num1Int = 0;
            String numero1 = binding.num1.getText().toString();
            if (!numero1.isEmpty()) {
                num1Int = Double.parseDouble(numero1);
            } else {
                Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_LONG).show();
            }

            double num2Int = 0;
            String numero2 = binding.num2.getText().toString();
            if (!numero2.isEmpty()) {
                num2Int = Double.parseDouble(numero2);
            } else {
                Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_LONG).show();
            }

            double resultado = num1Int * num2Int;
            String resultadoTexto = resultado + "";
            binding.resultado.setText(resultadoTexto);
        });

        binding.div.setOnClickListener(v -> {
            double num1Int = 0;
            String numero1 = binding.num1.getText().toString();

            if (!numero1.isEmpty()) {
                num1Int = Double.parseDouble(numero1);
            } else {
                Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_LONG).show();
            }

            double num2Int = 0;
            String numero2 = binding.num2.getText().toString();
            if (numero2 == "0") {
                Toast.makeText(this, getString(R.string.cero), Toast.LENGTH_LONG).show();
            }
            if (!numero2.isEmpty()) {
                num2Int = Double.parseDouble(numero2);
            } else {
                Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_LONG).show();
            }

            double resultado = num1Int / num2Int;
            String resultadoTexto = resultado + "";
            binding.resultado.setText(resultadoTexto);
        });
    }
}