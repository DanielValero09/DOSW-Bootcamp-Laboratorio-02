package edu.dosw.lab.Solid.Reto1;

public abstract class Espectador implements Descuento {

    private String nombreTipo;

    protected Espectador(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}
