package com.example.jose_alejandro_aguado_merino;

public class Usuario {

    private String nombre, correo,pass,rol;
    private int telefono;

    public Usuario(String nombre, int telefono, String correo, String pass, String rol) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.pass = pass;
        this.rol = rol;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
