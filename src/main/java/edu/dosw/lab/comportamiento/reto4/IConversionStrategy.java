package edu.dosw.lab.comportamiento.reto4;

public interface IConversionStrategy {
    double toBase(double quantity); // Convierte la unidad actual a Kilos
    double fromBase(double baseKg); // Convierte de Kilos a la unidad actual
}
