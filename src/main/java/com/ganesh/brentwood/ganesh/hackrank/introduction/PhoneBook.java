package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> phoneBook = new HashMap<>();
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();
            phoneBook.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            Optional<Integer> integerOptional = Optional.ofNullable(phoneBook.get(s));
            if (integerOptional.isPresent()) {
                System.out.println(s + "=" + integerOptional.get());
            } else {
                System.out.println("Not found");
            }
        }


//        String s=null;
//        String s1="";
//        String s2=" ";
//        Optional<String> o=Optional.ofNullable(s);
//        Optional<String> o1=Optional.ofNullable(s1);
//        Optional<String> o2=Optional.ofNullable(s2);
//
//        System.out.println(o.isPresent());
//        //System.out.println(o.isEmpty);
//        System.out.println(o.orElse("Ganesh"));
//
//        System.out.println(o1.isPresent());
//
//        System.out.println("--"+o1.get()+"--");

    }
}
