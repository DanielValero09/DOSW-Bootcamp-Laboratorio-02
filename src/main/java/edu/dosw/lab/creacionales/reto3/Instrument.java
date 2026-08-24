package edu.dosw.lab.creacionales.reto3;

public class Instrument {
    private final InstrumentModel model;
    private final InstrumentGrade grade;
    private final String caseType;

    public Instrument(InstrumentModel model, InstrumentGrade grade, String caseType) {
        this.model = model;
        this.grade = grade;
        this.caseType = caseType;
    }

    public InstrumentModel getModel() {
        return model;
    }

    public InstrumentGrade getGrade() {
        return grade;
    }

    public String getCaseType() {
        return caseType;
    }

    public long getPrice() {
        return Math.round(model.getBasePrice() * grade.getPriceFactor());
    }
}
