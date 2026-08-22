package edu.dosw.lab.Solid.Reto1;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class CatalogoCineAstor {

    private static final Map<String, Producto> PRODUCTOS = crearProductos();

    private CatalogoCineAstor() {
    }

    public static Collection<Producto> getProductos() {
        return Collections.unmodifiableCollection(PRODUCTOS.values());
    }

    public static void imprimir() {
        System.out.println("Cartelera y precios:");
        PRODUCTOS.values().forEach(producto -> System.out.println(
                "  " + producto.getNombre() + " - " + Factura.formatearMoneda(producto.getPrecio())
        ));
    }

    private static Map<String, Producto> crearProductos() {
        Map<String, Producto> productos = new LinkedHashMap<>();
        productos.put("boleta2d", new Producto("Boleta 2D", 14000));
        productos.put("boleta3d", new Producto("Boleta 3D", 22000));
        productos.put("crispetas", new Producto("Crispetas", 9000));
        productos.put("gaseosa", new Producto("Gaseosa", 4500));
        return productos;
    }
}
