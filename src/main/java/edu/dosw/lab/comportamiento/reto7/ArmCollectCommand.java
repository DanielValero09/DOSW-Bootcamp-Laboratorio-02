package edu.dosw.lab.comportamiento.reto7;

public class ArmCollectCommand extends AbstractRoverCommand {
    private final RoboticArm arm;

    public ArmCollectCommand(String operator, RoboticArm arm) {
        super(operator, "Brazo", "Recoger", "");
        this.arm = arm;
    }

    @Override
    public String execute() {
        return arm.collect();
    }

    @Override
    public String undo() {
        return arm.release();
    }
}
