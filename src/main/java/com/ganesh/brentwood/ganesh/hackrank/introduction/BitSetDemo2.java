package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.BitSet;
import java.util.Scanner;

public class BitSetDemo2 {
    public static void main(String[] args) {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        BitSet bitSet1 = new BitSet(m);
        BitSet bitSet2 = new BitSet(m);
        while (n-- > 0) {
            String line = scanner.nextLine();
            String[] opsAndSets = line.replaceAll("\\s+$", "").split(" ");
            int n1 = Integer.parseInt(opsAndSets[1]);
            int n2 = Integer.parseInt(opsAndSets[2]);



            switch (opsAndSets[0]) {
                case "AND":
                    if (n1 == 1) bitSet1.and(bitSet2);
                    else bitSet2.and(bitSet1);
                    System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
                    break;
                case "SET":
                    if (n1 == 1) bitSet1.set(n2);
                    else bitSet2.set(n2);
                    System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());

                    break;
                case "FLIP":
                    if (n1 == 1) bitSet1.flip(n2);
                    else bitSet2.flip(n2);
                    System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());

                    break;
                case "OR":
                    if (n1 == 1) bitSet1.or(bitSet2);
                    else bitSet2.or(bitSet1);
                    System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());

                    break;


            }

        }


    }
}
