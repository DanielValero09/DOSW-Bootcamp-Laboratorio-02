package edu.dosw.lab.estructurales.reto5;

public enum EnhancementCategory {
    ACCESSORY("Accesorio"),
    PAINT("Pintura"),
    COMPLEMENT("Complemento");

    private final String displayName;

    EnhancementCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
