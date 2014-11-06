package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import src.Book;

public class BookTest {
	public Book book;
	@Before
	public void setUp() throws Exception {
		book= new Book();
	}

	@Test
	public void testBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testBookDoubleDoubleDoubleBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBasePrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testBasePriceShouldBeSettable() {
		book.setBasePrice(50.49);
		assertEquals(50.49, book.getBasePrice(), 0.01);
	}

	@Test
	public void testGetVat() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetVat() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDiscount() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDiscount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBestSeller() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBestSeller() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSellPrice() {
		fail("Not yet implemented");
	}

}
