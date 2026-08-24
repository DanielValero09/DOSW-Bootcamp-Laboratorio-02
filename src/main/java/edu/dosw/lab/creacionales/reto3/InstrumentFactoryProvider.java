package edu.dosw.lab.creacionales.reto3;

import java.util.Map;

public class InstrumentFactoryProvider {
    private final Map<InstrumentGrade, InstrumentFactory> factories = Map.of(
            InstrumentGrade.ESTUDIANTE, new StudentInstrumentFactory(),
            InstrumentGrade.PROFESIONAL, new ProfessionalInstrumentFactory(),
            InstrumentGrade.VINTAGE, new VintageInstrumentFactory()
    );

    public InstrumentFactory getFactory(InstrumentGrade grade) {
        return factories.get(grade);
    }
}
