package lab3_extra;

import lab3_extra.enums.Degree;
import lab3_extra.enums.Department;
import lab3_extra.enums.Major;
import lab3_extra.models.Course;
import lab3_extra.models.Student;
import lab3_extra.models.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.Scanner;


public class Main {

    public static void enrolledStudentsByMajor(Major major, String courseID, Course[] courses,int coursesLength) {
        for (int i = 0; i < coursesLength; i++) {
            if (courses[i].getCourseID().equals(courseID)) {
                for (int j = 0; j < courses[i].getNumberOfEnrolledStudents(); j++) {
                    if (courses[i].getStudentOnIndexGiven(j).getMajor() == major) {
                        System.out.println(courses[i].getStudentOnIndexGiven(j));
                    }
                }
            }
        }
    }

    public static Course[] coursesByTeacherDegree(Degree degree,Course[] courses,int coursesLength) {
        Course[] coursesByDegree = new Course[coursesLength];
        int j=0;
        for (int i = 0; i < coursesLength; i++) {
            if(courses[i].getTeacher().getDegree().equals(degree)) {
                coursesByDegree[j++]=courses[i];
            }
        }
        return coursesByDegree;

    }

    public static int nrOfCoursesByDay(DayOfWeek day, Course[] courses,int coursesLength) {
        int nrOfCoursesByDay = 0;
        for (int i = 0; i < coursesLength; i++) {
            if(courses[i].getDayOfCourse().equals(day)) {
                nrOfCoursesByDay++;
            }
        }
        return nrOfCoursesByDay;
    }

    public static void cancelEnrollments(String fileName,Course[] courses,int coursesLength) {
        try{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int i = 0; i < coursesLength; i++) {
                    courses[i].cancelEnrollmentOfStudent(line);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public static void main(String[] args) {
        /*Student student1 = new Student("12345678","Balazs","Domokos", Major.COMPUTER_SCIENCE);
        Student student2 = new Student("AVLMO7", "Anne", "Bell", Major.INFORMATION_SCIENCE);
        Teacher teacher1 = new Teacher("Suzanne", "Grey", Degree.DOCENT, Department.MATHEMATICS_INFORMATICS);
        Course course1 = new Course("MB_INFO20", 5, DayOfWeek.FRIDAY);
        course1.assignTeacher(teacher1);
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        System.out.println(course1);*/
        final int MAX_COURSES=50;
        int coursesLength = 0;
        Course[]  courses = new Course[MAX_COURSES];
        try{
            File file = new File("university.csv");
            Scanner scanner= new Scanner(file);
            while(scanner.hasNextLine()){
                String[] courseLine = scanner.nextLine().split(",");
                courses[coursesLength]=new Course(courseLine[0],Integer.parseInt(courseLine[1]),DayOfWeek.values()[Integer.parseInt(courseLine[2])-1]);
                String[] teacherLine = scanner.nextLine().split(",");
                Teacher teacher=new Teacher(teacherLine[0],teacherLine[1],Degree.valueOf(teacherLine[2]),Department.values()[Integer.parseInt(teacherLine[3])-1]);
                courses[coursesLength].assignTeacher(teacher);
                coursesLength++;
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error opening input file!");
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
        try {
            File file = new File("students.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] studentLine = scanner.nextLine().split(",");
                Student student = new Student(studentLine[0], studentLine[1], studentLine[2], Major.valueOf(studentLine[3]));
                String[] coursesLine = scanner.nextLine().split(",");
                for (int j = 0; j < coursesLine.length; j++) {
                    for (int i = 0; i < coursesLength; i++) {
                        if (courses[i].getCourseID().equals(coursesLine[j])) {
                            courses[i].enrollStudent(student);
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error opening input file!");
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
        for(int i=0;i<coursesLength;i++){
            System.out.println(courses[i]);
        }
        /*System.out.println("\n\n\n\n\n");
        enrolledStudentsByMajor(Major.AUTOMATION_AND_APPLIED_INFORMATICS,"OSX7G",courses,coursesLength);*/
        /*System.out.println("\n\n\n\n\n");
        Course[] coursesByDegree=coursesByTeacherDegree(Degree.PROFESSOR,courses,coursesLength);
        for(int i=0;i<coursesByDegree.length;i++){
            if(coursesByDegree[i]!=null){
                System.out.println(coursesByDegree[i]);
            }
        }*/
        /*System.out.println(nrOfCoursesByDay(DayOfWeek.MONDAY, courses, coursesLength));*/
        cancelEnrollments("cancellation.csv",courses,coursesLength);
        System.out.println("\nCanceled enrollments!\n\n");
        for(int i=0;i<coursesLength;i++){
            System.out.println(courses[i]);
        }
    }
}
