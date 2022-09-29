package org.iesch.a02_registro_de_superheroes.model;

import android.os.Parcel;
import android.os.Parcelable;

// LA clase debe extender de Parcelable para poder usar el putextra y pasarse de un activity a otro
public class Superhero implements Parcelable {

    private String name;
    private String alterego;
    private String bio;
    private Float power;

    public Superhero(String name, String alterego, String bio, Float power) {
        this.name = name;
        this.alterego = alterego;
        this.bio = bio;
        this.power = power;
    }

    protected Superhero(Parcel in) {
        name = in.readString();
        alterego = in.readString();
        bio = in.readString();
        if (in.readByte() == 0) {
            power = null;
        } else {
            power = in.readFloat();
        }
    }

    public static final Creator<Superhero> CREATOR = new Creator<Superhero>() {
        @Override
        public Superhero createFromParcel(Parcel in) {
            return new Superhero(in);
        }

        @Override
        public Superhero[] newArray(int size) {
            return new Superhero[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlterego() {
        return alterego;
    }

    public void setAlterego(String alterego) {
        this.alterego = alterego;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(alterego);
        parcel.writeString(bio);
        if (power == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeFloat(power);
        }
    }
}
