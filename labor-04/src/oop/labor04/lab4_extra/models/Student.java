package oop.labor04.lab4_extra.models;

import oop.labor04.lab4_extra.utils.Major;

public class Student {
    private final String neptunCode;
    private final String firstName;
    private final String lastName;
    private String major;

    public Student(String neptunCode, String firstName, String lastName, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.neptunCode = neptunCode;
        if(Major.containsMajor(major)==false) {
            Major.addMajor(major.toUpperCase());
        }
        this.major=major.toUpperCase();
    }

    public String toString(){
        return "\t\t* " + firstName + " " + lastName+": \n\t\t\t- Neptun ID: " + neptunCode + "\n\t\t\t- Major: " + major ;
    }

    public String getNeptunCode() {
        return neptunCode;
    }

    public String getMajor() {
        return major;
    }
}
