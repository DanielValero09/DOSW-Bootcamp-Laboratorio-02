package edu.dosw.lab.comportamiento.reto7;

public class CommandRecord {
    private final RoverCommand command;
    private boolean undone;

    public CommandRecord(RoverCommand command) {
        this.command = command;
    }

    public RoverCommand getCommand() {
        return command;
    }

    public boolean isUndone() {
        return undone;
    }

    public void markUndone() {
        this.undone = true;
    }
}
