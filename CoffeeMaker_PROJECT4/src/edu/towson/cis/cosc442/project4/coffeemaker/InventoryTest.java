package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
	private Inventory i;
	private Recipe r1;

	@Before
	public void setUp() throws Exception {
		i = new Inventory();
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtCoffee(10);
		r1.setAmtMilk(10);
		r1.setAmtSugar(2);
		r1.setAmtChocolate(0);
	}

	@Test
	public void testInventory() {
		assertEquals(15, i.getCoffee());
		assertEquals(15, i.getSugar());
		assertEquals(15, i.getMilk());
		assertEquals(15, i.getChocolate());
	}
	
	@Test
	public void testGetChocolate() {
		assertEquals(15, i.getChocolate());
	}

	@Test
	public void testSetChocolate1() {
		i.setChocolate(50);
		assertEquals(50, i.getChocolate());
	}
	@Test
	public void testSetChocolate2() {
		i.setChocolate(-1);
		assertEquals(0, i.getChocolate());
	}

	@Test
	public void testGetCoffee() {
		assertEquals(15, i.getCoffee());
	}

	@Test
	public void testSetCoffee1() {
		i.setCoffee(40);
		assertEquals(40, i.getCoffee());
	}
	
	@Test
	public void testSetCoffee2() {
		i.setCoffee(-1);
		assertEquals(0, i.getCoffee());
	}

	@Test
	public void testGetMilk() {
		assertEquals(15, i.getMilk());
	}

	@Test
	public void testSetMilk1() {
		i.setMilk(30);
		assertEquals(30, i.getMilk());
	}
	
	@Test
	public void testSetMilk2() {
		i.setMilk(-1);
		assertEquals(0, i.getMilk());
	}
	
	@Test
	public void testGetSugar() {
		assertEquals(15, i.getSugar());
	}

	@Test
	public void testSetSugar1() {
		i.setSugar(100);
		assertEquals(100, i.getSugar());
	}
	
	@Test
	public void testSetSugar2() {
		i.setSugar(-1);
		assertEquals(0, i.getSugar());
	}

	@Test
	public void testEnoughIngredients1() {
		assertTrue(i.enoughIngredients(r1));
	}
	
	@Test
	public void testEnoughIngredients2() {
		r1.setAmtCoffee(100);
		r1.setAmtMilk(100);
		r1.setAmtSugar(100);
		r1.setAmtChocolate(100);
		
		assertFalse(i.enoughIngredients(r1));
	}

	@Test
	public void testToString() {
		assertEquals("Coffee: " + "15" + System.lineSeparator() +"Milk: " + "15" + System.lineSeparator() + "Sugar: " + "15" + System.lineSeparator() + "Chocolate: " + "15" + System.lineSeparator(), i.toString());
	}

	@After
	public void tearDown() throws Exception {
		i = null;
		r1 = null;
	}

}
