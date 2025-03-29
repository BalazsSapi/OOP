package oop.labor05.lab5_extra;

import lab2_3.MyDate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Person {
    private final String firstName;
    private String lastName;
    private MyDate dateOfBirth;
    private final String id;
    private final static AtomicInteger counter=new AtomicInteger();
    private List<Book> books=new ArrayList<Book>();

    public Person(String firstName, String lastName, MyDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        id=String.valueOf(firstName.charAt(0))+String.valueOf(lastName.charAt(0))+"_"+String.valueOf(counter.incrementAndGet());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public MyDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", id='" + id + '\'' +
                '}';
    }

    public void borrowBook(Book book){
        books.add(book);
    }

    public void returnBook(int bookId){
        for (Book book : books) {
            if (book.getId()==bookId){
                books.remove(book);
            }
        }
    }

    public String getId() {
        return id;
    }
}
