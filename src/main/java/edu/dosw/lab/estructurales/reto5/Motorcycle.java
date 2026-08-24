package edu.dosw.lab.estructurales.reto5;

import java.util.List;

public interface Motorcycle {
    String getModelName();

    String getDescription();

    long getPrice();

    List<Enhancement> getEnhancements();
}
