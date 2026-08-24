package edu.dosw.lab.comportamiento.reto7;

public class DrillCommand extends AbstractRoverCommand {
    private final Drill drill;
    private final int centimeters;

    public DrillCommand(String operator, Drill drill, int centimeters) {
        super(operator, "Taladro", "Perforar", "(" + centimeters + "cm)");
        this.drill = drill;
        this.centimeters = centimeters;
    }

    @Override
    public String execute() {
        return drill.drill(centimeters);
    }

    @Override
    public String undo() {
        return drill.retract();
    }
}
