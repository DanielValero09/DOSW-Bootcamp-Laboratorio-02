package edu.dosw.lab.Solid.Reto1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orden {

    private final List<ItemOrden> items;

    public Orden() {
        this.items = new ArrayList<>();
    }

    public List<ItemOrden> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean agregarProducto(Producto producto, int cantidad) {
        if (cantidad <= 0) {
            return false;
        }

        items.add(new ItemOrden(producto, cantidad));
        return true;
    }

    public void agregarItem(Producto producto, int cantidad) {
        agregarProducto(producto, cantidad);
    }

    public double calcularSubtotal() {
        return items.stream()
                .filter(item -> item.getCantidad() > 0)
                .map(ItemOrden::calcularTotal)
                .reduce(0.0, Double::sum);
    }
}
