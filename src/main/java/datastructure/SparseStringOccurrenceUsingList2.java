package datastructure;

import java.io.*;
import java.util.*;

class Result3 {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY stringList
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // Write your code here
        Map<String , Integer> stringIntegerMap=new LinkedHashMap<>();

        for(int i=0;i<queries.size();i++)
        {
            boolean isFound=false;
            for(String str:stringList)
            {
                if(str.equals(queries.get(i)))
                {
                    if(stringIntegerMap.get(str)==null)
                    {
                        stringIntegerMap.put(str,1);
                    }else
                    {
                        stringIntegerMap.put(str,stringIntegerMap.get(str)+1);
                    }
                    isFound=true;
                }

            }
            if(!isFound)
            {
                stringIntegerMap.put(queries.get(i),0);
            }

        }
        return new ArrayList<>(stringIntegerMap.values());

    }

}

public class SparseStringOccurrenceUsingList2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringListCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < stringListCount; i++) {
            String stringListItem = bufferedReader.readLine();
            stringList.add(stringListItem);
        }

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = new ArrayList<>();

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = bufferedReader.readLine();
            queries.add(queriesItem);
        }

        List<Integer> res = Result3.matchingStrings(stringList, queries);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
