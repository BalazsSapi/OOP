package oop.labor05.lab5_extra;

import java.util.concurrent.atomic.AtomicInteger;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private int numPages;
    private final int id;
    private boolean checkedOut;
    private static final AtomicInteger count=new AtomicInteger();

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.id = count.incrementAndGet();
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumPages() {
        return numPages;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return title+" by "+author+ " (id: "+id+")";
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public int compareTo(Book book) {
        return title.compareTo(book.title);
    }

    public int compareToAuthorAndPages(Book book) {
        if (author.compareTo(book.author) == 0) {
            return book.numPages-numPages;
        }
        else {
            return author.compareTo(book.author);
        }
    }
}
