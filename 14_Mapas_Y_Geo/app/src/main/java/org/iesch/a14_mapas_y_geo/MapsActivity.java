package org.iesch.a14_mapas_y_geo;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.iesch.a14_mapas_y_geo.Model.Restaurante;
import org.iesch.a14_mapas_y_geo.databinding.ActivityMapsBinding;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private List<Restaurante> restaurantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //1.3 inicializamos la lista de restaurantes
        addFakeRestaurants();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    //1.2
    private void addFakeRestaurants(){
        restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante("Los amantes de Teruel", 40.335721, -1.103760));
        restaurantes.add(new Restaurante("Rafi kebab", 40.343838, -1.104424));
        restaurantes.add(new Restaurante("Dominos Pizza", 40.333271, -1.097745));
        restaurantes.add(new Restaurante("Wok Real", 40.333298, -1.095426));
        restaurantes.add(new Restaurante("Pizza Burguer", 40.349396, -1.110032));
    }

    //Este metodo ya trae el mapa y podemos trabajar con él
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Objeto LatLng que sirve para colocarnos en cualquier parte del mundo
        LatLng teruel = new LatLng(40.342875, -1.107032);

        //1.4 Recorreer la lista y crear un marker por cada restaurantes.0
        for (Restaurante r : restaurantes) {
            LatLng posicion = new LatLng(r.getLatitud(), r.getLongitud());
            String nombre = r.getNombre().toString();

            //1.5 Para añadir un icono personalizado a cada marker

            //1.6 Crea el marker
            mMap.addMarker(new MarkerOptions()
                    .position(posicion)
                    .icon(bitmapDescriptorFromVector(this, R.drawable.ic_taco))
                    .title(nombre));
        }


        //Para añadir el marcador necesitamos MarkerOptions
        //Le asigna un titulo, pero podemos asignarle mas cosas
        mMap.addMarker(new MarkerOptions().position(teruel).title("TERUEL"));
        //Le dice al mapa que mueva la camara
//      mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //Para hacer que al pinchar har zoom en el mapa
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(teruel, 13.0f));
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}