package edu.dosw.lab.Solid.reto1;

public class Estudiante extends Espectador {

    public Estudiante() {
        super("Estudiante");
    }

    @Override
    public double getPorcentajeDescuento() {
        return 0.15;
    }
}
