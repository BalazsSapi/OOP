package oop.labor05.lab5_extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private final String address;
    private final String name;
    private List<Book>books  = new ArrayList<Book>();

    public Library(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public boolean checkoutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.isCheckedOut()==false) {
                book.setCheckedOut(true);
                return true;
            }
        }
        return false;
    }

    public void returnBook(Book book) {
        book.setCheckedOut(false);
    }

    public void addBook(Book book) {
        books.add(book);
        book.setCheckedOut(false);
    }

    public void sortBooks() {
        books.sort(Book::compareTo);
    }

    public void sortBooksByAuthorAndPages() {
        books.sort(Book::compareToAuthorAndPages);
    }

    public int countBooks() {
        return books.size();
    }

    public Book findBookBy(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    private String booksToString(){
        String str="";
        int i=1;
        for(Book book : books){
            str+=Integer.toString(i)+". "+book + "\n";
            i++;
        }
        return str;
    }

    public String toString(){
        return "The " + name + " library has " + books.size() + " books:\n" + booksToString();
    }

    public String getName() {
        return name;
    }
}
