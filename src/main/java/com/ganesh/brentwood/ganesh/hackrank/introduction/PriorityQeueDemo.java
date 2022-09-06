package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.*;

/*
 * Create the Student and Priorities classes here.
 */
class Priorities {

    public List<Student1> getStudents(List<String> events) {


        PriorityQueue<Student1> priorityQueue = new PriorityQueue<>(events.size(),Comparator.comparing(Student1::getCGPA).reversed().thenComparing(Student1::getName).thenComparing(Student1::getID));
        for (String event : events) {
            if (event.contains("ENTER")) {
                String[] data = event.split(" ");
                String eventType = data[0];
                priorityQueue.offer(new Student1(Integer.parseInt(data[3]), data[1], Double.parseDouble(data[2])));

            } else {
                priorityQueue.poll();
            }
        }
        System.out.println(priorityQueue);
        return new ArrayList<>(priorityQueue);
    }
}

 class Student1 {
    private int id;
    private String name;
    private double cgpa;

    public Student1(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getID() + " " + getName() + " " + getCGPA();
    }


}

public class PriorityQeueDemo {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student1> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student1 st : students) {
                System.out.println(st.getName());
            }
        }
    }
}