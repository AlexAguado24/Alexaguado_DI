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
        gasolinera.aniadirSurtidores(surtidor1);
        gasolinera.aniadirSurtidores(surtidor2);
        gasolinera.aniadirSurtidores(surtidor3);

        Coche coche = new Coche("gasolina");
        Coche coche2 = new Coche("gasolina");



        coche.ponerGasolina(surtidor1,600);
        coche.ponerGasolina(surtidor1,500);
        coche2.ponerGasolina(surtidor2, 200);

        System.out.println(coche.getLitrosDeposito());
        System.out.println(surtidor1.getCapacidadActual());



    }
}
