package model;

import java.util.ArrayList;

public class Paciente extends Persona{

    private int numSS = 0;

    public Paciente() {}

    public Paciente(String nombre, String apellido, String dni, int numSS) {
        super(nombre, apellido, dni);
        this.numSS = numSS;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(numSS);
    }



    public int getNumSS() {
        return numSS;
    }

    public void setNumSS(int numSS) {
        this.numSS = numSS;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "numSS=" + numSS +
                '}';
    }
}
