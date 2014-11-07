package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
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
		assertEquals(50.49, book.getBasePrice(), 0);
	}
	//====================
	@Test
	@Ignore
	public void testBasePriceShouldBeGreaterThanZero() {
		book.setBasePrice(-1);
		assertEquals(0.0, this.book.getBasePrice(), 0);
	}
	
	@Test
	@Ignore
	public void testOnCreateBasePriceShouldBeGreaterThanZero() {
		this.book= new Book(-1.0, 0.0, 0.0, false);
		assertEquals(0.0, this.book.getBasePrice(), 0);
	}
	
	@Test
	public void testBasePriceShouldBeSetToZeroIfUserSetItNegative() {
		this.book.setBasePrice(-1.0);
		assertEquals(0.0, this.book.getBasePrice(), 0);
	}
	
	@Test
	public void testOnCreateBasePriceShouldBeSetToZeroIfNegative() {
		this.book = new Book(-10,10,10,false);
		assertEquals(0.0, this.book.getBasePrice(), 0);
	}
	
	//=========================
	
	@Test
	public void testVATshouldBeSettable() {
		double expected = 0.1;
		this.book.setVat(expected);
		assertEquals(expected, this.book.getVat(), 0.0);
	}
	

	
	@Test
	public void testDiscountShouldBeSettable() {
		double expected = 0.1;
		this.book.setDiscount(expected);
		assertEquals(expected, this.book.getDiscount(), 0.0);
	}
	
	@Test
	@Ignore
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
	
	@Test
	public void testBestSellerRealDiscountIsFiftyPercentOfActualDiscount() {
		double expected= 6.0;
		this.book = new Book(10,50,10,false);
		assertEquals(expected, this.book.getSellPrice(), 0);
		
		this.book.setBestSeller();
		expected=8.5;
		assertEquals(expected, this.book.getSellPrice(), 0);
	}
	
	@Test
	public void testBestSellerAttributShouldBeSettable() {
		assertFalse(this.book.getBestSeller());
		this.book.setBestSeller();
		assertTrue(this.book.getBestSeller());
	}
	

	
	@Ignore
	@Test
	public void testVATshouldBeGreaterOrEqualToZero() {
		this.book.setVat(-0.1);
		assertEquals(0, this.book.getVat(), 0);
	}
	
	@Test
	public void testVATsetToZeroIfUserTryNegativeValue() {
		this.book.setVat(-10);
		assertEquals(0.0, this.book.getVat(), 0);
	}
	
	@Test
	public void testOnCreateVATSetToZeroIfUserEnterNegativeValue() {
		this.book = new Book(10,10,-10,false);
		assertEquals(0.0, this.book.getVat(), 0);
	}
	
	@Test
	public void testDiscountsetToZeroIfUserTryNegativeValue() {
		this.book.setDiscount(-10);
		assertEquals(0.0, this.book.getDiscount(), 0);
	}
	
	@Test
	public void testOnCreateDiscountSetToZeroIfUserEnterNegativeValue() {
		this.book = new Book(10,-10,10,false);
		assertEquals(0.0, this.book.getDiscount(), 0);
	}
	
}
