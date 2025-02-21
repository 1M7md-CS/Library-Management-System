package org.Library;

public class Book {
	private String bookId;
	private String title;
	private String author;
	private String subject;
	private boolean available;
	private final int bookNum;

	static int currentBookNumber = 0;

	Book(String bookId, String title, String author, String subject) {

		currentBookNumber++;
		this.bookNum = currentBookNumber;
		this.available = true;
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.subject = subject;


	}

	public void printInfo() {
		System.out.print("Book Number: " + bookNum + "\n" +
						 "ID: " + bookId + "\n" +
						 "Author: " + author + "\n" +
						 "Title: " + title + "\n" +
						 "Subject: " + subject + "\n" +
						 "Available: " + available + "\n");
	}

	public String getId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getSubject() {
		return subject;
	}

	public boolean getAvailability() {
		return available;
	}

	public static int getCurrentIdNumber() {
		return currentBookNumber;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public static void setCurrentIdNumber(int currentIdNumber) {
		Book.currentBookNumber = currentIdNumber;
	}

}
