package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.io.*;
import java.util.*;

public class TwoDArrayDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int lines[][] = new int[n][];
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            lines[i] = new int[line.length];
            for (int k = 0; k < line.length; k++) {
                lines[i][k] = Integer.parseInt(line[k]);
            }
        }


        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
//            System.out.println("--"+scanner.nextLine()+"--");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            try {
                System.out.println(lines[x-1][y]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }


        }
    }
}
