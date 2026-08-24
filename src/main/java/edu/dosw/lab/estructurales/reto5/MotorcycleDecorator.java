package edu.dosw.lab.estructurales.reto5;

public abstract class MotorcycleDecorator implements Motorcycle {
    protected final Motorcycle motorcycle;

    protected MotorcycleDecorator(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
    }
}
