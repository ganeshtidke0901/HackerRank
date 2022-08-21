package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class DequeDemo2 {


    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        Scanner in = new Scanner(System.in);
        LinkedList<String> s = new LinkedList<>();

        s.get(1);
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> deque1 = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        int n = in.nextInt();
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int input = in.nextInt();

            deque.add(input);
            set.add(input);

            if (deque.size() == m) {
                if (set.size() > max) max = set.size();
                int first = deque.remove();
                if (!deque.contains(first)) set.remove(first);
            }
        }

        System.out.println(max);
        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println(ChronoUnit.SECONDS.between(localDateTime1, localDateTime2));
    }
}