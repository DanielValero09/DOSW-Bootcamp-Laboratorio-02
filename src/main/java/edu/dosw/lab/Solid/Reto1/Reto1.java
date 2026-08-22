package edu.dosw.lab.Solid.Reto1;

import java.util.Scanner;

public class Reto1 {

    private Reto1() {
    }

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al Cine Astor!");

        Espectador espectador = SelectorEspectador.solicitar(scanner);
        Orden orden = solicitarOrden(scanner, espectador);

        System.out.println();
        new Factura(espectador, orden).imprimir();
    }

    private static Orden solicitarOrden(Scanner scanner, Espectador espectador) {
        Orden orden = new Orden();

        System.out.println();
        System.out.println("Espectador: " + espectador.getNombreTipo());
        CatalogoCineAstor.imprimir();

        System.out.println("Ingrese su orden:");
        CatalogoCineAstor.getProductos()
                .forEach(producto -> solicitarProducto(scanner, orden, producto));

        return orden;
    }

    private static void solicitarProducto(Scanner scanner, Orden orden, Producto producto) {
        int cantidad = EntradaConsola.leerEnteroNoNegativo(
                scanner,
                "  " + producto.getNombre() + ": "
        );
        boolean fueAgregado = orden.agregarProducto(producto, cantidad);

        if (fueAgregado) {
            imprimirProductoAgregado(producto, cantidad);
        }
    }

    private static void imprimirProductoAgregado(Producto producto, int cantidad) {
        String unidad = cantidad == 1 ? "unidad" : "unidades";
        String plural = cantidad == 1 ? "" : "s";
        System.out.println(producto.getNombre() + ": " + cantidad + " " + unidad + " agregada" + plural + " a la orden.");
    }
}
