package edu.dosw.lab.comportamiento.reto6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reto6 {

    // Nested record para inmutabilidad y simplicidad en este reto
    public record Patient(String symptom, String level, int priority) {}
    public record TreatmentResult(boolean wasHandled, String level, int priority) {}

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();

        System.out.print("Ingrese la cantidad de pacientes: ");
        int numPatients = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numPatients; i++) {
            System.out.print("P" + i + ": ");
            String symptom = scanner.nextLine();
            System.out.print("Nivel: ");
            String level = scanner.nextLine();
            System.out.print("Prioridad: ");
            int priority = Integer.parseInt(scanner.nextLine());

            patients.add(new Patient(symptom, level, priority));
        }

        System.out.println("\n--- Procesando Pacientes ---");

        // TODO: 1. Initialize the Chain of Responsibility handlers
        Handler nurse = new Nurse();
        Handler doctor = new Doctor();
        Handler specialist = new Specialist();

        // TODO: 2. Link the chain (set next handlers)
        nurse.setNext(doctor);
        doctor.setNext(specialist);

        // TODO: 3. Process the patients through the chain
        List<TreatmentResult> results = new ArrayList<>();

        int id = 1;
        for (Patient p : patients) {
            TreatmentResult result = nurse.handle(p, id++);
            results.add(result);
        }

        // TODO: 4. Generate statistics using Java Streams
        System.out.println("\n--- Estadisticas ---");

        long leves = results.stream()
                .filter(r -> r.wasHandled() && r.level().equalsIgnoreCase(Nurse.LEVEL))
                .count();

        long moderados = results.stream()
                .filter(r -> r.wasHandled() && r.level().equalsIgnoreCase(Doctor.LEVEL))
                .count();

        long graves = results.stream()
                .filter(r -> r.wasHandled() && r.level().equalsIgnoreCase(Specialist.LEVEL))
                .count();

        long remitidos = results.stream()
                .filter(r -> !r.wasHandled())
                .count();

        double promedio = results.stream()
                .filter(TreatmentResult::wasHandled)
                .mapToInt(TreatmentResult::priority)
                .average()
                .orElse(0.0);

        System.out.println("Atendidos - Leve: " + leves + " Moderado: " + moderados + " Grave: " + graves);
        System.out.println("Remitidos a otra institucion: " + remitidos);
        System.out.println("Promedio prioridad atendidos: " + promedio);

    }
}