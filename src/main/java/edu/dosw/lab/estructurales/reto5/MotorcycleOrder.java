package edu.dosw.lab.estructurales.reto5;

import java.util.List;

public class MotorcycleOrder {
    private final Motorcycle baseMotorcycle;
    private final List<Enhancement> selectedEnhancements;

    public MotorcycleOrder(Motorcycle baseMotorcycle, List<Enhancement> selectedEnhancements) {
        this.baseMotorcycle = baseMotorcycle;
        this.selectedEnhancements = List.copyOf(selectedEnhancements);
    }

    public Motorcycle buildCustomizedMotorcycle() {
        Motorcycle customizedMotorcycle = baseMotorcycle;
        for (Enhancement enhancement : selectedEnhancements) {
            customizedMotorcycle = new EnhancementDecorator(customizedMotorcycle, enhancement);
        }
        return customizedMotorcycle;
    }

    public long getBasePrice() {
        return baseMotorcycle.getPrice();
    }

    public long getEnhancementsTotal() {
        return selectedEnhancements.stream()
                .mapToLong(Enhancement::price)
                .sum();
    }

    public long getTotal() {
        return getBasePrice() + getEnhancementsTotal();
    }
}
