package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DataStructureDemno1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        List<Integer> integers= Arrays.asList(line.replaceAll("\\s+$", "").split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        int q=Integer.parseInt(scanner.nextLine());

        for(int i=1;i<=q;i++)
        {
            String query=scanner.nextLine();

            if(query.equalsIgnoreCase("Insert"))
            {
                String query1Inputs=scanner.nextLine();

                List<Integer> elemts= Arrays.asList(query1Inputs.replaceAll("\\s+$", "").split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());

                integers.add(elemts.get(0), elemts.get(1));
            }


            if(query.equalsIgnoreCase("Delete"))
            {
                int index=Integer.parseInt(scanner.nextLine());
                integers.remove(index);
            }
        }
        System.out.println(integers.stream().map(s->s+"").collect(Collectors.joining(" ")));
        scanner.close();
    }
}
