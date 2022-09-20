import model.Coche;
import model.Gasolinera;
import model.Surtidor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Surtidor surtidor1 = new Surtidor(1000,"gasolina");
        Surtidor surtidor2 = new Surtidor(2000,"diesel");
        Surtidor surtidor3 = new Surtidor("super");

        Gasolinera gasolinera = new Gasolinera("BP");


        Coche coche = new Coche("gasolina");

    }
}
