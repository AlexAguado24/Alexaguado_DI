package com.example.trabajojson.model;

public class Digimon {

    private String nombre, imagen, nivel;

    public Digimon(String nombre, String imagen, String nivel) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre;
    }
}
