package edu.dosw.lab.Solid.Reto1;

public interface Descuento {

    double getPorcentajeDescuento();

    default double calcularDescuento(double subtotal) {
        return subtotal * getPorcentajeDescuento();
    }
}
