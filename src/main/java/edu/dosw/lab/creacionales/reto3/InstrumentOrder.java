package edu.dosw.lab.creacionales.reto3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InstrumentOrder {
    private final List<Instrument> instruments = new ArrayList<>();

    public void add(Instrument instrument) {
        instruments.add(instrument);
    }

    public List<Instrument> getInstruments() {
        return Collections.unmodifiableList(instruments);
    }

    public long getTotal() {
        return instruments.stream()
                .mapToLong(Instrument::getPrice)
                .sum();
    }
}
