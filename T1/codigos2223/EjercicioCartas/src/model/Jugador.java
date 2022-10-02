package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Jugador {
    //1) Atributos
    private ArrayList<Carta> cartas;
    private int conteo = 0;
    private int valor2 = 0;
    public Jugador() {
        this.cartas = new ArrayList<>();
    }

    public void mostrarCartas() {
        ordenarNumero();
        for (int i = 0; i < cartas.size(); i++) {
            System.out.print( i + " = " + cartas.get(i).getValor() + cartas.get(i).getPalo() + ", ");
        }
        System.out.println();
    }
    public void ordenarNumero() {
        Collections.sort(cartas, new Comparator<Carta>() {
            @Override
            public int compare(Carta o1, Carta o2) {
                if (o1.getValor() > o2.getValor()) return -1;
                else return 0;
            }
        });
    }
    public void ordenarPalo() {
        Collections.sort(cartas, new Comparator<Carta>() {
            @Override
            public int compare(Carta o1, Carta o2) {
                if (o1.getPalo() > o2.getPalo()) return -1;
                else return 0;
            }
        });
    }
    public void ordenDePaloYNumero() {
        ordenarNumero();
        ordenarPalo();
        mostrarCartasP();
    }
    public void mostrarCartasP() {
        for (Carta carta : cartas) {
            carta.mostrarDatos();
        }

    }
    public int contarPuntos() {
        ordenarNumero();
        ordenarPalo();
        for (int i = 0; i < cartas.size(); i++) {
            for (int j = i + 1; j < cartas.size(); j++) {
                if (((cartas.get(i).getValor() - 1) == (cartas.get(j).getValor())) && (cartas.get(i).getPalo() == cartas.get(j).getPalo())) {
                    conteo = conteo + 1;
                }

            }
        }
        return conteo;
    }
    public void descartar(int posiciones, Carta cartasNuevas) {
        cartas.set(posiciones, cartasNuevas);
    }
    public void recibirCartas(int[] posiciones, Carta[] valores) {
        for (int i = 0; i < posiciones.length; i++) {
            cartas.add(valores[i]);
        }
    }
    public void darCartas(int[] posiciones, Carta[] cartasNuevas) {
        for (int i = 0; i < posiciones.length; i++) {
            cartas.remove(cartasNuevas[i]);
        }
    }
    public void obtenerCarta(Carta carta) {
        cartas.add(carta);
    }
    public void repartiendoCartas(Jugador jugador1, Jugador jugador2, ArrayList<Carta> baraja) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0) {
                    // J1
                    jugador1.obtenerCarta(baraja.get(0));
                } else {
                    // J2
                    jugador2.obtenerCarta(baraja.get(0));
                }
                baraja.remove(0);
            }
        }
    }


    public void ganador(Jugador jugador1, Jugador jugador2) {

        System.out.println("Cartas jugador 1:");
        jugador1.ordenDePaloYNumero();
        System.out.println("");
        System.out.println("Cartas jugador 2:");
        jugador2.ordenDePaloYNumero();
        System.out.println("\n");

        if (jugador1.contarPuntos() > jugador2.contarPuntos()) {
            System.out.println("Gana el Jugador 1 - Sus puntos son " + jugador1.contarPuntos());
            System.out.println("Los puntos del Jugador 1 son " + jugador2.contarPuntos());
        } else if (jugador1.contarPuntos() < jugador2.contarPuntos()) {
            System.out.println("Gana el Jugador 2 - Sus puntos son " + jugador2.contarPuntos());
            System.out.println("Los puntos del Jugador 1 son " + jugador1.contarPuntos());
        } else {
            System.out.println("Empate");
        }
    }


    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public int getConta() {
        return conteo;
    }

    public void setConta(int conta) {
        this.conteo = conteo;
    }

    public int getValor2() {
        return valor2;
    }

    public void setValor2(int valor2) {
        this.valor2 = valor2;
    }
}