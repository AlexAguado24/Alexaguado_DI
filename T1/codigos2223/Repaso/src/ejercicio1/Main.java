package ejercicio1;

import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nombre;
        Calendar calendario = Calendar.getInstance();
        String tipoSaludo;
        int horas, minutos,mes, dia, anio;
        String saludo = "%s %s son las %d:%d del %d del %s de %d";
        String opcion;
        System.out.println("introduce tu nombre");
        nombre = scanner.next();

        do {


            horas = calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);
            mes = calendario.get(Calendar.MONTH);
            anio = calendario.get(Calendar.YEAR);
            dia = calendario.get(Calendar.DAY_OF_MONTH);

            if (horas >= 6 && horas <= 12) {
                tipoSaludo = "Buenos dias";
            } else if (horas >= 13 && horas <= 20) {
                tipoSaludo = "Buenas tardes";
            } else {
                tipoSaludo = "Buenas noches";
            }

            

            System.out.println("quieres continuar?");
            opcion = scanner.next();
        } while (opcion.equalsIgnoreCase("s"));


       /* do {
            System.out.println("Por favor introduce tu nombre");
            nombre = scanner.next();

            if (today.get(Calendar.HOUR_OF_DAY < 12)){

                System.out.println("Buenos dias " + nombre + ", Son las " + horas + " del " + today.get((Calendar.DAY_OF_MONTH)) + " de " + today.get((Calendar.M)) + " del " + today.get((Calendar.YEAR)));
            }
            System.out.println("¿Quieres comprobar la hora otra vez?");
            opcion = scanner.next();

        } while (opcion.equalsIgnoreCase("s"));*/

        System.out.println("Que tengas un buen día");


    }
}
