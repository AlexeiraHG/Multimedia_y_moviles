package org.iesch.a10_rectylceview_basico;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // 9 Debemos construir una lista que se envia como parametros al adaptador
    ArrayList<String> listDatos;

    //10 genro una referencia al reciclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 11
        recyclerView = findViewById(R.id.recyclerID);

        //12
        recyclerView.setLayoutManager(new LinearLayoutManager(this/*, LinearLayoutManager.HORIZONTAL, false*/));

        //13
        listDatos = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listDatos.add("Dato #" + i + " ");
        }

        //14 envio la liusta como paramenro al adptador
        AdapterDatos adaptador = new AdapterDatos(listDatos);
        recyclerView.setAdapter(adaptador);
    }
}