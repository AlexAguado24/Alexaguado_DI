package model;

import java.util.ArrayList;
import java.util.Collections;

public class Carta {

    private char palo;
    private int valor;

    public Carta(int valor, char palo) {
        this.valor = valor;
        this.palo = palo;
    }
    public Carta() {}
    public void mostrarDatos() {
        System.out.print(getValor() + "" + getPalo());
    }
    public ArrayList<Carta> crearBaraja() {
        ArrayList<Carta> baraja = new ArrayList<>();
        char[] palos = new char[]{'O', 'B', 'E', 'C'};
        for (int i = 0; i < palos.length; i++) {
            for (int j = 1; j < 14; j++) {
                baraja.add(new Carta(j, palos[i]));
            }
        }
        Collections.shuffle(baraja);
        return baraja;
    }
    public char getPalo() {
        return palo;
    }

    public void setPalo(char palo) {
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}

