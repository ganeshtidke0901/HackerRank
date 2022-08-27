package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.*;

/*
 * Create the Student and Priorities classes here.
 */
class Priorities1 {

    public List<Student2> getStudents(List<String> events) {

        Comparator<Student2> comparator=Comparator.comparing(Student2::getCGPA).reversed().thenComparing(Student2::getName).thenComparing(Student2::getID);
        List<Student2> priorityQueue = new ArrayList<>();
        for (String event : events) {
            if (event.contains("ENTER")) {
                String[] data = event.split(" ");
                String eventType = data[0];
                priorityQueue.add(new Student2(Integer.parseInt(data[3]), data[1], Double.parseDouble(data[2])));

            } else {
//                priorityQueue.poll();
            }
        }

        Collections.sort(priorityQueue,comparator);
        System.out.println(priorityQueue);
        return new ArrayList<>(priorityQueue);
    }
}

 class Student2 {
    private int id;
    private String name;
    private double cgpa;

    public Student2(int id, String name, double cgpa) {
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

public class PriorityQeueDemo2 {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities1 priorities = new Priorities1();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student2> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student2 st : students) {
                System.out.println(st.getName());
            }
        }
    }
}