package oop.labor12.lab12_3;

import java.util.HashMap;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private HashMap<String,Double> marks = new HashMap<>();
    private double average;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addMark(String subject, double mark){
        marks.put(subject,mark);
    }

    public double getMark(String subject){
        return marks.getOrDefault(subject,0.0);
    }

    public void calculateAverage(){
        int count = 0;
        average = 0;
        for (String subject:marks.keySet()){
            average += marks.get(subject);
            count++;
        }
        average = average / count;
    }

    public double getAverage() {
        return average;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        String avgTwoDecimals = String.format("%.2f",average);
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", marks=" + marks +
                ", average=" + avgTwoDecimals +
                '}';
    }

    public boolean passed(){
        calculateAverage();
        if(average < 6){
            return false;
        }
        for (String subject:marks.keySet()){
            if(marks.get(subject)<5){
                return false;
            }
        }
        return true;
    }
}
