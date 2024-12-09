package controller.ejercicios;

import java.util.Scanner;

public class Autos {
    String name_empleado;
    int autos_vendidos;
    double ventas_tota;
    double comision_total;
    double sueldo_mes = 2500.0;
    double porcentaje_comision = 0.05; 
    double porcentaje_utilidad = 0.05; 
    double sueldo;

    public void sueldoAutos() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("ingrese el valor del auto vendido, ingrese 0 para termianar de ingresar: $");
            double valorAuto = scanner.nextDouble();

            if (valorAuto == 0) {
                break;
            }

            autos_vendidos++;
            ventas_tota += valorAuto;
            comision_total += valorAuto * porcentaje_comision; // comisión por venta
        }
    }

    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del empleado: ");
        name_empleado = sc.nextLine();

        sueldoAutos(); 

        double utilidad_total = ventas_tota * porcentaje_utilidad;

        sueldo = sueldo_mes + comision_total;

        System.out.println("\nInforme de ventas y pagos:");
        System.out.println("Nombre del empleado: " + name_empleado);
        System.out.println("Número total de autos vendidos: " + autos_vendidos);
        System.out.println("Valor total de las ventas: $" + ventas_tota);
        System.out.println("Comisiones totales: $" + comision_total);
        System.out.println("Utilidad total: $" + utilidad_total);
        System.out.println("Sueldo total a pagar: $" + sueldo);
    }
}