package edu.dosw.lab.comportamiento.reto7;

public interface RoverCommand {
    String execute();

    String undo();

    String getOperator();

    String getModule();

    String getAction();

    String getParameterSummary();
}
