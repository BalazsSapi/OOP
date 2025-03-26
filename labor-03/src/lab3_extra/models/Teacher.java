package lab3_extra.models;

import lab3_extra.enums.Degree;
import lab3_extra.enums.Department;

public class Teacher {
    public static int currentNumberOfTeachers = 0;
    private String teacherID;
    private String firstName;
    private String lastName;
    private Degree degree;
    private Department department;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Teacher(String firstName, String lastName, Degree degree, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
        this.department = department;
        this.teacherID=String.format("%d08",currentNumberOfTeachers++);
    }

    public String toString(){
        return "Teacher: " + firstName+" "+lastName+":\n\t\t-degree: "+degree+"\n\t\t-department: "+department;
    }

    public Degree getDegree() {
        return degree;
    }
}
