package edu.dosw.lab.estructurales.reto5;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public final class MoneyFormatter {
    private MoneyFormatter() {
    }

    public static String format(long amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');

        DecimalFormat formatter = new DecimalFormat("$#,##0", symbols);
        return formatter.format(amount);
    }
}
