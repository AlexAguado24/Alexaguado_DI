package model;

import java.util.ArrayList;

public final class Medico extends Persona {

    private int numColegiado;
    private String especialidad;

    //las citas son dia y mes --> 910
    private ArrayList<Integer> citas;

    public Medico() {
    }

    public Medico(String nombre, String apellido, int dni, int numColegiado, String especialidad) {
        super(nombre, apellido, dni);
        this.numColegiado = numColegiado;
        this.especialidad = especialidad;
        this.citas = new ArrayList<>();
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(numColegiado);
        System.out.println(especialidad);
        System.out.println(citas);
        if (!citas.isEmpty()) {
            for (Integer item : citas) {
                System.out.println(item);
            }
        }
    }

    public int getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(int numColegiado) {
        this.numColegiado = numColegiado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Integer> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Integer> citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "numColegiado=" + numColegiado +
                ", especialidad='" + especialidad + '\'' +
                ", citas=" + citas +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                '}';
    }
}
