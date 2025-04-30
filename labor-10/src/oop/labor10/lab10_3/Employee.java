package oop.labor10.lab10_3;

import oop.labor10.lab10_2.MyDate;

public class Employee {
    private String firstName;
    private String lastName;
    private final int ID;
    private double salary;
    private MyDate birthDate;
    private static int counter=0;

    public Employee(String firstName, String lastName, double salary, MyDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthDate = birthDate;
        this.ID = counter++;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID=" + ID +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                '}';
    }
}
