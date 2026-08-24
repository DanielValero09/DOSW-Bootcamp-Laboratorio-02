package edu.dosw.lab.comportamiento.reto7;

import java.util.ArrayList;
import java.util.List;

public class RoverControl {
    private final List<CommandRecord> history = new ArrayList<>();

    public String execute(RoverCommand command) {
        history.add(new CommandRecord(command));
        return command.execute() + " [" + command.getOperator() + "]";
    }

    public String undo(int commandNumber) {
        if (commandNumber < 1 || commandNumber > history.size()) {
            throw new IllegalArgumentException("No existe la accion #" + commandNumber + ".");
        }

        CommandRecord record = history.get(commandNumber - 1);
        if (record.isUndone()) {
            throw new IllegalStateException("La accion #" + commandNumber + " ya estaba deshecha.");
        }

        record.markUndone();
        return "Accion deshecha: " + record.getCommand().undo() + ".";
    }

    public List<CommandRecord> getHistory() {
        return List.copyOf(history);
    }
}
