package edu.dosw.lab.estructurales.reto5;

public record Enhancement(
        int option,
        EnhancementCategory category,
        String displayName,
        String sentenceName,
        long price
) {
}
