package edu.dosw.lab.comportamiento.reto7;

public class CameraRecordCommand extends AbstractRoverCommand {
    private final RoverCamera camera;
    private final int seconds;

    public CameraRecordCommand(String operator, RoverCamera camera, int seconds) {
        super(operator, "Camara", "Grabar", "(" + seconds + "s)");
        this.camera = camera;
        this.seconds = seconds;
    }

    @Override
    public String execute() {
        return camera.record(seconds);
    }

    @Override
    public String undo() {
        return camera.stop();
    }
}
