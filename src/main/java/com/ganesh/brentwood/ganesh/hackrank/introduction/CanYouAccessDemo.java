package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;
import java.security.*;


public class CanYouAccessDemo {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private
            o = (new CanYouAccessDemo.Inner()).new Private();
//            Class<CanYouAccessDemo.Inner.Private> class1 = (Class<Inner.Private>) Class.forName("com.ganesh.brentwood.ganesh.hackrank.introduction.CanYouAccessDemo$Inner$Private");
//            Class<CanYouAccessDemo.Inner.Private> class1 = CanYouAccessDemo.Inner.Private.class;
                Class class1 = CanYouAccessDemo.Inner.Private.class;
////              Class<Inner.Private> class1= (Class<Inner.Private>) new Inner().new Private().getClass();
////                    ;
//           Object o= class1.newInstance();
            Method[] methods = class1.getDeclaredMethods();
            methods[0].setAccessible(true);
            System.out.println(methods[0].invoke(o, num));
            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }//end of try

        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }//end of main

    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }//end of Inner

}//end of Solution


