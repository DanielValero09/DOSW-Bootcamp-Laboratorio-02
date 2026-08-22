package edu.dosw.lab.Solid.Reto1;

public class ItemOrden {

    private Producto producto;
    private int cantidad;

    public ItemOrden(Producto producto, int cantidad) {
        this.producto = producto;
        setCantidad(cantidad);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
        this.cantidad = cantidad;
    }

    public double calcularTotal() {
        return producto.getPrecio() * cantidad;
    }
}
