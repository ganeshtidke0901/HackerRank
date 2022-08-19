package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.Scanner;

public class StringSplit {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.

        String[] arr=s.split("[ !,?._'@]+");
        System.out.println(arr.length);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }


        scan.close();
    }
}
