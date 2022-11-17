package org.iesch.a14_mapas_y_geo.Model;

public class Restaurante {
    private String nombre;
    private Double latitud;
    private Double longitud;

    public Restaurante(String nombre, Double latitud, Double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }
}
