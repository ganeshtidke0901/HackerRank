package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegExDemo2 {
    public static void main(String[] args){

        Pattern p=Pattern.compile("[a-zA-Z0-9<>()!{}%]{1,17}$");
        Matcher matcher=p.matcher("(गणेशAAAAAAAAAa{(");
        while(matcher.find())
        {
            System.out.println(matcher.group());
        }
    }
}
