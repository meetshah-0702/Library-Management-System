package src;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public boolean isBookAvailable(String isbn) {
        return books.containsKey(isbn);
    }

    public void borrowBook(String isbn) {
        if (isBookAvailable(isbn)) {
            books.remove(isbn);
        } else {
            throw new IllegalStateException("Book is not available.");
        }
    }

    public void returnBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public List<Book> viewAvailableBooks() {
        return new ArrayList<>(books.values());
    }


}
