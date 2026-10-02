package com.stackly.library;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Check Book Availability");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Calculate Fine");
            System.out.println("8. Due Date Reminder");
            System.out.println("9. Generate Reports");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    String bookId = sc.next();

                    System.out.print("Enter Book Name: ");
                    String bookName = sc.next();

                    System.out.print("Enter Author: ");
                    String author = sc.next();

                    Book book =
                            new Book(bookId, bookName, author);

                    library.addBook(book);

                    break;

                case 2:

                    library.viewBooks();

                    break;

                case 3:

                    System.out.print(
                            "Enter Book ID / Name / Author: ");

                    String search = sc.next();

                    library.searchBook(search);

                    break;

                case 4:

                    System.out.print("Enter Book ID: ");

                    String availabilityId = sc.next();

                    library.checkAvailability(availabilityId);

                    break;

                case 5:

                    System.out.print("Enter Student ID: ");
                    String studentId = sc.next();

                    System.out.print("Enter Book ID: ");
                    String issueBookId = sc.next();

                    library.issueBook(
                            studentId,
                            issueBookId);

                    break;

                case 6:

                    System.out.print("Enter Student ID: ");

                    String returnStudentId = sc.next();

                    library.returnBook(
                            returnStudentId);

                    break;

                case 7:

                    System.out.print("Enter Student ID: ");

                    String fineStudentId = sc.next();

                    library.calculateFine(
                            fineStudentId);

                    break;

                case 8:

                    library.dueDateReminder();

                    break;

                case 9:

                    library.generateReports();

                    break;

                case 10:

                    System.out.println(
                            "Thank you for using Library Management System.");

                    break;

                default:

                    System.out.println(
                            "Invalid choice.");
            }

        } while (choice != 10);

        sc.close();
    }

}
