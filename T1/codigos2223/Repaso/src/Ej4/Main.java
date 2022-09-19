package Ej4;

import java.sql.Array;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int respuesta;

        System.out.println("Indica la longitud del array");
        respuesta = scanner.nextInt();

        int[] enteros = new int[respuesta];

        for (int i = 0; i < enteros.length; i++) {
            enteros[i] = (int) (Math.random() * 51);
        }

        for (int numero : enteros) {
            System.out.printf("%d - ", numero);
        }

        System.out.println();

        int pares = 0, impares = 0;
        for (int numero : enteros) {
            if (numero % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }
        System.out.printf("Hay %d pares y %d impares%n", pares, impares);


        int max = -1, min = 51, suma = 0;

        for (int num : enteros) {
            if (num > max){
                max = num;
            }
            if (num < min) {
                min = num;
            }
            suma += num;
        }

        System.out.println("Max ="+max);
        System.out.println("Min ="+min);
        System.out.println("Suma ="+suma);
        System.out.println("Media ="+suma/respuesta);

    }
}
