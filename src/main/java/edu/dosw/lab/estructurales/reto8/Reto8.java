package edu.dosw.lab.estructurales.reto8;

public class Reto8 {
    public static void ejecutar() {
        // 1. Instanciación de jugadores base
        Player gk = new GoalKeeper("Rene", 30, 1, "Right", 75.0, 1.85, 90, "Senior");
        Player fwd = new Forward("Radamel", 28, 9, "Right", 72.0, 1.77, 95, "Senior");

        // 2. Aplicación del patrón Decorator en tiempo de ejecución
        MarketValueDecorator decoratedFwd = new MarketValueDecorator(fwd, 15000000.0);

        // 3. Configuración de Entrenador e Hincha
        Coach coach = new Coach("Francisco", 55, "Tactics");
        coach.assignPlayer(gk);
        coach.assignPlayer(decoratedFwd); // LSP en acción

        Fan fan = new Fan("Daniel", 20, 5);
        fan.addFavoritePlayer(decoratedFwd);

        // 4. Pruebas de interacción
        System.out.println("--- Interacciones del Entrenador ---");
        coach.manage(decoratedFwd);
        coach.evaluate(gk);

        System.out.println("\n--- Interacciones del Hincha ---");
        fan.cheer(decoratedFwd);
        fan.postPhoto(gk);

        System.out.println("\n--- Acciones Polimórficas ---");
        gk.train();
        decoratedFwd.kick(); // Ejecuta el kick() del Forward envuelto

        System.out.println("\n--- Verificación de Atributo Dinámico ---");
        System.out.println(decoratedFwd.getName() + " Market Value: $" + decoratedFwd.getMarketValue());
    }
}