package com.example.pizzeria;

import java.util.ArrayList;

public class Pizza {

    private String nombre;
    private ArrayList<Ingrediente> ingredientes;
    private String tamanio;
    private double precio;

    public Pizza(String nombre, ArrayList<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = new ArrayList<>();
    }

    public Pizza(String nombre, ArrayList<Ingrediente> ingredientes, String tamanio, double precio) {
        this.nombre = nombre;
        this.ingredientes = new ArrayList<>();
        this.tamanio = tamanio;
        this.precio = precio;
    }

    public void mostrarDatos() {
        System.out.println("Pizza: " + nombre);
        for (Ingrediente item : ingredientes) {
            item.mostrarDatos();
        }
        System.out.println("Tamaño: " + tamanio);
        System.out.println("Precio: " + precio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
