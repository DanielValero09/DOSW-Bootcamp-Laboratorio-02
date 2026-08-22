package edu.dosw.lab.Solid.Reto1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public final class SelectorEspectador {

    private static final Map<String, Espectador> OPCIONES = crearOpciones();

    private SelectorEspectador() {
    }

    public static Espectador solicitar(Scanner scanner) {
        imprimirOpciones();

        System.out.print("Espectador: ");
        String entrada = scanner.nextLine().trim().toLowerCase();
        Espectador espectador = OPCIONES.get(entrada);

        if (espectador == null) {
            System.out.println("Tipo no reconocido. Se usara espectador General.");
            return new General();
        }

        return espectador;
    }

    private static void imprimirOpciones() {
        System.out.println("Tipos de espectador disponibles:");
        System.out.println("  1. General");
        System.out.println("  2. Estudiante");
        System.out.println("  3. Tercera edad");
    }

    private static Map<String, Espectador> crearOpciones() {
        Map<String, Espectador> opciones = new LinkedHashMap<>();
        opciones.put("1", new General());
        opciones.put("general", new General());
        opciones.put("2", new Estudiante());
        opciones.put("estudiante", new Estudiante());
        opciones.put("3", new TerceraEdad());
        opciones.put("tercera edad", new TerceraEdad());
        opciones.put("tercera", new TerceraEdad());
        opciones.put("adulto mayor", new TerceraEdad());
        return opciones;
    }
}
