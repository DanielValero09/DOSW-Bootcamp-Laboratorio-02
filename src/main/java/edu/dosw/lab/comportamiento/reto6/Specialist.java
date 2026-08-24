package edu.dosw.lab.comportamiento.reto6;

public class Specialist extends BaseHandler {
    public static final String LEVEL = "grave";
    public static final int PRIORITY = 3;

    @Override
    public Reto6.TreatmentResult handle(Reto6.Patient p, int patientId) {
        if (p.level().equalsIgnoreCase(LEVEL) && p.priority() <= PRIORITY) {
            System.out.println("P" + patientId + ": Especialista atendio.");
            return new Reto6.TreatmentResult(true, p.level(), p.priority());
        } else {
            return super.handle(p, patientId);
        }
    }
}