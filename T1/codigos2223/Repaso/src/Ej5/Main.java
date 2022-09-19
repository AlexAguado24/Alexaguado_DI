package Ej5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numAleatorio = (int)(Math.random()*101);

        int intentos = 0, respuesta;
        int mediaInt = 0, minIntentos = 50;
        String respuesta2 = "";
        System.out.println("Indica el numero del sorteo");
        do {
            respuesta = scanner.nextInt();

            if (respuesta > numAleatorio){
                System.out.println("El numero mayor, intetalo otra vez");
            }
            if (respuesta < numAleatorio){
                System.out.println("El numero es menor, intentalo otra vez");
            }
            if (respuesta == numAleatorio){
                System.out.println("Enhorabuena, el numero era "+ numAleatorio);
                System.out.println("EL numero de intentos ha sido "+ intentos);
                System.out.println("Quieres volver a intentarlo?");
                respuesta2 = scanner.next();
                if (respuesta2.equalsIgnoreCase("s")){
                    numAleatorio = (int)(Math.random()*101);
                    System.out.println("Indica el numero");
                    respuesta2 = "";
                } else{
                    respuesta2 = "n";
                }
                intentos = 0;
            }
            intentos++;
        } while (!respuesta2.equalsIgnoreCase("n"));


    }

}
