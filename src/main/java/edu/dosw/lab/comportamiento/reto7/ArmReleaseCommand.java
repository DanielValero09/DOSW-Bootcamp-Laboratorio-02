package edu.dosw.lab.comportamiento.reto7;

public class ArmReleaseCommand extends AbstractRoverCommand {
    private final RoboticArm arm;

    public ArmReleaseCommand(String operator, RoboticArm arm) {
        super(operator, "Brazo", "Soltar", "");
        this.arm = arm;
    }

    @Override
    public String execute() {
        return arm.release();
    }

    @Override
    public String undo() {
        return arm.collect();
    }
}
