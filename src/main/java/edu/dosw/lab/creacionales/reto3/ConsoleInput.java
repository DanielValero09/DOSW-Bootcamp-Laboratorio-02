package edu.dosw.lab.creacionales.reto3;

import java.util.Scanner;

public final class ConsoleInput {
    private ConsoleInput() {
    }

    public static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            try {
                int number = Integer.parseInt(value);
                if (number > 0) {
                    return number;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Ingrese un numero entero mayor que cero.");
        }
    }

    public static InstrumentFamily readFamily(Scanner scanner) {
        printOptions("Familias disponibles:", InstrumentFamily.values());
        return readEnum(scanner, "  Familia: ", InstrumentFamily.values());
    }

    public static InstrumentModel readModel(Scanner scanner, InstrumentFamily family) {
        InstrumentModel[] models = InstrumentModel.byFamily(family).toArray(InstrumentModel[]::new);
        printOptions("Modelos disponibles:", models);
        return readEnum(scanner, "  Modelo: ", models);
    }

    public static InstrumentGrade readGrade(Scanner scanner) {
        printOptions("Gamas disponibles:", InstrumentGrade.values());
        return readEnum(scanner, "  Gama: ", InstrumentGrade.values());
    }

    private static <T extends Enum<T>> T readEnum(Scanner scanner, String prompt, T[] values) {
        while (true) {
            System.out.print(prompt);
            String input = normalize(scanner.nextLine());

            for (int i = 0; i < values.length; i++) {
                if (input.equals(String.valueOf(i + 1)) || input.equals(normalize(displayName(values[i])))) {
                    return values[i];
                }
            }

            System.out.println("Opcion no valida. Escriba el numero o el nombre de la opcion.");
        }
    }

    private static <T extends Enum<T>> void printOptions(String title, T[] values) {
        System.out.println(title);
        for (int i = 0; i < values.length; i++) {
            System.out.printf("  %d. %s%n", i + 1, displayName(values[i]));
        }
    }

    private static <T extends Enum<T>> String displayName(T value) {
        if (value instanceof InstrumentFamily family) {
            return family.getDisplayName();
        }
        if (value instanceof InstrumentModel model) {
            return model.getDisplayName();
        }
        if (value instanceof InstrumentGrade grade) {
            return grade.getDisplayName();
        }
        return value.name();
    }

    private static String normalize(String value) {
        return value.trim().toLowerCase();
    }
}
