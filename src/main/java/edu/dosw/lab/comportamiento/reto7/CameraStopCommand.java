package edu.dosw.lab.comportamiento.reto7;

public class CameraStopCommand extends AbstractRoverCommand {
    private final RoverCamera camera;

    public CameraStopCommand(String operator, RoverCamera camera) {
        super(operator, "Camara", "Detener", "");
        this.camera = camera;
    }

    @Override
    public String execute() {
        return camera.stop();
    }

    @Override
    public String undo() {
        return "Camara lista para grabar";
    }
}
