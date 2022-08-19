package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;


class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        LocalDate localDate=LocalDate.of(year,month,day);
        return localDate.getDayOfWeek().toString();
    }

}

public class DateTimeDemo {
    public static void main(String[] args) {
    }
}
