package edu.dosw.lab.comportamiento.reto4;

public class GramStrategy implements IConversionStrategy{
    public double toBase(double q) { return q / 1000.0; }
    public double fromBase(double b) { return b * 1000.0; }
}
