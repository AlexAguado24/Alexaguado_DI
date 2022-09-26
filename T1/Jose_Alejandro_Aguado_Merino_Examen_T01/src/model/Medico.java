package model;

import java.util.ArrayList;

public class Medico extends Persona{

    private String especialidad;
    private int numColegiado;

    public Medico() {}

    public Medico(String nombre, String apellido, String dni, String especialidad, int numColegiado) {
        super(nombre, apellido, dni);
        this.especialidad = especialidad;
        this.numColegiado = numColegiado;
    }


    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(especialidad);
        System.out.println(numColegiado);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(int numColegiado) {
        this.numColegiado = numColegiado;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "especialidad='" + especialidad + '\'' +
                ", numColegiado=" + numColegiado +
                '}';
    }
}
