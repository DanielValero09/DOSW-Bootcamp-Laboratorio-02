package edu.dosw.lab.comportamiento.reto4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Reto4 {
    public record ConversionRequest(Weighing source, String targetUnit) {}

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        WeightConverter converter = new WeightConverter();

        // Integración de tus clases concretas (la arroba sigue anónima)
        Map<String, IConversionStrategy> strategies = new HashMap<>();
        strategies.put("lb", new PoundStrategy());
        strategies.put("kg", new KilogramStrategy());
        strategies.put("g", new GramStrategy());
        strategies.put("@", new IConversionStrategy() {
            public double toBase(double q) { return q / 0.08; }
            public double fromBase(double b) { return b * 0.08; }
        });

        System.out.println("Balanza Honesta del Mercado");
        System.out.print("¿Cuántos pesajes? ");
        int n = Integer.parseInt(scanner.nextLine());

        List<ConversionRequest> requests = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.print("P " + i + ": ");
            String[] input = scanner.nextLine().split(" ");

            // SOLUCIÓN: Quitamos el punto de miles antes de parsear a Double
            String rawQuantity = input[0].replace(".", "");
            double quantity = Double.parseDouble(rawQuantity);

            String sourceUnit = input[1];
            String targetUnit = input[3];

            requests.add(new ConversionRequest(new Weighing(quantity, sourceUnit), targetUnit));
        }

        System.out.println("\n--- RESULTADOS ---");

        for (int i = 0; i < requests.size(); i++) {
            ConversionRequest req = requests.get(i);
            IConversionStrategy origin = strategies.get(req.source().unit());
            IConversionStrategy dest = strategies.get(req.targetUnit());

            double result = converter.convert(req.source(), origin, dest);

            // %,.0f imprimirá automáticamente el punto de miles en la consola
            System.out.printf("P %d: %,.0f %s = %.3f %s\n",
                    (i + 1), req.source().quantity(), req.source().unit(), result, req.targetUnit());
        }

        double totalKg = requests.stream()
                .mapToDouble(req -> {
                    IConversionStrategy origin = strategies.get(req.source().unit());
                    return origin.toBase(req.source().quantity());
                })
                .sum();

        System.out.println("\n--- Resumen ---");
        System.out.printf("Total kg equivalente: %.3f kg\n", totalKg);
        System.out.println("¡Gracias por comprar en la plaza!");


    }
}