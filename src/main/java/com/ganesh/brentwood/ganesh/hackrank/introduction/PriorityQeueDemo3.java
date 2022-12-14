package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class PriorityQeueDemo3 {

  static  class Student implements Comparable<Student>{
        String name = new String();
        double cgpa;
        int id;
        public Student(String name,double cgpa,int id)
        {
            this.name = name;
            this.cgpa = cgpa;
            this.id = id;
        }
        public String getName(){
            return this.name;
        }
        public int compareTo(Student s)
        {
            if(cgpa == s.cgpa)
            {
                if(name.compareTo(s.name) == 0)
                {
                    if(id == s.id)
                        return 0;
                    else if (id > s.id)
                        return 1;
                    else
                        return -1;
                }
                else
                    return name.compareTo(s.name);
            }
            else if(cgpa > s.cgpa)
                return -1;
            else
                return 1;
        }

      @Override
      public String toString() {
          return "Student{" +
                  "name='" + name + '\'' +
                  ", cgpa=" + cgpa +
                  ", id=" + id +
                  '}';
      }
  }

    static class Priorities {
        public ArrayList<Student> getStudents(List<String> events)
        {

            int n = events.size();
            PriorityQueue<Student> pq = new PriorityQueue<Student>();
            for(String i:events)
            {
                String[] s = new String[4];
                s = i.split("\\s");
                if(s.length>1)
                {
                    pq.add(new Student(s[1],Double.valueOf(s[2]),Integer.valueOf(s[3])));
                }
                else
                {
                    pq.poll();
                }
            }
            while(pq.size()>1)
            {
                System.out.println(pq.poll().name);
            }
//            System.out.println(pq);
            return new ArrayList<Student>(pq);
        }
    }
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }




}