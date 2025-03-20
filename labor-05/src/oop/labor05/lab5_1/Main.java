package oop.labor05.lab5_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Course> courses=readCourses("lab5_1_courses.csv");
        for(Course c:courses){
            System.out.println(c);
        }
        ArrayList<Student> students=readStudents("lab5_1_students.csv");
        for(Student s:students){
            System.out.println(s);
        }
    }

    private static ArrayList<Course> readCourses(String filename){
        ArrayList<Course> courses = new ArrayList<>();
        File file = new File(filename);
        try(Scanner input = new Scanner(file)){
            while(input.hasNextLine()){
                String[] line = input.nextLine().trim().split(",");
                courses.add(new Course(line[0],line[1],Integer.parseInt(line[2].trim())));

            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return courses;
    }

    private static ArrayList<Student> readStudents(String filename){
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(filename);
        try(Scanner input = new Scanner(file)){
            while(input.hasNextLine()){
                String rLine = input.nextLine();
                if(rLine.isEmpty()){
                    break;
                }
                String[] line = rLine.split(",");
                students.add(new Student(line[0].trim(),line[1].trim(),line[2].trim()));

            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return students;
    }
}
