package edu.dosw.lab.comportamiento.reto4;

public class WeightConverter {
    public double convert(Weighing weighing, IConversionStrategy originStrategy, IConversionStrategy destinationStrategy){
        double baseKg = originStrategy.toBase(weighing.quantity());
        return destinationStrategy.fromBase(baseKg);
    }
}