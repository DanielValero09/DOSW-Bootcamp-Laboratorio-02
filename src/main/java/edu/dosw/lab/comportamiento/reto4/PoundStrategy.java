package edu.dosw.lab.comportamiento.reto4;

public class PoundStrategy implements IConversionStrategy{
    public double toBase(double quantity){return quantity / 2.2046;}
    public double fromBase(double baseKg){return baseKg * 2.2046;}
}
