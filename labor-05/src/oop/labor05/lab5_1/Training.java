package oop.labor05.lab5_1;

import lab2_3.MyDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Training {
    private final Course course;
    private final MyDate startDate;
    private final MyDate endDate;
    private final double pricePerStudent;
    private ArrayList<Student> students=new ArrayList<>();

    public Training(Course course, MyDate startDate, MyDate endDate, double pricePerStudent) {
        this.course = new Course(course.getName(), course.getDescription(), course.getNumHours());
        this.startDate = new MyDate(startDate.getYear(), startDate.getMonth(), startDate.getDay());
        this.endDate = new MyDate(endDate.getYear(), endDate.getMonth(), endDate.getDay());
        this.pricePerStudent = pricePerStudent;
    }

    public boolean enroll(Student student) {
        if(students.contains(student)) {
            System.out.println("Student already enrolled!");
            return false;
        }
        else{
            students.add(student);
            return true;
        }
    }

    public Student findStudentByID(String ID) {
        for(Student student : students) {
            if(student.getID().equals(ID)) {
                return student;
            }
        }
        System.out.println("Student not found!");
        return null;
    }

    public Course getCourse() {
        return course;
    }

    public int numEnrolled() {
        return students.size();
    }

    public void printToFile() {
        File file = new File(String.format("%s_%s_%s.csv", course.getName(), startDate, endDate));
        try(FileWriter fw =new FileWriter(file)){
            fw.write(studentsToCSV());
        }
        catch (IOException e) {
            System.out.println("Error writing to file: " + file);
            e.printStackTrace();
        }
    }

    public String toString(){
        return "Training{\n\tcourse=" + course +
                "\n\tstartDate=year: " + startDate.getYear() + " month: " + startDate.getMonth() + " day: " + startDate.getDay() +
                "\n\tendDate=year: " + endDate.getYear() + " month: " + endDate.getMonth() + " day: " + endDate.getDay() +
                "\n" + studentsToString();
    }

    public void unEnroll(String ID) {
        students.remove(findStudentByID(ID));
    }

    public String studentsToString() {
        String str = new String();
        for(Student student : students) {
            str =str+"\t\t"+student.toString()+"\n";
        }
        return str;
    }

    public String studentsToCSV() {
        String str = new String();
        for(Student student : students) {
            str = str+student.toString()+", ";
        }
        return str;
    }
}
