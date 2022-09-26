package model;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        CentroSalud centroSalud = new CentroSalud();
        centroSalud.registrarMedicos();

        do {
            System.out.println("Elige la opcion que deseas");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Pedir cita");
            System.out.println("3. Listar medicos disponibles");
            System.out.println("4. Listar citas de un paciente");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    centroSalud.registrarPaciente();
                    break;
                case 2:
                    if (centroSalud.getPacientes() == null){
                        System.out.println("Aun no hay pacientes en el sistema");
                    } else {
                        System.out.println("Indica el NSS del paciente");
                        System.out.println("Indica la especialidad");
                        System.out.println("Indica el Numero de colegiado");
                        System.out.println("Indica el NSS del paciente");
                        int numSS = scanner.nextInt();

                    }
                    break;
                case 3:
                    System.out.println("Indica la especialidad del medico");
                    String especialidad = scanner.next();
                    centroSalud.listarMedicos(especialidad);
                    break;
                case 4:
                    break;
            }
        } while (opcion != 0);
    }
}
