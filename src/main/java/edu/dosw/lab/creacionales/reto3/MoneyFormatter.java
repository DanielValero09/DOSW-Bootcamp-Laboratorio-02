package edu.dosw.lab.creacionales.reto3;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public final class MoneyFormatter {
    private static final DecimalFormat FORMATTER = new DecimalFormat("#,###", symbols());

    private MoneyFormatter() {
    }

    public static String format(long value) {
        return "$" + FORMATTER.format(value);
    }

    private static DecimalFormatSymbols symbols() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        return symbols;
    }
}
