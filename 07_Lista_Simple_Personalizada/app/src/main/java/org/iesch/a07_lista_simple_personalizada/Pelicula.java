package org.iesch.a07_lista_simple_personalizada;

public class Pelicula {

    private int imgfoto;
    private String titulo;
    private String ano;

    public Pelicula(int imgfoto, String titulo, String ano) {
        this.imgfoto = imgfoto;
        this.titulo = titulo;
        this.ano = ano;
    }

    public int getImgfoto() {
        return imgfoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAno() {
        return ano;
    }
}
