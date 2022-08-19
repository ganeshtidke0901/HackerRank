package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor_Med {
    public static void main(String[] args) {

        StringBuilder builder=new StringBuilder();
        Scanner in = new Scanner(System.in);

        Pattern pattern = Pattern.compile("<([^</>]+)>");
        int testCases = Integer.parseInt(in.nextLine());
//<GfYTkjn{CTWM-U@3Wv(h( ~Cnc9&BKA>
        while(testCases>0){
            String line = in.nextLine();
            //Write your code here
            boolean isPatternMatch=false;
            Matcher matcher = pattern.matcher(line);
            Set<String> tags=new LinkedHashSet<>();
            while (matcher.find()) {
              //  System.out.println("-----"+matcher.group());
                String s=matcher.group();
                s=s.replaceAll("\\(","\\\\(").replaceAll("\\{","\\\\{").replaceAll("}","\\}").replaceAll("\\)","\\\\)");
                tags.add(s);
               // System.out.println("(");//not regex here - no special meaning
            }


            String s="<GfYTkjn\\{CTWM-U@3Wv\\(h\\( ~Cnc9&BKA>";
            for(Iterator<String> iterator=tags.iterator();iterator.hasNext();)
            {
                String tag=iterator.next();


                try{
                    Pattern pattern2 = Pattern.compile(tag+"([^<>]*)</"+tag.substring(1,tag.length()-1)+">");
                    Matcher matcher2 = pattern2.matcher(line);
                    while (matcher2.find()) {
                        isPatternMatch=true;

                        String group2="";
                        group2=matcher2.group(1);
                        if (group2.isEmpty()) {
                            builder.append("None");
                        } else {
                            builder.append(group2);
                        }

                        builder.append(System.lineSeparator());
                    }
                }catch(Exception e)
                {

                }


            }
            if(!isPatternMatch){
                builder.append("None");
                builder.append(System.lineSeparator());
            }
            testCases--;
        }

        System.out.println(builder.toString());
    }
}
