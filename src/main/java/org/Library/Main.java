package org.Library;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Library library = new Library();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			printMenu();
			try {
				int choice = sc.nextInt();
				switch (choice) {

					case 1 -> addBook(library);
					case 2 -> removeBook(library);
					case 3 -> updateBook(library);
					case 4 -> library.showBookList();
					case 5 -> searchBook(library);
					case 6 -> borrowingBook(library);
					case 7 -> {
						exit = true;
						System.out.println("Thank you for using the Library Management System. Goodbye!");
					}

					default ->
							System.out.println("Invalid choice. Please enter a number between 1 and 7.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				sc.nextLine();  // Clear the buffer
			}
		}
		sc.close();
	}

	public static void printMenu() {
		System.out.println("-------------------- Welcome to Library Management System --------------------");
		System.out.println("""
                1. Add Book
                2. Remove Book
                3. Update Book
                4. Show Book List
                5. Search Book
                6. Borrow Book
                7. Exit
                """);
		System.out.print("Choice: ");
	}

	public static void addBook(Library library) {
		try {
			library.addBook();
		} catch (IOException e) {
			System.out.println("Error adding book: " + e.getMessage());
		}
	}

	public static void removeBook(Library library) {
		try {
			library.removeBook();
		} catch (IOException e) {
			System.out.println("Error removing book: " + e.getMessage());
		}
	}

	public static void updateBook(Library library) {
		try {
			library.updateBook();
		} catch (IOException e) {
			System.out.println("Error updating book: " + e.getMessage());
		}
	}

	public static void searchBook(Library library) {
		try {
			library.searchBook();
		} catch (IOException e) {
			System.out.println("Error searching for book: " + e.getMessage());
		}
	}

	public static void borrowingBook(Library library) {
		try {
			library.borrowingBook();
		} catch (IOException e) {
			System.out.println("Error borrowing book: " + e.getMessage());
		}
	}
}
