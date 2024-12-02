import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryManagementTest {

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

}
