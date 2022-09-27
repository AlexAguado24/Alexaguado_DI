import model.Coche;
import model.Gasolinera;
import model.Surtidor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Surtidor surtidor1 = new Surtidor(1000,"gasolina");
        Surtidor surtidor2 = new Surtidor(2000,"diesel");
        Surtidor surtidor3 = new Surtidor("gasolina");

        Gasolinera gasolinera = new Gasolinera("BP");
        gasolinera.añadirSurtidores(surtidor1);
        gasolinera.añadirSurtidores(surtidor2);
        gasolinera.añadirSurtidores(surtidor3);

        Coche coche = new Coche("gasolina");


        coche.ponerGasolina(surtidor1,500);

        System.out.println(surtidor1.getCapacidadActual());



    }
}
