package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Jugador {


    private ArrayList<Carta> cartas;
    private int puntos;
    private int turnos;

    public Jugador() {
        this.cartas = new ArrayList<>();
    }

    public Jugador(int puntos, int turnos) {
        this.puntos = puntos;
        this.turnos = turnos;
        this.cartas = new ArrayList<>();
    }

    public void obtenerCarta(Carta carta) {
        cartas.add(carta);
    }

    public void mostrarCartas() {
        Collections.sort(cartas, new Comparator<Carta>() {
            @Override
            public int compare(Carta o1, Carta o2) {
                if (o1.getValor() > o2.getValor()) return -1;
                else return 0;
            }
        });
        for (Carta carta : cartas) {
            carta.mostrarDatos();
        }
    }

    public void descartar(int[] posiciones, Carta[] cartasNuevas){
        for (int i = 0; i < posiciones.length; i++) {
            cartas.set(posiciones[i],cartasNuevas[i]);
        }
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "cartas=" + cartas +
                ", puntos=" + puntos +
                ", turnos=" + turnos +
                '}';
    }
}
