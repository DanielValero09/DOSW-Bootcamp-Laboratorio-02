package edu.dosw.lab.comportamiento.reto7;

public class RoverCamera {
    public String record(int seconds) {
        return "Camara grabando " + seconds + " s";
    }

    public String stop() {
        return "Camara detenida";
    }
}
