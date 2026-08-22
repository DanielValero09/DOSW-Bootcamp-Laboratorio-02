package edu.dosw.lab.Solid.Reto1;

public class Factura {

    private final Espectador espectador;
    private final Orden orden;

    public Factura(Espectador espectador, Orden orden) {
        this.espectador = espectador;
        this.orden = orden;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public Orden getOrden() {
        return orden;
    }

    public void imprimir() {
        double subtotal = orden.calcularSubtotal();
        double descuento = espectador.calcularDescuento(subtotal);
        double total = subtotal - descuento;

        System.out.println("------ FACTURA DE TAQUILLA -----");
        System.out.println("Espectador: " + espectador.getNombreTipo());
        System.out.println("Items:");
        orden.getItems().forEach(item -> System.out.println(
                "  " + item.getProducto().getNombre() + " - " + formatearMoneda(item.calcularTotal())
        ));
        System.out.println("Subtotal: " + formatearMoneda(subtotal));
        System.out.println("Descuento (" + formatearPorcentajeDescuento() + "): " + formatearMoneda(descuento));
        System.out.println("Total a pagar: " + formatearMoneda(total));
        System.out.println("--------------------------------");
        System.out.println("Disfrute la funcion!");
    }

    public static String formatearMoneda(double valor) {
        int valorEntero = (int) Math.round(valor);
        String numero = String.valueOf(valorEntero);
        String resultado = "";
        int contador = 0;

        for (int i = numero.length() - 1; i >= 0; i--) {
            resultado = numero.charAt(i) + resultado;
            contador++;

            if (contador == 3 && i > 0) {
                resultado = "." + resultado;
                contador = 0;
            }
        }

        return "$" + resultado;
    }

    private String formatearPorcentajeDescuento() {
        int porcentaje = (int) Math.round(espectador.getPorcentajeDescuento() * 100);
        return porcentaje + "%";
    }
}
