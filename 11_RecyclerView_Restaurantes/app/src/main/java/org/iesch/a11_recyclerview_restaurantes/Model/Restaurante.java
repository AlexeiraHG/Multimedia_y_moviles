package org.iesch.a11_recyclerview_restaurantes.Model;

public class Restaurante {

    private String nombre;
    private String urlFoto;
    private float valoracion;
    private String direccion;

    public Restaurante(String nombre, String urlFoto, float valoracion, String direccion) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.valoracion = valoracion;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public float getValoracion() {
        return valoracion;
    }

    public String getDireccion() {
        return direccion;
    }
}
