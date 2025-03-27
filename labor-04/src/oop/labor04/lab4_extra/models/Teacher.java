package oop.labor04.lab4_extra.models;

import oop.labor04.lab4_extra.utils.Degree;
import oop.labor04.lab4_extra.utils.Department;

public class Teacher {
    public static int currentNumberOfTeachers = 0;
    private final String teacherID;
    private final String firstName;
    private String lastName;
    private int degree;
    private int department;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDegree(String degree) {
        if(Degree.containsDegree(degree.toUpperCase())==false) {
            Degree.addDegree(degree.toUpperCase());
        }
        this.degree = Degree.valueOf(degree.toUpperCase());
    }

    public void setDepartment(String department) {
        if(Department.containsDepartment(department.toUpperCase())==false) {
            Department.addDepartment(department.toUpperCase());
        }
        this.department = Department.valueOf(department.toUpperCase());
    }

    public Teacher(String firstName, String lastName, String degree, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        if(Department.containsDepartment(department.toUpperCase())==false) {
            Department.addDepartment(department.toUpperCase());
        }
        this.department = Department.valueOf(department.toUpperCase());
        if(Degree.containsDegree(degree.toUpperCase())==false) {
            Degree.addDegree(degree.toUpperCase());
        }
        this.degree = Degree.valueOf(degree.toUpperCase());
        this.teacherID=String.format("%d08",currentNumberOfTeachers++);
    }

    public String toString(){
        return "Teacher: " + firstName+" "+lastName+":\n\t\t-degree: "+Degree.indexToString(degree)+"\n\t\t-department: "+Department.indexToString(department);
    }

    public String getDegree() {
        return Degree.indexToString(degree);
    }

    public String getDepartment() {
        return Degree.indexToString(department);
    }
}
