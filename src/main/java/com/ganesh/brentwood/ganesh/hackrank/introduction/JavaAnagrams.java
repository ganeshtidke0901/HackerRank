package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.Scanner;

public class JavaAnagrams {
    static boolean isAnagram(String a, String b) {
        boolean isAnagramMatch=true;
        int[] charFreqA=new int[a.length()];
        int[] charFreqB=new int[b.length()];

        a=a.toLowerCase();
        b=b.toLowerCase();
        for(int i= 0; i< a.length();i++)
        {
            char c=a.charAt(i);
            int counter=0;
            for(int k=0; k<a.length();k++)
            {
                if(c==a.charAt(k))
                {
                    counter++;
                }
            }
            charFreqA[i]=counter;
        }
        for(int i= 0; i< b.length();i++)
        {
            char c=b.charAt(i);
            int counter=0;
            for(int k=0; k<b.length();k++)
            {
                if(c==b.charAt(k))
                {
                    counter++;
                }
            }
            charFreqB[i]=counter;
        }

        for(int i= 0; i< a.length();i++)
        {
            char c=a.charAt(i);
            int index=b.indexOf(c+"");
            if(index==-1)
            {
                isAnagramMatch=false;
                break;
            }
            if(!(charFreqA[i]==charFreqB[index]))
            {
                isAnagramMatch=false;
                break;
            }

        }
        for(int i= 0; i< b.length();i++)
        {
            char c=b.charAt(i);
            int index=a.indexOf(c+"");
            if(index==-1)
            {
                isAnagramMatch=false;
                break;
            }
            if(!(charFreqB[i]==charFreqA[index]))
            {
                isAnagramMatch=false;
                break;
            }

        }


        return isAnagramMatch;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
