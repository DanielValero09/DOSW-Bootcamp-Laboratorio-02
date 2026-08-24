package edu.dosw.lab.comportamiento.reto7;

public class DrillRetractCommand extends AbstractRoverCommand {
    private final Drill drill;

    public DrillRetractCommand(String operator, Drill drill) {
        super(operator, "Taladro", "Retraer", "");
        this.drill = drill;
    }

    @Override
    public String execute() {
        return drill.retract();
    }

    @Override
    public String undo() {
        return "Taladro listo para perforar";
    }
}
