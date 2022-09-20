import model.Persona;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Persona> grupo = new ArrayList<>();

        System.out.println("Nombre");
        String nombre = scanner.next();
        System.out.println("Edad");
        int edad = scanner.nextInt();
        System.out.println("Sexo");
        String sexo = scanner.next();
        System.out.println("Peso");
        double peso = scanner.nextDouble();
        System.out.println("Altura");
        double altura = scanner.nextDouble();

        Persona persona1 = new Persona(nombre, edad, sexo, peso, altura);
        Persona persona2 = new Persona(nombre, edad, sexo);
        Persona persona3 = new Persona();

        persona3.setNombre("Alex");
        persona3.setEdad(27);
        persona3.setSexo("H");
        persona3.setPeso(75.5);
        persona3.setAltura(1.83);

        grupo.add(persona1);
        grupo.add(persona2);
        grupo.add(persona3);

        for (Persona persona : grupo) {
            if (persona.calcularIMC() == -1){
                System.out.println("Estas por debajo del peso ideal");
            } else if (persona.calcularIMC() == 0){
                System.out.println("Estas en el peso ideal");
            } else {
                System.out.println("Estas en sobrepeso ");
            }
            persona.mostrarDatos();
        }
    }
}
