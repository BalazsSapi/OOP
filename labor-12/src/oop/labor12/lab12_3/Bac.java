package oop.labor12.lab12_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Bac {
    private HashMap<Integer, Student> students = new HashMap<>();
    private final String[] subjects = {"magyar", "roman", "matek"};

    public Bac() {
        readNames();
        readSubjects();
    }

    private void readNames() {
        File file = new File("nevek1.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] strArr = line.split(" ");
                students.put(Integer.parseInt(strArr[0]), new Student(Integer.parseInt(strArr[0]), strArr[1], strArr[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
    }

    private void readSubjects() {
        for (String subject : subjects) {
            File file = new File(subject + ".txt");
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] strArr = line.split(" ");
                    Student student = students.get(Integer.parseInt(strArr[0]));
                    if (student != null) {
                        student.addMark(subject, Double.parseDouble(strArr[1]));
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("File not found");
            }
        }
    }

    @Override
    public String toString() {
        return "Bac{" +
                "students=" + students +
                ", subjects=" + Arrays.toString(subjects) +
                '}';
    }

    public ArrayList<Student> notPassedBacs() {
        ArrayList<Student> notPassedBacs = new ArrayList<>();
        for (Integer student : students.keySet()) {
            if (students.get(student).passed() == false) {
                notPassedBacs.add(students.get(student));
            }
        }
        return notPassedBacs;
    }

    public int getSizeOfStudents() {
        return students.size();
    }
}
