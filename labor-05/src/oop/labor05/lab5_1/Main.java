package oop.labor05.lab5_1;

import lab2_3.MyDate;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Course> courses = readCourses("lab5_1_courses.csv");
        ArrayList<Student> students = readStudents("lab5_1_students.csv");
        Random random = new Random();
        MyDate startDate = new MyDate(2023, 3, 21);
        MyDate endDate = new MyDate(2023, 3, 25);
        ArrayList<Training> trainings = new ArrayList<>();
        for (Course course : courses) {
            double pricePerStudent = 1000 + random.nextDouble() * 1000;
            Training training = new Training(course, startDate, endDate, pricePerStudent);
            int enrolledCount = 0;
            while (enrolledCount < 10) {
                int randomIndex = random.nextInt(students.size());
                Student student = students.get(randomIndex);
                if (training.enroll(student)) {
                    enrolledCount++;
                }
            }
            trainings.add(training);
        }
        for(Training training : trainings){
            System.out.println(training);
        }
        trainings.get(0).printToFile();
    }

    private static ArrayList<Course> readCourses(String filename) {
        ArrayList<Course> courses = new ArrayList<>();
        File file = new File(filename);
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String[] line = input.nextLine().trim().split(",");
                courses.add(new Course(line[0], line[1], Integer.parseInt(line[2].trim())));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return courses;
    }

    private static ArrayList<Student> readStudents(String filename) {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(filename);
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String rLine = input.nextLine();
                if (rLine.isEmpty()) {
                    break;
                }
                String[] line = rLine.split(",");
                students.add(new Student(line[0].trim(), line[1].trim(), line[2].trim()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return students;
    }
}