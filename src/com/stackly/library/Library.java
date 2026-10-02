package com.stackly.library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
	ArrayList<Book> books = new ArrayList<>();

	HashMap<String, Book> issuedBooks = new HashMap<>();

	// Add Book
	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book added successfully.");
	}

	// View All Books
	public void viewBooks() {

		if (books.isEmpty()) {
			System.out.println("No books available.");
			return;
		}

		for (Book book : books) {
			book.displayBook();
		}
	}

	// Search Book
	public void searchBook(String search) {

		boolean found = false;

		for (Book book : books) {

			if (book.getBookId().equalsIgnoreCase(search) || book.getBookName().equalsIgnoreCase(search)
					|| book.getAuthor().equalsIgnoreCase(search)) {

				book.displayBook();
				found = true;
			}
		}

		if (!found) {
			System.out.println("Book not found.");
		}
	}

	// Check Availability
	public void checkAvailability(String bookId) {

		for (Book book : books) {

			if (book.getBookId().equalsIgnoreCase(bookId)) {

				if (book.isAvailable()) {
					System.out.println("Book is Available.");
				} else {
					System.out.println("Book is Issued.");
				}

				return;
			}
		}

		System.out.println("Book not found.");
	}

	// Issue Book
	public void issueBook(String studentId, String bookId) {

		for (Book book : books) {

			if (book.getBookId().equalsIgnoreCase(bookId)) {

				if (!book.isAvailable()) {
					System.out.println("Book is already issued.");
					return;
				}

				book.issueBook();

				issuedBooks.put(studentId, book);

				System.out.println("Book issued successfully.");
				System.out.println("Issue Date : " + book.getIssueDate());
				System.out.println("Due Date   : " + book.getDueDate());

				return;
			}
		}

		System.out.println("Book not found.");
	}

	// Return Book
	public void returnBook(String studentId) {

		Book book = issuedBooks.get(studentId);

		if (book == null) {
			System.out.println("No issued book found for this student.");
			return;
		}

		LocalDate returnDate = LocalDate.now();

		long overdueDays = ChronoUnit.DAYS.between(book.getDueDate(), returnDate);

		if (overdueDays > 0) {

			double fine = overdueDays * 5;

			System.out.println("Book returned late.");
			System.out.println("Late Days : " + overdueDays);
			System.out.println("Fine      : Rs." + fine);

		} else {

			System.out.println("Book returned on time.");
			System.out.println("Fine      : Rs.0");
		}

		book.returnBook();

		issuedBooks.remove(studentId);

		System.out.println("Book returned successfully.");
	}

	// Calculate Fine
	public void calculateFine(String studentId) {

		Book book = issuedBooks.get(studentId);

		if (book == null) {
			System.out.println("No issued book found.");
			return;
		}

		LocalDate today = LocalDate.now();

		long overdueDays = ChronoUnit.DAYS.between(book.getDueDate(), today);

		if (overdueDays > 0) {

			double fine = overdueDays * 5;

			System.out.println("Overdue Days : " + overdueDays);
			System.out.println("Fine         : Rs." + fine);

		} else {

			System.out.println("No fine.");
		}
	}

	// Due Date Reminder
	public void dueDateReminder() {

		LocalDate today = LocalDate.now();

		for (Book book : issuedBooks.values()) {

			long days = ChronoUnit.DAYS.between(today, book.getDueDate());

			if (days >= 0 && days <= 2) {

				System.out.println("Reminder: Book '" + book.getBookName() + "' is due in " + days + " day(s).");
			}
		}
	}

	// Generate Reports
	public void generateReports() {

		System.out.println("\n===== LIBRARY REPORT =====");

		System.out.println("\nAll Books:");
		viewBooks();

		System.out.println("\nIssued Books:");

		if (issuedBooks.isEmpty()) {

			System.out.println("No books are issued.");

		} else {

			for (Book book : issuedBooks.values()) {
				book.displayBook();
			}
		}

		System.out.println("Total Books   : " + books.size());

		System.out.println("Issued Books  : " + issuedBooks.size());

		System.out.println("Available Books : " + (books.size() - issuedBooks.size()));
	}

}
