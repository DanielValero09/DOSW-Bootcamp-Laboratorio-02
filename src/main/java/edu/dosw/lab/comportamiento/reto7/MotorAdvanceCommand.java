package edu.dosw.lab.comportamiento.reto7;

public class MotorAdvanceCommand extends AbstractRoverCommand {
    private final Motor motor;
    private final int meters;

    public MotorAdvanceCommand(String operator, Motor motor, int meters) {
        super(operator, "Motor", "Avanzar", "(" + meters + "m)");
        this.motor = motor;
        this.meters = meters;
    }

    @Override
    public String execute() {
        return motor.advance(meters);
    }

    @Override
    public String undo() {
        return motor.reverse(meters);
    }
}
