package edu.dosw.lab.comportamiento.reto6;

public abstract class BaseHandler implements Handler{
    private Handler next;

    public void setNext(Handler h){
        next = h;
    }

    public Reto6.TreatmentResult handle(Reto6.Patient p, int patientId){
        if (next != null){
            return next.handle(p, patientId);
        } else {
            System.out.println("P" + patientId + ": Sin profesional disponible.");
            System.out.println("    Paciente remitido a otra institucion.");
            return new Reto6.TreatmentResult(false, p.level(), p.priority());
        }
    }
}
