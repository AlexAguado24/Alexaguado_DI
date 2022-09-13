package Ej2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numeros = null;
        int opcion = 0;

        do {
            System.out.println("1. rellenar array");
            System.out.println("2. listar array");
            System.out.println("3. ordenar array");
            System.out.println("4. vaciar array");
            System.out.println("¿que opcion quieres? ");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    if (numeros!=null){
                        System.out.println("El array ya esta relleno, quieres rellenarlo otra vez");
                        String respuesta = scanner.next();
                        if (respuesta.equalsIgnoreCase("s")){
                            numeros = new Main().rellenarArray();
                        }
                    }  else {
                        numeros = new Main().rellenarArray();
                    }
                    break;
                case 2:
                    for (int i = 0; i < numeros.length; i++) {
                        System.out.printf("Elemento %d: %d%n", i+1, numeros[i]);
                    }
                    break;
                case 3:
                    Arrays.sort(numeros);
                    System.out.println("ordenacion completa");
                    break;
                case 4:
                    numeros = null;
                    System.out.println("vaciado completo");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        }while (opcion !=5);



    }
    public int[] rellenarArray(){
        int[] numerosAux = new int[50];
        for (int i = 0; i < numerosAux.length; i++) {
            numerosAux[i] = (int)(Math.random()*201);
        }
        return numerosAux;
    }
}
