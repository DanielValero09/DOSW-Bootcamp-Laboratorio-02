package edu.dosw.lab.Solid.reto1;

import java.util.Scanner;

public final class EntradaConsola {

    private EntradaConsola() {
    }

    public static int leerEnteroNoNegativo(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        String entrada = scanner.nextLine().trim();

        try {
            int numero = Integer.parseInt(entrada);
            if (numero < 0) {
                System.out.println("Cantidad negativa. Se tomara como 0.");
                return 0;
            }
            return numero;
        } catch (NumberFormatException exception) {
            System.out.println("Entrada invalida. Se tomara como 0.");
            return 0;
        }
    }
}
