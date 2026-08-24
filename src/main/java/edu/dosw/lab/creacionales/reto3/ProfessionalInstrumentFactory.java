package edu.dosw.lab.creacionales.reto3;

public class ProfessionalInstrumentFactory implements InstrumentFactory {
    @Override
    public Instrument createInstrument(InstrumentModel model) {
        return new Instrument(model, InstrumentGrade.PROFESIONAL, "estuche rigido premium");
    }
}
