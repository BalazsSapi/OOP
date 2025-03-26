package oop.labor04.lab4_extra;

import oop.labor04.lab4_extra.models.*;
import oop.labor04.lab4_extra.utils.*;

import java.time.DayOfWeek;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("AVLMO7", "Anne0", "Bell0", "Dentistry0");
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
        System.out.println(course1);
        // toString javitasa
    }
}
