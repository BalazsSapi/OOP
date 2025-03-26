package lab3_extra.models;

import java.time.DayOfWeek;
import java.util.Arrays;

public class Course {
    public static int MAX_STUDENTS=120;
    private int numberOfCredits;
    private String courseID;
    private Teacher teacher;
    private int numberOfEnrolledStudents;
    private Student[]  students=new Student[MAX_STUDENTS];
    DayOfWeek dayOfCourse;

    public Course(String courseID,int numberOfCredits,DayOfWeek dayOfCourse){
        this.courseID = courseID;
        this.numberOfCredits = numberOfCredits;
        this.dayOfCourse = dayOfCourse;
    }

    public void enrollStudent(Student student){
        if(numberOfEnrolledStudents+1<MAX_STUDENTS){
            students[numberOfEnrolledStudents++]=student;
        }
        else{
            System.out.println("No more space for students in this course!");
        }
    }

    public void cancelEnrollmentOfStudent(String neptunCode){
        for(int i=0;i<numberOfEnrolledStudents;i++){
            if(students[i].getNeptunCode().equals(neptunCode)){
                for(int j=i+1;j<numberOfEnrolledStudents;j++){
                    students[j-1]=students[j];
                }
                students[--numberOfEnrolledStudents]=null;
                return;
            }
        }
    }

    public String studentsToString(){
        String studentsString="";
        for(int i=0;i<numberOfEnrolledStudents;i++){
            studentsString+=students[i].toString();
            studentsString+="\n";
        }
        return studentsString;
    }

    public String toString(){
        return "Course: "+courseID+"\n\t"+teacher+"\n\tCredits: "+numberOfCredits + "\n\tOccours every: " + dayOfCourse + "\n\tEnrolled students: " + numberOfEnrolledStudents + "\n" + studentsToString() +"\n";
    }

    public void assignTeacher(Teacher teacher){
        this.teacher=teacher;
    }

    public String getCourseID() {
        return courseID;
    }

    public Student getStudentOnIndexGiven(int index){
        return students[index];
    }

    public int getNumberOfEnrolledStudents() {
        return numberOfEnrolledStudents;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public DayOfWeek getDayOfCourse() {
        return dayOfCourse;
    }
}
