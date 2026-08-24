package edu.dosw.lab.creacionales.reto3;

public enum InstrumentGrade {
    ESTUDIANTE("Estudiante", 1.0, "materiales basicos", 440),
    PROFESIONAL("Profesional", 3.0, "maderas selectas", 440),
    VINTAGE("Vintage", 5.0, "piezas de epoca", 442);

    private final String displayName;
    private final double priceFactor;
    private final String materials;
    private final int tuningHz;

    InstrumentGrade(String displayName, double priceFactor, String materials, int tuningHz) {
        this.displayName = displayName;
        this.priceFactor = priceFactor;
        this.materials = materials;
        this.tuningHz = tuningHz;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getPriceFactor() {
        return priceFactor;
    }

    public String getMaterials() {
        return materials;
    }

    public int getTuningHz() {
        return tuningHz;
    }
}
