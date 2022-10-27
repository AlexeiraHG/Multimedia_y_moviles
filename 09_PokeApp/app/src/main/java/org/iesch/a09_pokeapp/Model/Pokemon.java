package org.iesch.a09_pokeapp.Model;

//Me creo el objeto con sus campos, su constructor y sus getters
public class Pokemon {
    private String id;
    private String name;
    private Type type;
    //1- le cambio porque ahora vamos a usar urls
    private String imageurl;
    private int soundId;
    private Stats stats;


    public enum Type{
        FIRE, WATER, PLANT, ELECTRIC;
    }

    public Pokemon(String id, String name, Type type, int soundId, String imageurl, Stats stats) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.soundId = soundId;
        this.imageurl = imageurl;
        this.stats = stats;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getImageurl() {
        return imageurl;
    }

    public int getSoundId() {
        return soundId;
    }

    public Stats getStats() {
        return stats;
    }
}
