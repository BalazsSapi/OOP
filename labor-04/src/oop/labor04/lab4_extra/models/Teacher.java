package oop.labor04.lab4_extra.models;

import oop.labor04.lab4_extra.utils.Degree;
import oop.labor04.lab4_extra.utils.Department;

public class Teacher {
    public static int currentNumberOfTeachers = 0;
    private final String teacherID;
    private final String firstName;
    private String lastName;
    private String degree;
    private String department;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDegree(String degree) {
        if(Degree.containsDegree(degree.toUpperCase())==false) {
            Degree.addDegree(degree.toUpperCase());
        }
        this.degree = degree.toUpperCase();
    }

    public void setDepartment(String department) {
        if(Department.containsDepartment(department.toUpperCase())==false) {
            Department.addDepartment(degree.toUpperCase());
        }
        this.department = department.toUpperCase();
    }

    public Teacher(String firstName, String lastName, String degree, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        if(Department.containsDepartment(department.toUpperCase())==false) {
            Department.addDepartment(degree.toUpperCase());
        }
        this.department = department.toUpperCase();
        if(Degree.containsDegree(degree.toUpperCase())==false) {
            Degree.addDegree(degree.toUpperCase());
        }
        this.degree = degree.toUpperCase();
        this.teacherID=String.format("%d08",currentNumberOfTeachers++);
    }

    public String toString(){
        return "Teacher: " + firstName+" "+lastName+":\n\t\t-degree: "+degree+"\n\t\t-department: "+department;
    }

    public String getDegree() {
        return degree;
    }

    public String getDepartment() {
        return department;
    }
}
