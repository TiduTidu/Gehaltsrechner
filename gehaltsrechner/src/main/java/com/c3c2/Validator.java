package com.c3c2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void validate(String patternString, String target, String errorMessage) {
        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(target);
        if (!matcher.matches()) {
            System.out.println(errorMessage);
            System.exit(-1);
        }
    }
}
