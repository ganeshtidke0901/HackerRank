package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class BigDecimals {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        for(int i=1; i< s.length;i++)
        {
             for(int j=0;j<s.length-i;j++)
            {
                if(s[j+1]==null)
                {
                      continue;
                }
                if(s[j]==null || new BigDecimal(s[j]).compareTo(new BigDecimal(s[j+1]))<0)
                {
                    String temp=s[j];
                    s[j]=s[j+1];
                    s[j+1]=temp;
                }
            }
        }


        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
