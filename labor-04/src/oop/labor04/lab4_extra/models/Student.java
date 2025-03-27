package oop.labor04.lab4_extra.models;

import oop.labor04.lab4_extra.utils.Major;

public class Student {
    private final String neptunCode;
    private final String firstName;
    private final String lastName;
    private int major;

    public Student(String neptunCode, String firstName, String lastName, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.neptunCode = neptunCode;
        if(Major.containsMajor(major)==false) {
            Major.addMajor(major.toUpperCase());
        }
        this.major=Major.valueOf(major.toUpperCase());
    }

    public String toString(){
        return "* " + firstName + " " + lastName+": \n\t\t\t- Neptun ID: " + neptunCode + "\n\t\t\t- Major: " + Major.indexToString(major);
    }

    public String getNeptunCode() {
        return neptunCode;
    }

    public String getMajor() {
        return Major.indexToString(major);
    }
}
