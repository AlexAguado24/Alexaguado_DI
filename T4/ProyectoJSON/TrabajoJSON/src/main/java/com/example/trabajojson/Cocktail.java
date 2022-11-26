package com.example.trabajojson;

public class Cocktail {

    String nombre, foto, tipoCopa;

    public Cocktail(String nombre, String foto, String tipoCopa) {
        this.nombre = nombre;
        this.foto = foto;
        this.tipoCopa = tipoCopa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTipoCopa() {
        return tipoCopa;
    }

    public void setTipoCopa(String tipoCopa) {
        this.tipoCopa = tipoCopa;
    }

    @Override
    public String toString() {
        return "Cocktail: "+ nombre ;
    }
}
