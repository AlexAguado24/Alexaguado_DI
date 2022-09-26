package model;

import java.util.ArrayList;

public final class Paciente extends Persona {

    private int numSS;

    //las citas tienen --> Medico, dia, mes , comentario
    private ArrayList<Cita> citas;

    public Paciente(String nombre, String apellido, int dni, int numSS, ArrayList citas) {
        super(nombre, apellido, dni);
        this.numSS = numSS;
        this.citas = citas;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(numSS);
        for (Cita item : citas) {
            System.out.println(item.toString());
        }
    }

    public int getNumSS() {
        return numSS;
    }

    public void setNumSS(int numSS) {
        this.numSS = numSS;
    }

    public ArrayList getCitas() {
        return citas;
    }

    public void setCitas(ArrayList citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "numSS=" + numSS +
                ", citas=" + citas +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }
}
