import model.Coche;

public class Main {

    public static void main(String[] args) {

        Coche coche1 = new Coche("Ford","Focus",1234);
        Coche coche2 = new Coche("Ford","Fiesta",2345);
        Coche coche3 = new Coche("Ford","Fiesta");

        coche1.acelerar(10);
        coche1.acelerar(50);

        coche2.acelerar(20);

        coche1.frenar();

        coche2.frenar();

        coche3.frenar();
    }
}
