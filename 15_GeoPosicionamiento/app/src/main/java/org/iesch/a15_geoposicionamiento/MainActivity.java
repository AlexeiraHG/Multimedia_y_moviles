package org.iesch.a15_geoposicionamiento;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    // 7.5 Declaracion de constantes
    private static final long DEFAULT_UPDATE_INTERVAL = 5000;
    private static final long FAST_DEFAULT_INTERVAL = 3000;
    private static final int PERMISSION_FINE_LOCATION = 99;

    // 3 Declaracion de elementos de la UI
    TextView tv_lat, tv_lon, tv_altitude, tv_accuracy, tv_speed, tv_sensor, tv_updates, tv_address;
    Switch sw_locationsupdates, sw_gps;

    //5 Creamos el objeto fuser location
    FusedLocationProviderClient fusedLocationProviderClient;

    //6 location Request
    LocationRequest locationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //4 Ontengo las referencias de la UI
        tv_lat = findViewById(R.id.tv_lat);
        tv_lon = findViewById(R.id.tv_lon);
        tv_altitude = findViewById(R.id.tv_altitude);
        tv_accuracy = findViewById(R.id.tv_accuracy);
        tv_speed = findViewById(R.id.tv_speed);
        tv_sensor = findViewById(R.id.tv_sensor);
        tv_updates = findViewById(R.id.tv_updates);
        tv_address = findViewById(R.id.tv_lon);
        sw_locationsupdates = findViewById(R.id.sw_locationsupdates);
        sw_gps = findViewById(R.id.sw_gps);

        // 7 Set dEl archivo locationRequest
        locationRequest = new LocationRequest();
        //get Interval es para caunto tiempo se actualiza la ubicacion
        locationRequest.setInterval(DEFAULT_UPDATE_INTERVAL);

        //getFastestInterval para como se actualiza en movimiento
        locationRequest.setFastestInterval(FAST_DEFAULT_INTERVAL);

        //setPriority Precsion si alta prioridad o bateria
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        // 8 ontrolamos el cambio en el switc
        sw_gps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (sw_gps.isChecked()) {
                    //Si esta activado usara la maxima precision
                    locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                    tv_sensor.setText("Usando la maxima precicon gps");

                } else {
                    locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                    tv_sensor.setText("GPS por 4G y WIfi");
                }
            }
        });

        //9 Obtenemos/Actualizamos la posicion
        updateGPS();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISSION_FINE_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                }
        }
    }

    private void updateGPS() {
        //Obtterner permisos del usuario GPS
        //Obtener la localizacion desde el location client
        //Actualizar la UI
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //Aqui se entra cuanto tenga permisos de localizacion
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    updateUI(location);
                }
            });
        } else {
            //Todavia no tengo los permisos de localizacion

            //Si la version es mayor o igual que la vversion M de Android (Marsmellow)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_FINE_LOCATION);
            }
        }
    }


    private void updateUI(Location location) {
        // 11 Actualizar los valores de la interfaz de la nueva location
        tv_lat.setText(String.valueOf(location.getLatitude()));
        tv_lon.setText(String.valueOf(location.getLongitude()));
        tv_accuracy.setText(String.valueOf(location.getAccuracy()));
        if (location.hasAltitude()) {
            tv_altitude.setText(String.valueOf(location.getAltitude()));
        } else tv_altitude.setText("No disponible");

        if (location.hasSpeed()) {
            tv_speed.setText(String.valueOf(location.getSpeed()));
        } else tv_speed.setText("No disponible");


    }


}