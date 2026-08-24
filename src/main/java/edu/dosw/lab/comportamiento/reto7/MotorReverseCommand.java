package edu.dosw.lab.comportamiento.reto7;

public class MotorReverseCommand extends AbstractRoverCommand {
    private final Motor motor;
    private final int meters;

    public MotorReverseCommand(String operator, Motor motor, int meters) {
        super(operator, "Motor", "Retroceder", "(" + meters + "m)");
        this.motor = motor;
        this.meters = meters;
    }

    @Override
    public String execute() {
        return motor.reverse(meters);
    }

    @Override
    public String undo() {
        return motor.advance(meters);
    }
}
