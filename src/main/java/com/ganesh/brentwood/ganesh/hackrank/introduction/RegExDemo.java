package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegExDemo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        StringBuilder builder=new StringBuilder();
        while(testCases>0){
            String pattern = in.nextLine();
            try{
                Pattern.compile(pattern);
                builder.append("Valid");
                builder.append(System.lineSeparator());
            }catch(PatternSyntaxException e){
                builder.append("Invalid");
                builder.append(System.lineSeparator());
            }
            testCases--;
        }
        System.out.println(builder.toString());
    }
}
