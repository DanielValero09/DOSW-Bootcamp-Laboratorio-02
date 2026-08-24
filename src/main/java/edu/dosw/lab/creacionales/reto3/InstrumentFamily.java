package edu.dosw.lab.creacionales.reto3;

public enum InstrumentFamily {
    CUERDA("Cuerda"),
    VIENTO("Viento"),
    PERCUSION("Percusion");

    private final String displayName;

    InstrumentFamily(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
