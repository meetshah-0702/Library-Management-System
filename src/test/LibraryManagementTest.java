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

}
