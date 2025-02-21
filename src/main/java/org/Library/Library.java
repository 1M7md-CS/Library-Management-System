package org.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryInterface {

	private final ArrayList<Book> bookArrayList;
	private final BufferedReader reader;

	Library() {
		bookArrayList = new ArrayList<>();
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public void addBook() throws IOException {
		System.out.print("Enter Book ID: ");
		String bookId = reader.readLine();
		if (bookIdAlreadyExist(bookId)) {
			System.out.println("Book with ID: \"" + bookId + "\" already exists. Please enter a unique ID.\n");
			return;
		}
		System.out.print("Enter Book Title: ");
		String title = reader.readLine();

		System.out.print("Enter Book Author: ");
		String author = reader.readLine();

		System.out.print("Enter Book Subject: ");
		String subject = reader.readLine();

		bookArrayList.add(new Book(bookId, title, author, subject));
		System.out.println("Book added successfully!\n");
	}

	public void removeBook() throws IOException {
		if (isEmpty()) return;

		System.out.print("Enter Book ID: ");
		String bookId = reader.readLine();
		boolean isRemoved = bookArrayList.removeIf(book -> bookId.equals(book.getId()));
		if (isRemoved) {
			System.out.println("Book removed successfully.\n");
		} else {
			System.out.println("Book with ID " + bookId + " not found.\n");
		}
	}

	public void updateBook() throws IOException {
		if (isEmpty()) return;

		System.out.println("Enter Book ID: ");
		String bookId = reader.readLine();

		boolean bookFound = false;

		for (Book book : bookArrayList) {
			if (book.getId().equals(bookId)) {
				bookFound = true;

				System.out.print("Update Author? (y/n): ");
				String input = reader.readLine();
				if (input.equalsIgnoreCase("y")) {
					System.out.print("Enter new Author: ");
					String author = reader.readLine();
					book.setAuthor(author);
				}

				System.out.print("Update Title? (y/n): ");
				input = reader.readLine();
				if (input.equalsIgnoreCase("y")) {
					System.out.print("Enter new Title: ");
					String title = reader.readLine();
					book.setTitle(title);
				}

				System.out.print("Update Subject? (y/n): ");
				input = reader.readLine();
				if (input.equalsIgnoreCase("y")) {
					System.out.print("Enter new Subject: ");
					String subject = reader.readLine();
					book.setSubject(subject);
				}

				System.out.println("Book details updated successfully.\n");
				break;
			}
		}

		if (!bookFound) {
			System.out.println("Book with ID \"" + bookId + "\" not found.\n");
		}
	}

	public void showBookList() {
		if (isEmpty()) return;
		printBookList();
	}

	public void searchBook() throws IOException {
		if (isEmpty()) return;

		System.out.println("""
                Search Book With:
                
                1. ID
                2. Title
                3. Author
                4. Subject
                """);

		System.out.print("Choose: ");
		int input;

		try {
			input = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a number between 1 and 4.\n");
			return;
		}

		boolean bookFound = false;
		switch (input) {
			case 1 -> {
				System.out.print("Enter Book ID: ");
				String bookId = reader.readLine();
				Book book = searchById(bookId);
				if (book == null) {
					System.out.println("Book not found.\n");
					return;
				}

				System.out.println("Book found\nDetails: ");
				book.printInfo();
				return;
			}
			case 2 -> {
				System.out.print("Enter Book Title: ");
				String bookTitle = reader.readLine();
				List<Book> books = searchByTitle(bookTitle);
				if (checkTheArraySize(books, "Title")) {
					bookFound = true;
				}
			}
			case 3 -> {
				System.out.print("Enter Book Author: ");
				String bookAuthor = reader.readLine();
				List<Book> books = searchByAuthor(bookAuthor);
				if (checkTheArraySize(books, "Author")) {
					bookFound = true;
				}
			}
			case 4 -> {
				System.out.print("Enter Book Subject: ");
				String bookSubject = reader.readLine();
				List<Book> books = searchBySubject(bookSubject);
				if (checkTheArraySize(books, "Subject")) {
					bookFound = true;
				}
			}
			default -> System.out.println("Invalid Choice.\n");
		}

		if (!bookFound && (input >= 1 && input <= 4)) {
			System.out.println("Book not found.\n");
		}
	}

	public void borrowingBook() throws IOException {
		if (isEmpty()) return;
		System.out.print("Enter Book ID: ");
		String bookId = reader.readLine();
		Book book = searchById(bookId);
		if (book != null && book.getAvailability()) {
			System.out.println("Book borrowed successfully.\n");
			book.setAvailable(false);
		} else {
			System.out.println("Book not available or already borrowed.\n");
		}
	}

	public Book searchById(String bookId) {
		for (Book book : bookArrayList) {
			if (book.getId().equals(bookId)) {
				return book;
			}
		}
		return null;
	}

	public List<Book> searchByTitle(String bookTitle) {
		List<Book> foundBooks = new ArrayList<>();
		for (Book book : bookArrayList) {
			if (book.getTitle().equalsIgnoreCase(bookTitle)) {
				foundBooks.add(book);
			}
		}
		if (!foundBooks.isEmpty()) {
			return foundBooks;
		}
		return null;
	}

	public List<Book> searchByAuthor(String bookAuthor) {
		List<Book> foundBooks = new ArrayList<>();
		for (Book book : bookArrayList) {
			if (book.getAuthor().equalsIgnoreCase(bookAuthor)) {
				foundBooks.add(book);
			}
		}
		if (!foundBooks.isEmpty()) {
			return foundBooks;
		}
		return null;
	}

	public List<Book> searchBySubject(String bookSubject) {
		List<Book> foundBooks = new ArrayList<>();
		for (Book book : bookArrayList) {
			if (book.getSubject().equalsIgnoreCase(bookSubject)) {
				foundBooks.add(book);
			}
		}
		if (!foundBooks.isEmpty()) {
			return foundBooks;
		}
		return null;
	}

	public boolean bookIdAlreadyExist(String bookId) {
		for (Book book : bookArrayList) {
			if (book.getId().equals(bookId)) {
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty() {
		if (bookArrayList.isEmpty()) {
			System.out.println("No books available.\n");
			return true;
		} else return false;
	}

	public void printBookList() {
		System.out.println("--------------------Book List--------------------");
		for (Book book : bookArrayList) {
			book.printInfo();
			System.out.println("--------------------");
		}
	}

	public boolean checkTheArraySize(List<Book> books, String criteria) {
		if (books == null || books.isEmpty()) {
			System.out.println("No books found with the given " + criteria + ".\n");
			return false;
		}

		if (books.size() == 1) {
			System.out.println("Book found. Details:");
			books.getFirst().printInfo();
		} else {
			System.out.println("Multiple books found. Details:");
			for (Book book : books) {
				book.printInfo();
				System.out.println("--------------------");
			}
		}
		return true;
	}
}