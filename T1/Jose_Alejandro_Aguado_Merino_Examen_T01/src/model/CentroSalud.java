package model;

import java.util.ArrayList;
import java.util.Scanner;

public class CentroSalud {

    Scanner scanner = new Scanner(System.in);
    private ArrayList<Medico> medicos;
    private ArrayList<Paciente> pacientes;

    public CentroSalud() {
        this.medicos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }

    public void registrarPaciente() {
        System.out.println("Indica el nombre del paciente");
        String nombre = scanner.next();
        System.out.println("Indica el apellido del paciente");
        String apellido = scanner.next();
        System.out.println("Indica el DNI del paciente");
        String dni = scanner.next();
        System.out.println("Indica el NSS del paciente");
        int numSS = scanner.nextInt();
        for (Paciente item : pacientes) {
            if (item.getNumSS() == numSS) {
                System.out.println("El paciente ya existe");
                break;
            } else {
                Paciente paciente = new Paciente(nombre, apellido, dni, numSS);
                pacientes.add(paciente);
            }
        }
    }

    public void registrarMedicos() {
        Medico medico1 = new Medico("Dr Nick", "Riviera", "001", "traumatologia", 001);
        Medico medico2 = new Medico("Dr Hannibal", "Lecter", "002", "digestivo", 002);
        Medico medico3 = new Medico("Dr Sam", "Owens", "003", "psiquiatria", 003);
        Medico medico4 = new Medico("Dr Martin", "Brenner", "004", "general", 004);
        Medico medico5 = new Medico("Dr Stephen", "Strange", "005", "cirugia", 005);
        medicos.add(medico1);
        medicos.add(medico2);
        medicos.add(medico3);
        medicos.add(medico4);
        medicos.add(medico5);
    }

    public void listarMedicos(String especialidad) {
        for (Medico item : medicos) {
            if (item.getEspecialidad().equalsIgnoreCase(especialidad)) {
                item.mostrarDatos();
            }
        }
    }

    public void pedirCita(int numSS, String especialidad, int numColegiado, String dia, String mes, String comentario){

    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "CentroSalud{" +
                "medicos=" + medicos +
                ", pacientes=" + pacientes +
                '}';
    }
}
