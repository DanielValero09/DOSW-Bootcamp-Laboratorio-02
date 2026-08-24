package edu.dosw.lab.estructurales.reto5;

import java.util.List;

public class EnhancementCatalog {
    private static final List<Enhancement> ENHANCEMENTS = List.of(
            new Enhancement(1, EnhancementCategory.ACCESSORY, "Escape deportivo", "escape deportivo", 1_400_000L),
            new Enhancement(2, EnhancementCategory.ACCESSORY, "Manillar deportivo", "manillar deportivo", 480_000L),
            new Enhancement(3, EnhancementCategory.ACCESSORY, "Luces LED", "luces LED", 350_000L),
            new Enhancement(4, EnhancementCategory.ACCESSORY, "Alforjas laterales", "alforjas laterales", 600_000L),
            new Enhancement(5, EnhancementCategory.PAINT, "Pintura mate negro", "pintura mate negro", 900_000L),
            new Enhancement(6, EnhancementCategory.PAINT, "Pintura metalizado tricapa", "pintura metalizado tricapa", 1_600_000L),
            new Enhancement(7, EnhancementCategory.PAINT, "Vinilo personalizado", "vinilo personalizado", 700_000L),
            new Enhancement(8, EnhancementCategory.COMPLEMENT, "GPS integrado", "GPS integrado", 1_100_000L),
            new Enhancement(9, EnhancementCategory.COMPLEMENT, "Baul trasero", "baul trasero", 550_000L),
            new Enhancement(10, EnhancementCategory.COMPLEMENT, "Sistema de sonido", "sistema de sonido", 820_000L)
    );

    public List<Enhancement> getEnhancements() {
        return ENHANCEMENTS;
    }

    public Enhancement findByOption(int option) {
        return ENHANCEMENTS.stream()
                .filter(enhancement -> enhancement.option() == option)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("La mejora " + option + " no existe."));
    }
}
