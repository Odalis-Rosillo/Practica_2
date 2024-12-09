package controller.ejercicios;

import java.util.Scanner;
public class Serie {
    public static class SerieFibonacci {
        private int fibonacci(int n) {
            if (n <= 1) {
                return n;
            }
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

        private int generarImpar(int n) {
            return 2 * n - 1;
        }

        public void ejecutar() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el número de términos en la serie: ");
            int numSerie = sc.nextInt();

            String serie = "";
            double suma = 0.0;
            boolean signoPositivo = true;

            for (int i = 0; i <= numSerie; i++) {
                int numerador = fibonacci(i);
                int denominador = generarImpar(i);
                int exponente = 2 * i;

                double termino = Math.pow((double) numerador / denominador, exponente);
                if (!signoPositivo) {
                    termino *= -1;
                }

                serie += (signoPositivo ? "+" : "-") + " (" + numerador + "/" + denominador + ")^" + exponente + " ";
                suma += termino;
                signoPositivo = !signoPositivo;
            }

            System.out.println("La serie es: " + serie);
            System.out.println("La suma de la serie es: " + suma);
        }
    }

    public static void main(String[] args) {
        SerieFibonacci serieFibonacci = new SerieFibonacci();
        serieFibonacci.ejecutar();
    }


    }


