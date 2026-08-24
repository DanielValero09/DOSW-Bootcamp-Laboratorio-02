package edu.dosw.lab.creacionales.reto3;

public class StudentInstrumentFactory implements InstrumentFactory {
    @Override
    public Instrument createInstrument(InstrumentModel model) {
        return new Instrument(model, InstrumentGrade.ESTUDIANTE, "estuche sencillo");
    }
}
