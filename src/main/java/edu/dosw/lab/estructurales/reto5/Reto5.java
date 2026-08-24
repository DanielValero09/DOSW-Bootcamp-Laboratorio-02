package edu.dosw.lab.estructurales.reto5;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Reto5 {
    private Reto5() {
    }

    public static void main(String[] args) {
        ejecutar();
    }

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        EnhancementCatalog catalog = new EnhancementCatalog();
        Motorcycle baseMotorcycle = new Naked250();

        System.out.println("Taller Turbo Andes");
        System.out.println("Moto base: " + baseMotorcycle.getDescription() + " ("
                + MoneyFormatter.format(baseMotorcycle.getPrice()) + ")");
        System.out.println("Elige tus mejoras:");
        catalog.getEnhancements().forEach(Reto5::printEnhancementOption);

        System.out.print("Mejoras elegidas: ");
        List<Enhancement> selectedEnhancements = readSelectedEnhancements(scanner, catalog);

        MotorcycleOrder order = new MotorcycleOrder(baseMotorcycle, selectedEnhancements);
        Motorcycle customizedMotorcycle = order.buildCustomizedMotorcycle();

        printSummary(order, customizedMotorcycle);
        System.out.println("Buen viaje!");
    }

    private static void printEnhancementOption(Enhancement enhancement) {
        System.out.printf("  %2d. %-28s (+%s)%n",
                enhancement.option(),
                enhancement.displayName(),
                MoneyFormatter.format(enhancement.price()));
    }

    private static List<Enhancement> readSelectedEnhancements(Scanner scanner, EnhancementCatalog catalog) {
        String input = scanner.nextLine().trim();
        if (input.isBlank()) {
            return List.of();
        }

        Set<Integer> selectedOptions = Arrays.stream(input.split("[,\\s]+"))
                .filter(value -> !value.isBlank())
                .map(Integer::parseInt)
                .collect(LinkedHashSet::new, LinkedHashSet::add, LinkedHashSet::addAll);

        return selectedOptions.stream()
                .map(catalog::findByOption)
                .toList();
    }

    private static void printSummary(MotorcycleOrder order, Motorcycle customizedMotorcycle) {
        System.out.println();
        System.out.println("--- Tu Moto ---");
        System.out.println(customizedMotorcycle.getModelName());
        customizedMotorcycle.getEnhancements().forEach(enhancement ->
                System.out.println("  + " + enhancement.displayName()));
        System.out.println("Descripcion: " + customizedMotorcycle.getDescription());
        System.out.println("Precio base:  " + MoneyFormatter.format(order.getBasePrice()));
        System.out.println("Mejoras:      " + MoneyFormatter.format(order.getEnhancementsTotal()));
        System.out.println("Total:        " + MoneyFormatter.format(order.getTotal()));
    }
}
