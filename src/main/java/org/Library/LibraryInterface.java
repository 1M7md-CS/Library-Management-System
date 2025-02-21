package org.Library;

import java.io.IOException;

public interface LibraryInterface {

	void addBook() throws IOException;
	void removeBook() throws IOException;
	void updateBook() throws IOException;
	void showBookList() ;
	void searchBook() throws IOException;
	void borrowingBook() throws IOException;
	//void generateReport();

}
