package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo2 {

    public static void main(String[] args) {

        // \\. = . char
        // [.]= . char
        // . = any char
        String s="<wkjkTvAuA8Zk}n_l7Si\\\"-pfm`M8YE3F}4`YQyChgC3uRbyTvu>bMUGux})vQnXpw6n9V8wVCVaTRTgLKkeF</wkjkTvAuA8Zk}n_l7Si\\\"-pfm`M8YE3F}4`YQyChgC3uRbyTvu>";

        Pattern pattern=Pattern.compile("\\b(\\w+)(\\s+\\1\\b)+", Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(s);
        while(matcher.find())
        {
            System.out.println("matcher.group()--"+matcher.group());
            System.out.println("matcher.group(1)--"+matcher.group(1));
            System.out.println("matcher.group(2)--"+matcher.group(2));
            s=s.replaceAll(matcher.group(),matcher.group(1));
        }

        System.out.println(s);
    }
}
