package edu.dosw.lab.Solid.reto1;

public interface Descuento {

    double getPorcentajeDescuento();

    default double calcularDescuento(double subtotal) {
        return subtotal * getPorcentajeDescuento();
    }
}
