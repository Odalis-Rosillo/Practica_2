package views;

import controller.ejercicios.AguaPotable;
import controller.ejercicios.Autos;
import controller.ejercicios.Llamadas;
import controller.ejercicios.Serie;
import controller.ejercicios.Serie.SerieFibonacci;

public class MainPractica {
    public static void main(String[] args) {
        Autos a = new Autos();
        a.ejecutar();
        Llamadas la = new Llamadas();
        la.ejecutar();
        AguaPotable ap = new AguaPotable();
        ap.ejecutar();
        SerieFibonacci s = new SerieFibonacci();
        s.ejecutar();
    }
}
