package edu.dosw.lab.creacionales.reto3;

public class VintageInstrumentFactory implements InstrumentFactory {
    @Override
    public Instrument createInstrument(InstrumentModel model) {
        return new Instrument(model, InstrumentGrade.VINTAGE, "estuche de coleccion");
    }
}
