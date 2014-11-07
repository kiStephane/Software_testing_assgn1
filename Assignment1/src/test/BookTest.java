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
	public void testBasePriceShouldBeSettable() {
		book.setBasePrice(50.49);
		assertEquals(50.49, book.getBasePrice(), 0.01);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBasePriceShouldBePositive() {
		book.setBasePrice(-1);
	}
	
	@Test
	public void testOnCreateBasePriceShouldBeGreaterThanZero() {
		try {
			this.book= new Book(-1.0, 0.0, 0.0, false);
		} catch (IllegalArgumentException e) {
			assertEquals("Base price should be greater than 0", e.getMessage());
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testBasePriceShouldNotBeSetToZero() {
		book.setBasePrice(0);
	}
	
	@Test
	public void testVATshouldBeSettable() {
		double expected = 0.1;
		this.book.setVat(expected);
		assertEquals(expected, this.book.getVat(), 0.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testVATshouldBeGreaterOrEqualToZero() {
		this.book.setVat(-0.1);
	}
	
	@Test
	public void testDiscountShouldBeSettable() {
		double expected = 0.1;
		this.book.setDiscount(expected);
		assertEquals(expected, this.book.getDiscount(), 0.0);
	}
	
	@Test
	public void testDiscountShouldBeGreaterOrEqualToZero() {
		this.book.setDiscount(-1);
		assertEquals(0, this.book.getDiscount(), 0);
	}
	
	@Test
	public void testDiscountShouldBeLessOrEqualThanFiftyPercent() {
		this.book.setDiscount(50.01);
		assertEquals(50, this.book.getDiscount(), 0);
	}
	
	@Test
	public void testSystemShouldCalculateSellPriceAfterAnyVariableChange() {
		double expectedSellPrice=10;
		this.book.setBasePrice(10);
		assertEquals(expectedSellPrice, this.book.getSellPrice(), 0);
		
		this.book.setDiscount(50);
		expectedSellPrice=5.0;
		assertEquals(expectedSellPrice, this.book.getSellPrice(),0);
		
		this.book.setVat(10);
		expectedSellPrice = 6.0;
		assertEquals(expectedSellPrice, this.book.getSellPrice(),0);
		
		this.book.setBestSeller();
		expectedSellPrice = 8.5;
		assertEquals(expectedSellPrice, this.book.getSellPrice(),0);		
	}
	
	@Test
	public void testOnCreateSellPriceShouldBeCalculated() {
		double expected= 8.5;
		this.book = new Book(10,50,10,true);
		assertEquals(expected, this.book.getSellPrice(), 0);
	}
	
	
	
	



}
