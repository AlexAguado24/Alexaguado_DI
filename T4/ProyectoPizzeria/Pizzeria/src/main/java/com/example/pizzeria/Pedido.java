package com.example.pizzeria;

public class Pedido {

    private int id;
    private String nombre;
    private int telefono;
    private Pizza pizza;

    public Pedido(int id, String nombre, int telefono, Pizza pizza) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.pizza = pizza;
    }

    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Telefono: " + telefono);
        int contador = 1;
        for (Ingrediente item : pizza.getIngredientes()) {
            System.out.printf("Ingrediente %d: %s%n",contador, item);
            contador++;
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return id + " " + nombre + " " + pizza.getNombre();
    }
}
