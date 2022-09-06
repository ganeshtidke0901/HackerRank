package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.LinkedHashMap;

public class LinkedHashMapDmeo {
    public static void main(String[] args) {


        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        map.put(900,100);
        map.put(1,100);
        map.put(2,100);
        map.put(3,100);
        map.put(1000,100);
        map.put(9,100);

        map.forEach((integer, integer2)->{
            System.out.println(integer+" "+integer2);
        });
    }
}
