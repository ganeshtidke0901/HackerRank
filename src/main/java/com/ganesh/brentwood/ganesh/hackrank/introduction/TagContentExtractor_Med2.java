package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor_Med2 {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile("<([^<>]+)>([^<>]*)</\\1>");

        while (testCases > 0) {
            String line = in.nextLine();
            boolean isPatternMatch = false;
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                   System.out.println(matcher.group(2));
                isPatternMatch=true;
            }

            testCases--;
            if (!isPatternMatch)
                System.out.println("None");
        }


    }
}
