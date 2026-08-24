package edu.dosw.lab.creacionales.reto3;

import java.util.Arrays;
import java.util.List;

public enum InstrumentModel {
    GUITARRA("Guitarra", InstrumentFamily.CUERDA, 800000),
    VIOLIN("Violin", InstrumentFamily.CUERDA, 1600000),
    BAJO("Bajo", InstrumentFamily.CUERDA, 1200000),
    SAXOFON("Saxofon", InstrumentFamily.VIENTO, 2500000),
    FLAUTA("Flauta", InstrumentFamily.VIENTO, 700000),
    TROMPETA("Trompeta", InstrumentFamily.VIENTO, 1500000),
    BATERIA("Bateria", InstrumentFamily.PERCUSION, 1800000),
    CAJON("Cajon", InstrumentFamily.PERCUSION, 350000),
    TIMBAL("Timbal", InstrumentFamily.PERCUSION, 600000);

    private final String displayName;
    private final InstrumentFamily family;
    private final int basePrice;

    InstrumentModel(String displayName, InstrumentFamily family, int basePrice) {
        this.displayName = displayName;
        this.family = family;
        this.basePrice = basePrice;
    }

    public String getDisplayName() {
        return displayName;
    }

    public InstrumentFamily getFamily() {
        return family;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public static List<InstrumentModel> byFamily(InstrumentFamily family) {
        return Arrays.stream(values())
                .filter(model -> model.family == family)
                .toList();
    }
}
