package lab3_extra.models;

import lab3_extra.enums.Major;

public class Student {
    private String neptunCode;
    private String firstName;
    private String lastName;
    private Major major;

    public Student(String neptunCode, String firstName, String lastName, Major major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.neptunCode = neptunCode;
        this.major = major;
    }

    public String toString(){
        return "\t\t* " + firstName + " " + lastName+": \n\t\t\t- Neptun ID: " + neptunCode + "\n\t\t\t- Major: " + major ;
    }

    public String getNeptunCode() {
        return neptunCode;
    }

    public Major getMajor() {
        return major;
    }
}
