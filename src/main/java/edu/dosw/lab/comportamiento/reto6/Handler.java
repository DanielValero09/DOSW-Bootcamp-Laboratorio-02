package edu.dosw.lab.comportamiento.reto6;

public interface Handler {
    void setNext(Handler h);
    Reto6.TreatmentResult handle(Reto6.Patient p, int patientId);
}
