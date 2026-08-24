package edu.dosw.lab.creacionales.reto3;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Reto3 {
    private Reto3() {
    }

    public static void main(String[] args) {
        ejecutar();
    }

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        InstrumentFactoryProvider factoryProvider = new InstrumentFactoryProvider();
        InstrumentOrder order = new InstrumentOrder();

        System.out.println("Bienvenido a Armonia Andina");
        int amount = ConsoleInput.readPositiveInt(scanner, "Cuantos instrumentos desea pedir? ");

        for (int i = 1; i <= amount; i++) {
            System.out.println();
            System.out.println("Instrumento " + i + ":");
            InstrumentFamily family = ConsoleInput.readFamily(scanner);
            InstrumentModel model = ConsoleInput.readModel(scanner, family);
            InstrumentGrade grade = ConsoleInput.readGrade(scanner);
            InstrumentFactory factory = factoryProvider.getFactory(grade);
            order.add(factory.createInstrument(model));
        }

        System.out.println();
        printSummary(order);
        System.out.println("Gracias por su pedido!");
    }

    private static void printSummary(InstrumentOrder order) {
        IntStream.range(0, order.getInstruments().size())
                .forEach(index -> printInstrument(index + 1, order.getInstruments().get(index)));

        System.out.println("Total a pagar: " + MoneyFormatter.format(order.getTotal()));
    }

    private static void printInstrument(int index, Instrument instrument) {
        InstrumentModel model = instrument.getModel();
        InstrumentGrade grade = instrument.getGrade();

        System.out.printf("Instrumento %d: %s %s%n", index, model.getDisplayName(), grade.getDisplayName());
        System.out.println("  Familia: " + model.getFamily().getDisplayName());
        System.out.println("  Materiales: " + grade.getMaterials());
        System.out.println("  Afinacion: " + grade.getTuningHz() + " Hz");
        System.out.println("  Estuche: " + instrument.getCaseType());
        System.out.println("  Precio: " + MoneyFormatter.format(instrument.getPrice()));
        System.out.println();
    }
}
