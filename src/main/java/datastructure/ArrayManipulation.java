package datastructure;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result5 {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {

        long maxValue = 0;
        long[] integers = new long[n];
        long sum = 0;

        for (int i = 0; i < queries.size(); i++) {
            int a1 = queries.get(i).get(0);
            int b1 = queries.get(i).get(1);
            int k1 = queries.get(i).get(2);

            // if(b1<a1 || b2<a1)
            // {
            //     maxValue+=(k1<k2)?k2:k1;
            // }else{
            //     maxValue+=k1+k2;
            // }


            integers[a1 - 1] += k1;
            if (b1 < n) {
                integers[b1] -= k1;

            }
        }
        for (int i = 0; i < n; i++) {
            sum += integers[i];
            integers[i] = sum;
            maxValue = Math.max(sum, maxValue);
        }
        return maxValue;


    }

}

public class ArrayManipulation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        long result = Result5.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
