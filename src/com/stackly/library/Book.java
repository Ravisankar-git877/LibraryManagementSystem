package com.stackly.library;

import java.time.LocalDate;

public class Book {

    private String bookId;
    private String bookName;
    private String author;
    private boolean available;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public Book(String bookId, String bookName, String author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.available = true;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void issueBook() {
        available = false;
        issueDate = LocalDate.now();
        dueDate = issueDate.plusDays(14);
    }

    public void returnBook() {
        available = true;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void displayBook() {
        System.out.println("Book ID       : " + bookId);
        System.out.println("Book Name     : " + bookName);
        System.out.println("Author        : " + author);
        System.out.println("Availability  : " +
                (available ? "Available" : "Issued"));

        if (!available) {
            System.out.println("Issue Date    : " + issueDate);
            System.out.println("Due Date      : " + dueDate);
        }

        System.out.println("----------------------------");
    }

}
