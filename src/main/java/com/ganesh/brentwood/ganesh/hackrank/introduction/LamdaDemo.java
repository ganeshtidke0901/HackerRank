package com.ganesh.brentwood.ganesh.hackrank.introduction;


import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        PerformOperation operation = a -> {
            if (a % 2 == 0)
                return false;
            else
                return true;
        };
        return operation;

    }


    public PerformOperation isPrime() {

        PerformOperation operation = a -> {
            if (a == 1)
                return true;

            if (a < 1)
                return false;

            for (int i = 2; i < a / 2; i++) {
                if (a % i == 0) {

                    return false;
                }
            }
            return true;
        };
        return operation;
    }


    public PerformOperation isPalindrome() {

        PerformOperation operation = a -> {
            int n = a;
            int sum = 0;
            while (n != 0) {
                sum = sum * 10 + n % 10;
                n = n / 10;
            }
            if (sum == a)
                return true;
            else
                return false;
        };
        return operation;
    }
}

public class LamdaDemo {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
