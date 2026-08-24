package edu.dosw.lab.comportamiento.reto7;

public class CommandFactory {
    private final Motor motor = new Motor();
    private final RoboticArm arm = new RoboticArm();
    private final RoverCamera camera = new RoverCamera();
    private final Drill drill = new Drill();

    public RoverCommand create(String operator, int moduleOption, int actionOption, int parameter) {
        return switch (moduleOption) {
            case 1 -> createMotorCommand(operator, actionOption, parameter);
            case 2 -> createArmCommand(operator, actionOption);
            case 3 -> createCameraCommand(operator, actionOption, parameter);
            case 4 -> createDrillCommand(operator, actionOption, parameter);
            default -> throw new IllegalArgumentException("Modulo no soportado.");
        };
    }

    private RoverCommand createMotorCommand(String operator, int actionOption, int meters) {
        if (meters <= 0) {
            throw new IllegalArgumentException("Los metros deben ser mayores a cero.");
        }

        return switch (actionOption) {
            case 1 -> new MotorAdvanceCommand(operator, motor, meters);
            case 2 -> new MotorReverseCommand(operator, motor, meters);
            default -> throw new IllegalArgumentException("Accion de motor no soportada.");
        };
    }

    private RoverCommand createArmCommand(String operator, int actionOption) {
        return switch (actionOption) {
            case 1 -> new ArmCollectCommand(operator, arm);
            case 2 -> new ArmReleaseCommand(operator, arm);
            default -> throw new IllegalArgumentException("Accion de brazo no soportada.");
        };
    }

    private RoverCommand createCameraCommand(String operator, int actionOption, int seconds) {
        if (actionOption == 1 && (seconds < 0 || seconds > 120)) {
            throw new IllegalArgumentException("La camara solo puede grabar entre 0 y 120 segundos.");
        }

        return switch (actionOption) {
            case 1 -> new CameraRecordCommand(operator, camera, seconds);
            case 2 -> new CameraStopCommand(operator, camera);
            default -> throw new IllegalArgumentException("Accion de camara no soportada.");
        };
    }

    private RoverCommand createDrillCommand(String operator, int actionOption, int centimeters) {
        if (actionOption == 1 && centimeters <= 0) {
            throw new IllegalArgumentException("La profundidad debe ser mayor a cero.");
        }

        return switch (actionOption) {
            case 1 -> new DrillCommand(operator, drill, centimeters);
            case 2 -> new DrillRetractCommand(operator, drill);
            default -> throw new IllegalArgumentException("Accion de taladro no soportada.");
        };
    }
}
