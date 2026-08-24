package edu.dosw.lab.comportamiento.reto7;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Reto7 {
    private Reto7() {
    }

    public static void main(String[] args) {
        ejecutar();
    }

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        CommandFactory factory = new CommandFactory();
        RoverControl control = new RoverControl();

        System.out.println("Rover Chibchombo");
        int amount = readInt(scanner, "Cuantas acciones desea ejecutar? ");

        for (int i = 1; i <= amount; i++) {
            System.out.println();
            System.out.println("Accion " + i + ":");
            RoverCommand command = readCommand(scanner, factory);
            System.out.println(control.execute(command));
        }

        System.out.println();
        int undoNumber = readInt(scanner, "Deshacer accion (0 para omitir): ");
        if (undoNumber > 0) {
            try {
                System.out.println(control.undo(undoNumber));
            } catch (RuntimeException exception) {
                System.out.println("No se pudo deshacer: " + exception.getMessage());
            }
        }

        printHistory(control);
    }

    private static RoverCommand readCommand(Scanner scanner, CommandFactory factory) {
        String operator = readText(scanner, "Operador: ");
        printModules();
        int moduleOption = readInt(scanner, "Modulo: ");
        printActions(moduleOption);
        int actionOption = readInt(scanner, "Accion: ");
        int parameter = readParameter(scanner, moduleOption, actionOption);
        return factory.create(operator, moduleOption, actionOption, parameter);
    }

    private static String readText(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String value = scanner.nextLine().trim();
        while (value.isBlank()) {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
        }
        return value;
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print(prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static void printModules() {
        System.out.println("Modulos disponibles:");
        System.out.println("  1. Motor");
        System.out.println("  2. Brazo");
        System.out.println("  3. Camara");
        System.out.println("  4. Taladro");
    }

    private static void printActions(int moduleOption) {
        System.out.println("Acciones disponibles:");
        switch (moduleOption) {
            case 1 -> {
                System.out.println("  1. Avanzar");
                System.out.println("  2. Retroceder");
            }
            case 2 -> {
                System.out.println("  1. Recoger");
                System.out.println("  2. Soltar");
            }
            case 3 -> {
                System.out.println("  1. Grabar");
                System.out.println("  2. Detener");
            }
            case 4 -> {
                System.out.println("  1. Perforar");
                System.out.println("  2. Retraer");
            }
            default -> System.out.println("  Modulo no soportado");
        }
    }

    private static int readParameter(Scanner scanner, int moduleOption, int actionOption) {
        if (moduleOption == 1) {
            return readInt(scanner, "Metros: ");
        }
        if (moduleOption == 3 && actionOption == 1) {
            return readInt(scanner, "Segundos (0-120): ");
        }
        if (moduleOption == 4 && actionOption == 1) {
            return readInt(scanner, "Profundidad en cm: ");
        }
        return 0;
    }

    private static void printHistory(RoverControl control) {
        System.out.println();
        System.out.println("--- Historial ---");
        IntStream.range(0, control.getHistory().size())
                .forEach(index -> printRecord(index + 1, control.getHistory().get(index)));
    }

    private static void printRecord(int number, CommandRecord record) {
        RoverCommand command = record.getCommand();
        String status = record.isUndone() ? "[DESHECHO] " : "";
        System.out.printf("#%d %s%s %s%s - %s%n",
                number,
                status,
                command.getModule(),
                command.getAction(),
                command.getParameterSummary(),
                command.getOperator());
    }
}
