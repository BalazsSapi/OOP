package oop.labor04.lab4_extra;

import oop.labor04.lab4_extra.models.*;
import oop.labor04.lab4_extra.utils.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Course>  courses;
    public static void main(String[] args) {
        Major  m = new Major();
        Degree d = new Degree();
        Department  d1 = new Department();
        /*Student student1 = new Student("AVLMO7", "Anne0", "Bell0", "Dentistry0");
        System.out.println(Major.values());
        Student student2 = new Student("AVLMO8", "Anne1", "Bell1", "Dentistry1");
        Student student3 = new Student("AVLMO9", "Anne2", "Bell2", "Dentistry2");
        Student student4 = new Student("AVLM10", "Anne3", "Bell3", "Dentistry3");
        Student student5 = new Student("AVLM11", "Anne4", "Bell4", "Dentistry4");

        Teacher teacher1 = new Teacher("Suzanne1", "Grey1", "Labor technician1", "Medical department1");
        Teacher teacher2 = new Teacher("Suzanne2", "Grey", "Labor technician1", "Medical department1");

        Course course1 = new Course("MB_INFO20", 5, DayOfWeek.FRIDAY);

        course1.setTeacher(teacher1);
        course1.getEnrolledStudents().add(student1);
        course1.getEnrolledStudents().add(student2);
        course1.getEnrolledStudents().add(student3);
        System.out.println(course1);*/
        courses = readUniversitiesFromFile("university.csv");
        enrollStudentsFromFile("students.csv");
        for(Course c : courses){
            System.out.println(c+"\n\n");
        }
    }
    public static ArrayList<Course> readUniversitiesFromFile(String fileName) {
        File file= new File(fileName);
        ArrayList<Course> courses=new ArrayList<>();
        try(Scanner scanner=new Scanner(file)){
            int i=0;
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String[] split=line.split(",");
                courses.add(new Course(split[0].trim(),Integer.parseInt(split[1].trim()),DayOfWeek.values()[Integer.parseInt(split[2].trim())-1]));
                line=scanner.nextLine();
                String[] split2=line.split(",");
                courses.get(i).setTeacher(new Teacher(split2[0].trim(),split2[1].trim(),split2[2].trim().toUpperCase(),Department.values().get(Integer.parseInt(split2[3].trim())-1)));
                i++;
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        return courses;
    }
    public static void enrollStudentsFromFile(String fileName) {
        File file = new File(fileName);
        try(Scanner scanner=new Scanner(file)){
            int i=0;
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String[] split=line.split(",");
                Student student=new Student(split[0].trim(),split[1].trim(),split[2].trim(),split[3].trim().toUpperCase());
                line=scanner.nextLine();
                String[] split2=line.split(",");
                for(String str : split2){
                    for(Course c : courses){
                        if(c.getCourseID().equals(str)){
                            c.enrollStudent(student);
                            break;
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
