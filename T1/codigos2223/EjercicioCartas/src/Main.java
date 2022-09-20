import model.Carta;
import model.Jugador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Carta> baraja = new Main().rellenarBaraja();

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                if (i==0) {
                    jugador1.obtenerCarta(baraja.get(0));
                } else {
                    jugador2.obtenerCarta(baraja.get(0));
                }
                baraja.remove(0);
            }
        }

        System.out.println("Cartas del jugador 1");
        jugador1.mostrarCartas();
        System.out.println();
        System.out.println("Cartas del jugador 2");
        jugador2.mostrarCartas();



    }

    public ArrayList<Carta> rellenarBaraja(){
        ArrayList<Carta> baraja = new ArrayList<>();
        String[] palo = new String[]{"D", "P", "T", "C"};
        for (char i = 0; i < palo.length; i++) {
            for (int j = 1; j < 14; j++) {
                baraja.add(new Carta(j, palo[i]));
            }
        }
        Collections.shuffle(baraja);
        return baraja;
    }


}
