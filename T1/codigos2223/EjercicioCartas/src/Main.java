import model.Carta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {


        ArrayList<Carta> baraja = new ArrayList<>();



        Collections.shuffle(baraja);

        for (Carta carta : baraja) {
            carta.mostrarDatos();
        }
    }
}
