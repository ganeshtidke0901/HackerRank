package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSetLinkedHashSetDemop {
    public static void main(String[] args) {

        HashSet<String> s=new HashSet<String>();
        s.add("Ganesh");
        s.add("Ashwini");
        s.add("Tidke");
        s.add("Ganesh");

        LinkedHashSet<String> s1=new LinkedHashSet<>();
        s1.add("Ganesh");
        s1.add("Ashwini");
        s1.add("Tidke");
        s1.add("Ganesh");
        s1.remove("Ganesh");



    }
}
