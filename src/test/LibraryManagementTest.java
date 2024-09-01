package src.test;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.platform.commons.util.ExceptionUtils;
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

    @Test
    public void TestCaseForHandlingExceptionWhileBorrowimgBook() {
        Library library = new Library();
        Book book = new Book("123456789", "Effective Java", "Joshua Bloch", 2008);



        Throwable exception = assertThrows(IllegalStateException.class, () -> library.borrowBook("123456789"));
        assertEquals("Book is not available.", exception.getMessage());
    }

    @Test
    public void testFailedWhileReturningBook() {
        Library library = new Library();
        Book book = new Book("123456789", "Effective Java", "Joshua Bloch", 2008);
        library.addBook(book);
        library.borrowBook("123456789");
        library.returnBook(book);

        assertFalse(library.isBookAvailable("123456789"));
    }

    @Test
    public void testPassedWhileReturningBook() {
        Library library = new Library();
        Book book = new Book("123456789", "Effective Java", "Joshua Bloch", 2008);
        library.addBook(book);
        library.borrowBook("123456789");
        library.returnBook(book);

        assertTrue(library.isBookAvailable("123456789"));
    }

    @Test
    public void testFailedForViewingAllAvailableBooks() {
        Library library = new Library();
        Book book1 = new Book("123456789", "Effective Java", "Joshua Bloch", 2008);
        Book book2 = new Book("987654321", "Clean Code", "Robert C. Martin", 2008);
        library.addBook(book1);
        library.addBook(book2);

        library.borrowBook("987654321");

        List<Book> availableBooks = library.viewAvailableBooks();

        assertEquals(2, availableBooks.size());
        assertTrue(availableBooks.contains(book1));
        assertTrue(availableBooks.contains(book2));
    }

    @Test
    public void testPassedForViewingAllAvailableBooks() {
        Library library = new Library();
        Book book1 = new Book("123456789", "Effective Java", "Joshua Bloch", 2008);
        Book book2 = new Book("987654321", "Clean Code", "Robert C. Martin", 2008);
        library.addBook(book1);
        library.addBook(book2);

        library.borrowBook("987654321");
        library.returnBook(book2);

        List<Book> availableBooks = library.viewAvailableBooks();

        assertEquals(2, availableBooks.size());
        assertTrue(availableBooks.contains(book1));
        assertTrue(availableBooks.contains(book2));
    }


}
