package edu.dosw.lab.estructurales.reto5;

import java.util.List;

public class Naked250 implements Motorcycle {
    public static final long BASE_PRICE = 9_800_000L;

    @Override
    public String getModelName() {
        return "Naked 250";
    }

    @Override
    public String getDescription() {
        return getModelName();
    }

    @Override
    public long getPrice() {
        return BASE_PRICE;
    }

    @Override
    public List<Enhancement> getEnhancements() {
        return List.of();
    }
}
