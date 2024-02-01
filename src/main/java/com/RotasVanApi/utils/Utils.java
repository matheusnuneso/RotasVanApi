package com.RotasVanApi.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static LocalDate stringToDate(String dataString){
        return LocalDate.parse(dataString, formatter);
    }

    public static String dateToString(LocalDate data){
        return data.format(formatter);
    }

}
