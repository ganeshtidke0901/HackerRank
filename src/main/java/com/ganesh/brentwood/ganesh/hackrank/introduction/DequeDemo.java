package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class DequeDemo {
    public static void main(String[] args) {
        LocalDateTime localDateTime1=LocalDateTime.now();
        System.out.println();
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
        }
        int maxUniqueNumber=Integer.MIN_VALUE;
        if(m==n)
        {
            n++;
        }

        for (int i = 0; i < n-m; i++) {
            HashSet<Integer> hashSet=new HashSet<Integer>();
            Iterator<Integer> iterator=deque.iterator();
            int counter=0;
            for(;iterator.hasNext()&&counter<m;)
            {
                hashSet.add(iterator.next());
                counter++;
            }
            if(maxUniqueNumber<hashSet.size())
                maxUniqueNumber=hashSet.size();
            deque.pollFirst();

        }
        System.out.println(maxUniqueNumber);
        LocalDateTime localDateTime2=LocalDateTime.now();
        System.out.println(ChronoUnit.SECONDS.between(localDateTime1,localDateTime2));
    }
}
