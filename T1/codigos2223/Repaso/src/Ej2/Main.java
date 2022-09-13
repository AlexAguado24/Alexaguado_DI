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
            System.out.println("5. Buscar elemento");
            System.out.println("6. Sustituir elemento");
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
                case 5:
                    System.out.println("¿Que elemento quieres bucar?");
                    int elemento = scanner.nextInt();
                    for (int i = 0; i < numeros.length; i++) {
                        if (numeros[i] == elemento){
                            System.out.printf("Elemento %d encontrado en la posicion %d%n", elemento, i+1);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Indica el elemento que quieres sustituir");
                    int sustituto = scanner.nextInt();
                    for ( int item : numeros ) {
                        if (sustituto == item){
                            item = sustituto;
                        }
                    }
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        }while (opcion !=0);



    }
    public int[] rellenarArray(){
        int[] numerosAux = new int[50];
        for (int i = 0; i < numerosAux.length; i++) {
            numerosAux[i] = (int)(Math.random()*201);
        }
        return numerosAux;
    }
}
