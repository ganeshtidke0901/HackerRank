package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo3 {

    public static void main(String[] args) {

        // \\. = . char
        // [.]= . char
        // . = any char
        String s="(";

        Pattern pattern=Pattern.compile("(", Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(s);
        while(matcher.find())
        {
            System.out.println("matcher.group()--"+matcher.group());

        }

        System.out.println(s);
    }
}
