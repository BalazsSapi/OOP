package oop.labor04.lab4_extra.models;

import oop.labor04.lab4_extra.models.Student;
import oop.labor04.lab4_extra.models.Teacher;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class Course {
    private int numberOfCredits;
    private String courseID;
    private Teacher teacher;
    private final ArrayList<Student> students=new ArrayList<>();
    DayOfWeek dayOfCourse;

    public Course(String courseID,int numberOfCredits,DayOfWeek dayOfCourse){
        this.courseID = courseID;
        this.numberOfCredits = numberOfCredits;
        this.dayOfCourse = dayOfCourse;
    }

    public void enrollStudent(Student student){
        students.add(student);
    }

    public void cancelEnrollmentOfStudent(String neptunCode){
        for(Student student:students){
            if(student.getNeptunCode().equals(neptunCode)){
                students.remove(student);
                break;
            }
        }
    }

    public String studentsToString(){
        String studentsString="";
        for(Student student:students){
            studentsString+=students.toString();
            studentsString+="\n";
        }
        return studentsString;
    }

    private String studentsToString(ArrayList<Student> students){
        String studentsString="";
        for(Student student:students){
            studentsString+="\t\t"+student+"\n";
        }
        return studentsString;
    }

    public String toString(){
        return "Course: "+courseID+"\n\t"+teacher+"\n\tCredits: "+numberOfCredits + "\n\tOccours every: " + dayOfCourse + "\n\tEnrolled students: " + students.size() + "\n" + studentsToString(students) +"\n";
    }

    public void setTeacher(Teacher teacher){
        this.teacher=teacher;
    }

    public String getCourseID() {
        return courseID;
    }

    public Student getStudentOnIndexGiven(int index){
        return students.get(index);
    }

    public int getNumberOfEnrolledStudents() {
        return students.size();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public DayOfWeek getDayOfCourse() {
        return dayOfCourse;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return students;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }
}
