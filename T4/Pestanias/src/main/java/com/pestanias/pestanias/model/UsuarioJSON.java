package com.pestanias.pestanias.model;

public class UsuarioJSON {

    private String  title,first, last, image, email, phone;

    public UsuarioJSON() {
    }

    public UsuarioJSON(String title, String first, String last, String image, String email, String phone) {
        this.title = title;
        this.first = first;
        this.last = last;
        this.image = image;
        this.email = email;
        this.phone = phone;
    }

    public void mostrarDatos(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s",title, first,last);
    }
}
