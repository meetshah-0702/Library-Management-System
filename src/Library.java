package src;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

//This code represents a library that manages a collection of books.
public class Library {
    private Map<String, Book> books = new HashMap<>();

    //This method adds a new book to library.
    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    //This method is used to check whether the book is available or not.
    public boolean isBookAvailable(String isbn) {
        return books.containsKey(isbn);
    }

    //This method is used to borrow a book using its ISBN.
    public void borrowBook(String isbn) {
        if (isBookAvailable(isbn)) {
            books.remove(isbn);
        } else {
            throw new IllegalStateException("Book is not available.");
        }
    }

    //This method is used to return a borrowed book.
    public void returnBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    //This method is used to return all the available books in the library.
    public List<Book> viewAvailableBooks() {
        return new ArrayList<>(books.values());
    }

}
