package com.sirmaacademy.sirmafinalexam.util;

import org.springframework.stereotype.Component;

@Component
public class RecordTimeParser {

    public static Integer toMinutesParser(String string) {
        if (isStringParsable(string)) {
            return Integer.parseInt(string);
        } else {
            return 90;
        }
    }

    private static boolean isStringParsable (String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
