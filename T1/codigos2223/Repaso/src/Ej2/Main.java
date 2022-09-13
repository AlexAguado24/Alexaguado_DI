package Ej2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numeros = null;
        int opcion = 0;
        int posicion;

        do {
            System.out.println("1. rellenar array");
            System.out.println("2. listar array");
            System.out.println("3. ordenar array");
            System.out.println("4. vaciar array");
            System.out.println("5. Buscar elemento");
            System.out.println("6. Sustituir elemento");
            System.out.println("7. Maximo y minimo");
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
                    if (new Main().isVacioArray(numeros)){
                        System.out.println("Array nulo, no se puede ejecutar");
                    } else {
                        for (int i = 0; i < numeros.length; i++) {
                            System.out.printf("Elemento %d: %d%n", i + 1, numeros[i]);
                        }
                    }
                    break;
                case 3:
                    if (new Main().isVacioArray(numeros)){
                        System.out.println("Array nulo, no se puede ejecutar");
                    } else {
                        Arrays.sort(numeros);
                        System.out.println("ordenacion completa");
                    }

                    break;
                case 4:
                    numeros = null;
                    System.out.println("vaciado completo");
                    break;
                case 5:
                    if (new Main().isVacioArray(numeros)){
                        System.out.println("El array esta vacio");
                    } else {
                        System.out.println("¿Que elemento quieres bucar?");
                        int elemento = scanner.nextInt();
                        /*for (int i = 0; i < numeros.length; i++) {
                            if (numeros[i] == elemento) {
                                System.out.printf("Elemento %d encontrado en la posicion %d%n", elemento, i + 1);
                                break;
                            }
                        }*/
                        posicion = 0;
                        for (int item : numeros ) {
                            if (item == elemento){
                                System.out.println("numero en la posicion "+elemento);
                                break;
                            }
                        }
                        posicion++;
                    }
                    break;
                case 6:
                    int numerosSustituidos = 0;
                    if (new Main().isVacioArray(numeros)) {
                        System.out.println("El array esta vacio");
                    } else {

                    /*System.out.println("Indica el elemento que quieres sustituir");
                    int numero = scanner.nextInt();
                    System.out.println("¿Por que numero quieres sustituirlo?");
                    int sustituto = scanner.nextInt();

                    for (int i = 0; i < numeros.length; i++) {
                        if (numeros[i] == numero){
                            numeros[i] = sustituto;
                            numerosSustituidos++;
                        }
                    }*/
                    }
                    break;
                case 7:
                    if (new Main().isVacioArray(numeros)){
                        System.out.println("Array nulo, no se puede ejecutar");
                    } else {
                        /*int max = -99999;
                        int min = 99999;

                        for (int i = 0; i < numeros.length ; i++) {
                            if (numeros[i] < min){
                                min = numeros[i];
                            }
                            if (numeros[i] > max){
                                max = numeros[i];
                            }
                        }
                        System.out.printf("El numero mas alto es %d y el mas bajo es %d%n", max,min);*/
                        int[] cloneNumeros = numeros.clone();
                        Arrays.sort(cloneNumeros);
                        int max = cloneNumeros[cloneNumeros.length-1];
                        int min = cloneNumeros[0];
                        System.out.println("Max = "+max);
                        System.out.println("Min = "+min);
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
    public boolean isVacioArray (int[] arrayNumeros){
        return arrayNumeros == null;
    }
   /* public Object pregunta (boolean dato){
        //int sustituto = scanner.nextInt();
        //int elemento = scanner.nextInt();
        if (dato){
            for (int i = 0; i < numeros.length; i++) {
                if (numeros[i] == elemento){
                    System.out.printf("Elemento %d encontrado en la posicion %d%n", elemento, i+1);
                }
            }

        }
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == elemento){
                System.out.printf("Elemento %d encontrado en la posicion %d%n", elemento, i+1);
                if (!dato){
                    break;
                } else {
                    if (numeros[i] == numero){
                        numeros[i] = sustituto;
                }


            }
        }

    }*/
}
