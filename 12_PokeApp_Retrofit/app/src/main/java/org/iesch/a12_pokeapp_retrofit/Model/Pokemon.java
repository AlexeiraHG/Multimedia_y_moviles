package org.iesch.a12_pokeapp_retrofit.Model;

// 18 SE AÑADE EL atributo number a la clase pokemon debido a la info que tenemos
public class Pokemon {
    private String name;
    private String url;
    private int number;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getNumber() {
        String[] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length-1]);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
