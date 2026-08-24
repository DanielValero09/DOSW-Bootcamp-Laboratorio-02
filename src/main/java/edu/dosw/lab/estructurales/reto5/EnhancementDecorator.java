package edu.dosw.lab.estructurales.reto5;

import java.util.ArrayList;
import java.util.List;

public class EnhancementDecorator extends MotorcycleDecorator {
    private final Enhancement enhancement;

    public EnhancementDecorator(Motorcycle motorcycle, Enhancement enhancement) {
        super(motorcycle);
        this.enhancement = enhancement;
    }

    @Override
    public String getModelName() {
        return motorcycle.getModelName();
    }

    @Override
    public String getDescription() {
        return getModelName() + " con " + formatEnhancementsForSentence();
    }

    @Override
    public long getPrice() {
        return motorcycle.getPrice() + enhancement.price();
    }

    @Override
    public List<Enhancement> getEnhancements() {
        List<Enhancement> enhancements = new ArrayList<>(motorcycle.getEnhancements());
        enhancements.add(enhancement);
        return List.copyOf(enhancements);
    }

    private String formatEnhancementsForSentence() {
        List<String> names = getEnhancements().stream()
                .map(Enhancement::sentenceName)
                .toList();

        if (names.size() == 1) {
            return names.get(0);
        }

        String lastName = names.get(names.size() - 1);
        return String.join(", ", names.subList(0, names.size() - 1)) + " y " + lastName;
    }
}
