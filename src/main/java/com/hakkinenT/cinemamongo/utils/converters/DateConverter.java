package com.hakkinenT.cinemamongo.utils.converters;

import java.time.*;
import java.time.format.*;

public class DateConverter {
    private static DateTimeFormatter zFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static LocalDate zonedDateToLocalDate(String dateTime){
        return LocalDate.parse(dateTime, zFormatter);
    }

    public static LocalTime zonedDateToLocalTime(String dateTime){
        return LocalTime.parse(dateTime, zFormatter);
    }
}
