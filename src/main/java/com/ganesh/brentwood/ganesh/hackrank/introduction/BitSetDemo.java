package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.BitSet;

public class BitSetDemo {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet(4);
        bitSet.set(0);
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(4);

        System.out.println(bitSet);
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.get(3));
        System.out.println(bitSet.cardinality());


    }
}
