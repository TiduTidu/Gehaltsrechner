package com.c3c2;

import java.util.Locale;

public class Utils {
    public static String EURO = " \u20ac";
    public void log(String message) {
        System.out.println(message);
    }
    public void divider() {
        this.log("------------------------------");
    }
    static public String currFormat(float value) {
        return String.format(Locale.GERMAN, "%.2f", value) + EURO;
    }

}

