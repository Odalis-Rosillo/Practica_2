package controller.ejercicios;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Llamadas{

    enum Zona {
        AMERICADELNORTE(12, 2.75),
        AMERICACENTRAL(15, 1.89),
        AMERICADELSUR(18, 1.60),
        EUROPA(19, 3.5),
        ASIA(23, 4.5),
        AFRICA(25, 3.1),
        OCEANIA(29, 3.0),
        RESTODELMUNDO(31, 6.0);

        private final int clave;
        private final double precioMinuto;

        Zona(int clave, double precioMinuto) {
            this.clave = clave;
            this.precioMinuto = precioMinuto;
        }

        public double getPrecioMinuto() {
            return precioMinuto;
        }
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la clave de la zona: ");
        System.out.println("America del norte: clave 12");
        System.out.println("America central: clave 15");
        System.out.println("America del sur: clave 18");
        System.out.println("Europa: clave 19");
        System.out.println("Asia: clave 23");
        System.out.println("Africa: clave 25");
        System.out.println("Oceania: clave 29");
        System.out.println("Otros paises: clave 31");
        int claveZona = scanner.nextInt();
        System.out.print("Ingrese la duración de la llamada en minutos: ");
        int duracion = scanner.nextInt();

        Zona zona = obtenerZonaPorClave(claveZona);
        if (zona == null) {
            System.out.println("Zona no válida.");
        } else {
            double costoTotal = zona.getPrecioMinuto() * duracion;
            System.out.println("el costo total a pagara por la llamada es: " + costoTotal);
        }
    }

    private static Zona obtenerZonaPorClave(int clave) {
        for (Zona zona : Zona.values()) {
            if (zona.clave == clave) {
                return zona;
            }
        }
        return null;
    }
}

   