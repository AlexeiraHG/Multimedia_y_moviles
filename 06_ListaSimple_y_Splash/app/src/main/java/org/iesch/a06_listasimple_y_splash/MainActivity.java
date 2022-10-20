package org.iesch.a06_listasimple_y_splash;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lista;
    List<String> versionesAndroidlst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Lista simple");

        //1 - Conectar el listview al componente visual de id
        lista = findViewById(R.id.listView);

        //2 - Cargar la lista de elementos
        versionesAndroidlst = new ArrayList<>();
        versionesAndroidlst.add("Pie");
        versionesAndroidlst.add("Oreo");
        versionesAndroidlst.add("Nougat");
        versionesAndroidlst.add("Marshmallow");
        versionesAndroidlst.add("Lollipop");
        versionesAndroidlst.add("KitKat");
        versionesAndroidlst.add("JellyBean");
        versionesAndroidlst.add("Ice Cream");
        versionesAndroidlst.add("...");

        //3 - Definimos el adaptador
            //Transformara la lista de String al formato visualizable ne la lista, pintandolos como elemntos visuales
            //Vamos a usar una plantilla por defecto que tiene Adroid (Una simple de casdna de caracterew)
        ArrayAdapter adapterVersAndroid = new ArrayAdapter(
                this, //Desde dodne se le llama
                android.R.layout.simple_list_item_1, //Template que vamos a utilizar par pintar los elementos
                versionesAndroidlst //La lista que queremos cargar en el ListView
        );

        //4 - vinculamos el adaptador con el ListView pertinente
        lista.setAdapter(adapterVersAndroid);

        //5 - GEstionamos los elementos click sobre los elementos de la lista
        lista.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        //Este método autogenerado se escribe el codigo de evento par cuando el usuario haga click en cualquier elemento de la lista
        //La posicion del elemnto en la que ha hecho click viene determinada por "position/i"

        String nombreVersion = versionesAndroidlst.get(position);
        Toast.makeText(this, "Nombre de la versión: "+nombreVersion, Toast.LENGTH_SHORT).show();
    }
}