package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Carta carta = new Carta();
        ArrayList<Carta> baraja = carta.crearBaraja();
        int opcion, posicion, cartasRobar, cartasDes;
        final int turno = 2, jugadores = 2;
        Scanner scanner = new Scanner(System.in);

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador = new Jugador();


        System.out.println("Empieza el Juego");
        jugador.repartiendoCartas(jugador1, jugador2, baraja);

        for (int i = 0; i < turno; i++) {

            for (int j = 0; j < jugadores; j++) {

                jugador.mostrarCartas();

                System.out.println();
                System.out.println("Turno " + (i + 1));
                System.out.println("Jugador " + (j + 1) );
                System.out.println();
                System.out.println("Elije una opcion:");
                System.out.println("1. Descartarte: entre 1 y 3 cartas");
                System.out.println("2. Robar: entre 1 y 3 cartas");
                System.out.println("3. Pasar");

                opcion = scanner.nextInt();

                switch (opcion) {

                    case 1: {

                        do {
                            System.out.println("Descartando: de 1 a 3");
                            opcion = scanner.nextInt();


                            if (opcion > 0 && opcion < 4) {
                                if (j == 0) {
                                    jugador1.mostrarCartas();
                                } else {
                                    jugador2.mostrarCartas();
                                }
                                System.out.println("¿De que posiciones te quieres descartar?");

                                for (int k = 0; k < opcion; k++) {
                                    if (j == 0) {
                                        System.out.println("Carta " + (k + 1));
                                        posicion = scanner.nextInt();

                                        jugador1.descartar(posicion, baraja.get(0));
                                        baraja.remove(0);
                                        jugador1.mostrarCartas();
                                    } else {

                                        System.out.println("Carta " + (k + 1));
                                        posicion = scanner.nextInt();

                                        jugador2.descartar(posicion, baraja.get(0));
                                        baraja.remove(0);
                                        jugador2.mostrarCartas();
                                    }


                                }
                                opcion = -1;
                            } else {
                                System.out.println("Cantidad de cartas incorrectas");
                            }

                        } while (opcion != -1);


                        break;
                    }
                    case 2: {


                        do {

                            System.out.println("Cartas a robar: de 1 a 3");
                            opcion = scanner.nextInt();
                            if (opcion > 0 && opcion < 4) {


                                if (j == 0) {
                                    jugador1.mostrarCartas();
                                } else {
                                    jugador2.mostrarCartas();
                                }
                                for (int k = 0; k < opcion; k++) {

                                    System.out.println("Carta " + (k + 1) + " para robar");
                                    cartasRobar = scanner.nextInt();
                                    int[] robadas = new int[]{cartasRobar};
                                    System.out.println("Carta " + (k + 1) + " para descartar");
                                    cartasDes = scanner.nextInt();
                                    int[] descartes = new int[]{cartasDes};

                                    if (j == 0) {

                                        Carta[] valorUno = new Carta[]{jugador2.getCartas().get(cartasRobar)};
                                        jugador1.recibirCartas(robadas, valorUno);
                                        jugador2.darCartas(robadas, valorUno);

                                        Carta[] valorDos = new Carta[]{jugador1.getCartas().get(cartasDes)};
                                        jugador2.recibirCartas(descartes, valorDos);
                                        jugador1.darCartas(descartes, valorDos);
                                        jugador1.mostrarCartas();
                                    } else {
                                        Carta[] valorUno = new Carta[]{jugador1.getCartas().get(cartasRobar)};
                                        jugador2.recibirCartas(robadas, valorUno);
                                        jugador1.darCartas(robadas, valorUno);

                                        Carta[] valorDos = new Carta[]{jugador2.getCartas().get(cartasDes)};
                                        jugador1.recibirCartas(descartes, valorDos);
                                        jugador2.darCartas(descartes, valorDos);
                                        jugador2.mostrarCartas();

                                    }

                                }
                                opcion = -1;
                            } else {
                                System.out.println("El numero introducido esta mal");
                            }

                        } while (opcion != -1);


                        break;
                    }
                    case 3: {
                        break;
                    }
                }
            }

        }
        jugador.ganador(jugador1, jugador2);
    }
}
