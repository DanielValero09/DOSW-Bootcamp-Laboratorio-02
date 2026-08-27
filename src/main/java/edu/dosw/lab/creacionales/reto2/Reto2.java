package edu.dosw.lab.creacionales.reto2;

import java.util.Scanner;

public class Reto2 {
    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        // Inyectamos nuestro Builder concreto al Director
        Tailor tailor = new Tailor(new SuitBuilder());

        System.out.println("Bienvenido al Taller del Sastre");
        System.out.println("Arma tu traje:");

        System.out.print("¿Tela? -> ");
        String cloth = scanner.nextLine().toLowerCase().trim();

        System.out.print("¿Saco? -> ");
        String coat = scanner.nextLine().toLowerCase().trim();

        System.out.print("¿Pantalón? -> ");
        String pants = scanner.nextLine().toLowerCase().trim();

        System.out.print("¿Chaleco? (Enter para omitir) -> ");
        String vest = scanner.nextLine().toLowerCase().trim();
        if (vest.isEmpty()) vest = null;

        System.out.print("¿Forro en seda? (Enter para omitir) -> ");
        String lining = scanner.nextLine().toLowerCase().trim();
        if (lining.isEmpty()) lining = null;

        System.out.print("¿Bordado? (Enter para omitir) -> ");
        String embroidery = scanner.nextLine().toLowerCase().trim();
        if (embroidery.isEmpty()) embroidery = null;

        try {
            // Orquestamos la creación
            Suit mySuit = tailor.makeSuit(cloth, coat, pants, vest, lining, embroidery);

            // Imprimimos el objeto (llama automáticamente a toString())
            System.out.println(mySuit);
            System.out.println("¡Lo esperamos en la prueba!");

        } catch (Exception e) {
            System.out.println("Error al armar el traje: " + e.getMessage());
        }
    }
}