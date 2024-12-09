package controller.ejercicios;

import java.util.Scanner;

public class AguaPotable {
    enum RangoConsumo {
        RANGO1(0, 15, 3.0),
        RANGO2(15, 25, 0.1),
        RANGO3(25, 40, 0.2),
        RANGO4(40, 60, 0.3),
        RANGO5(60, Double.MAX_VALUE, 0.35);

        private final double inicioRango;
        private final double finRango;
        private final double precio_metro_agua_consumido;

        RangoConsumo(double inicioRango, double finRango, double precioPorMetroCubico) {
            this.inicioRango = inicioRango;
            this.finRango = finRango;
            this.precio_metro_agua_consumido = precioPorMetroCubico;
        }

        public double calcularCosto(double consumo) {
            if (consumo >= inicioRango && consumo < finRango) {
                return precio_metro_agua_consumido * (consumo - inicioRango) + (inicioRango == 0 ? 3 : 0);
            }
            return 0;
        }
    }

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ingrese la cantidad de consumo de agua en m³: ");
        double consumo = scanner.nextDouble();

        System.out.print("si pertenece a la tercera edad ingresar s, caso contrario ingrese n: ");
        boolean esTerceraEdad = scanner.next().equalsIgnoreCase("s");

        System.out.print("si posee alguna discapacidad, ingrese el porcentaje, caso contrario ingrese 0: ");
        double porcentajeDiscapacidad = esTerceraEdad ? 0 : scanner.nextDouble();

        RangoConsumo rango = obtenerRango(consumo);
        double costoBase = rango.calcularCosto(consumo);

       
        double descuento = 0;
        if (esTerceraEdad && consumo <= 15) {
            descuento = costoBase * 0.5;
        } else if (esTerceraEdad) {
            descuento = rango.inicioRango * 0.3;
        } else if (porcentajeDiscapacidad > 0 && consumo <= 15) {
            descuento = costoBase * (porcentajeDiscapacidad / 100);
        }

       
        double impuestoAlcantarillado = costoBase * 0.35;
        double tasaBasura = 0.75;
        double tasaDatos = 0.5;

        
        double totalAPagar = costoBase - descuento + impuestoAlcantarillado + tasaBasura + tasaDatos;

        System.out.println("usted debe pagar un total de" + totalAPagar);
    }

    private static RangoConsumo obtenerRango(double consumo) {
        for (RangoConsumo rango : RangoConsumo.values()) {
            if (consumo >= rango.inicioRango && consumo < rango.finRango) {
                return rango;
            }
        }
        return null;
    }
}


