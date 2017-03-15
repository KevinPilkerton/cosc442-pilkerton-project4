package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecipeTest 
{
Recipe r;
Recipe r1;

	@Before
	public void setUp() throws Exception {
		r = new Recipe();
		r.setName("Mocha");
		r.setPrice(2);
		r.setAmtCoffee(10);
		r.setAmtMilk(10);
		r.setAmtSugar(10);
		r.setAmtChocolate(10);
		
		r1 = new Recipe();
		r1.setPrice(2);
		r1.setAmtCoffee(2);
		r1.setAmtMilk(2);
		r1.setAmtSugar(2);
		r1.setAmtChocolate(2);
		
	}

	@Test
	public void testGetAmtChocolate1() {
		assertEquals(10, r.getAmtChocolate());
	}
	@Test
	public void testGetAmtChocolate2() {
		r.setAmtChocolate(-1);
		assertEquals(0, r.getAmtChocolate());
	}

	@Test
	public void testSetAmtChocolate() {
		r.setAmtChocolate(400);
		assertEquals(400, r.getAmtChocolate());
	}

	@Test
	public void testGetAmtCoffee1() {
		assertEquals(10,  r.getAmtCoffee());
	}
	
	@Test
	public void testGetAmtCoffee2() {
		r.setAmtCoffee(-1);
		assertEquals(0, r.getAmtCoffee());
	}

	@Test
	public void testSetAmtCoffee() {
		r.setAmtCoffee(500);
		assertEquals(500, r.getAmtCoffee());
	}

	@Test
	public void testGetAmtMilk1() {
		assertEquals(10, r.getAmtMilk());
	}
	
	@Test
	public void testGetAmtMilk2() {
		r.setAmtMilk(-1);
		assertEquals(0, r.getAmtMilk());
	}

	@Test
	public void testSetAmtMilk() {
		r.setAmtMilk(1000);
		assertEquals(1000, r.getAmtMilk());
	}

	@Test
	public void testGetAmtSugar1() {
		assertEquals(10, r.getAmtSugar());
	}
	
	@Test
	public void testGetAmtSugar2() {
		r.setAmtSugar(-1);
		assertEquals(0, r.getAmtSugar());
	}

	@Test
	public void testSetAmtSugar() {
		r.setAmtSugar(1000);
		assertEquals(1000, r.getAmtSugar());
	}

	@Test
	public void testGetName() {
		assertTrue(r.getName().equals("Mocha"));
	}

	@Test
	public void testSetName() {
		r.setName("Coffee");
		assertTrue(r.getName().equals("Coffee"));
	}

	@Test
	public void testGetPrice() {
		assertEquals(2, r.getPrice());
	}

	@Test
	public void testSetPrice1() {
		r.setPrice(10);
		assertEquals(10, r.getPrice());
	}
	
	@Test
	public void testSetPrice2() {
		r.setPrice(-1);
		assertEquals(0, r.getPrice());
	}

	@Test
	public void testEqualsRecipe1() {
		Recipe r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtCoffee(10);
		r2.setAmtMilk(10);
		r2.setAmtSugar(10);
		r2.setAmtChocolate(10);
		
		assertTrue(r.equals(r2));
	}
	
	@Test
	public void testEqualsRecipe2() {
		Recipe r2 = new Recipe();
		r2.setAmtCoffee(5);
		r2.setAmtMilk(5);
		r2.setAmtSugar(5);
		r2.setAmtChocolate(5);
		
		assertFalse(r.equals(r2));
	}
	
	@Test
	public void testEqualsRecipe3(){
		Recipe r2 = new Recipe();
		r2.setName("Coffee");
		r2.setPrice(100);
		r2.setAmtCoffee(100);
		r2.setAmtMilk(10);
		r2.setAmtSugar(50);
		r2.setAmtChocolate(5);
		assertFalse(r.equals(r2));
	}
	@Test
	public void testEqualsRecipe4(){
		assertFalse(r1.equals(r));
	}

	@Test
	public void testToString() {
		assertEquals("Mocha", r.toString());
	}

	@After
	public void tearDown() throws Exception {
		r = null;
		r1 = null;
	}
}
