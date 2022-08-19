package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatDemo {

    public static void main(String[] args) {
        double number=1234567.11033;
        NumberFormat numberFormat=NumberFormat.getCurrencyInstance(new Locale("en","IN"));




        System.out.println(numberFormat.format(number));


   }
}
