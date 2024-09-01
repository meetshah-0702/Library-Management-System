package src.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import src.Library;
import src.Book;

public class LibraryManagementTest {

    @Test
    public void testAddBookFailed() {
        Library library = new Library();
        Book book = new Book("123456789", "Effective Java", "Joshua Bloch", 2008);

        assertTrue(library.isBookAvailable("123456789"));
    }


    @Test
    public void testAddBookSuccess() {
        Library library = new Library();
        Book book = new Book("123456789", "Effective Java", "Joshua Bloch", 2008);
        library.addBook(book);

        assertTrue(library.isBookAvailable("123456789"));
    }

    @Test
    public void TestCaseFailedAsBookNotAvailableAfterBorrow() {
        Library library = new Library();
        Book book = new Book("123456789", "Effective Java", "Joshua Bloch", 2008);
        library.addBook(book);
        library.borrowBook("123456789");


        assertTrue(library.isBookAvailable("123456789"));
    }

    @Test
    public void TestCasePassedAsBookIsAvailableAfterBorrow() {
        Library library = new Library();
        Book book = new Book("123456789", "Effective Java", "Joshua Bloch", 2008);
        library.addBook(book);
        library.borrowBook("123456789");


        assertFalse(library.isBookAvailable("123456789"));
    }

}
