import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryManagementTest {

	@Test
	public void testBookId () throws Exception{
		Book a = new Book(100, "a");
		a = new Book(999, "a");
		Exception exception = assertThrows(Exception.class, () -> {
			Book b = new Book(1000, "a"); 
		}); 
		assertEquals("Invalid book ID", exception.getMessage());
		exception = assertThrows(Exception.class, () -> {
			Book b = new Book(55, "a"); 
		}); 
		assertEquals("Invalid book ID", exception.getMessage());
		exception = assertThrows(Exception.class, () -> {
			Book b = new Book(5555, "a"); 
		}); 
		assertEquals("Invalid book ID", exception.getMessage());
	
	}

	@Test
	public void testBorrowReturn() throws Exception {
		Book b = new Book(100, "b");
		Member m = new Member(1111, "m");
		assertTrue(b.isAvailable());
		Transaction t = Transaction.getInstance();
		assertTrue(t.borrowBook(b, m));
		assertFalse(b.isAvailable());
		assertFalse(t.borrowBook(b, m));
		assertTrue(t.returnBook(b, m));
		assertFalse(t.returnBook(b, m));
	}
}
