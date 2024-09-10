package com.sirmaacademy.sirmafinalexam.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;

@Component
public class DateTimeFormatterUtil {

    private static final List<DateTimeFormatter> DATE_FORMATS = Arrays.asList(
            DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL),
            DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG),
            DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM),
            DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT),
            DateTimeFormatter.ofPattern("M/dd/yyyy"),
            DateTimeFormatter.ofPattern("M/d/yyyy")
    );

    public static LocalDate parseDateFromAllFormats(String date) {
     for (DateTimeFormatter dateTimeFormatter : DATE_FORMATS) {
        try {
            return LocalDate.parse(date, dateTimeFormatter);
        } catch (DateTimeParseException e){

        }
     }
     throw new IllegalArgumentException("Cannot parse date: " + date);
    }
}
