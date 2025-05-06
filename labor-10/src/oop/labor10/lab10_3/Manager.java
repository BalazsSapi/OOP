package oop.labor10.lab10_3;


import oop.labor10.lab10_2.MyDate;

public class Manager extends Employee{
    private String department;

    public Manager(String firstName, String lastName, double salary, MyDate birthDate, String department) {
        super(firstName, lastName, salary, birthDate);
        this.department=department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", ID='" + super.getID() + '\'' +
                ", salary=" + super.getSalary() +
                ", birthDate=" + super.getBirthDate() +
                ", department='" + department + '\'' +
                '}';
    }
}
