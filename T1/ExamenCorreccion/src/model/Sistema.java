package model;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Medico> listaMedicos;
    private ArrayList<Paciente> listaPaciente;

    public Sistema() {
        listaMedicos = new ArrayList<>();
        listaPaciente = new ArrayList<>();
        listaMedicos.add(new Medico("Nick", "Rivera", 001, 001, "traumatología"));
        listaMedicos.add(new Medico("Hannibal", "Lecter", 002, 002, "digestivo"));
        listaMedicos.add(new Medico("Sam", "Owens", 003, 003, "psiquiatría"));
        listaMedicos.add(new Medico("Martin", "Brenner", 004, 004, "general"));
        listaMedicos.add(new Medico("Stephen", "Strange", 005, 005, "cirugía"));

    }

    public void listarDatosPaciente(Integer nss) {
        boolean existe = false;

        for (Paciente item : listaPaciente) {
            if (item.getNumSS() == nss){
                System.out.println("El paciente ya estaba registrado");
                existe = true;
                break;
            }
        }
        if (!existe) {
            
        }
    }

    public void darAltaPaciente(Paciente paciente) {
        boolean existe = false;
        for (Paciente item : listaPaciente) {
            if (paciente.getNumSS() == item.getNumSS()) {
                System.out.println("Paciente ya registrado");
                existe = true;
                break;
            }
        }
        if (!existe) {
            listaPaciente.add(paciente);
        }
    }

    public void listarMedicos(String especialidad) {

        boolean encontrado = false;
        for (Medico item : listaMedicos) {
            if (item.getEspecialidad().equalsIgnoreCase(especialidad)) {
                item.mostrarDatos();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Especialidad sin medico disponible");
        }
    }
}
