package datastructure;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result1 {

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        int arrSize = arr.size();
        if (d > arrSize) {
            d = arrSize % d;
        }

        List<Integer> subList1 = arr.subList(0, d);
        List<Integer> subList2 = arr.subList(d, arrSize);
        List<Integer> newArrList = new ArrayList<>(subList2);
        newArrList.addAll(subList1);


        //  for(int i=1;i<=d;i++)
        //  {
        //      int temp=arr.get(0);

        //      for(int j=0;j<arrSize-1;j++)
        //      {
        //          arr.set(j,arr.get(j+1));

        //      }
        //      arr.set(arrSize-1,temp);
        //  }
        return newArrList;
    }

}

public class RotateArrayUsingList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result1.rotateLeft(d, arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

