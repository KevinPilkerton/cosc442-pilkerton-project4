package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class CoffeeMakerTest {
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;
	
	@Before
	public void setUp() throws Exception{
		cm = new CoffeeMaker();
		i = cm.checkInventory();

		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(3);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
	}
	@Test
	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}
	@Test
	public void testAddRecipe2()
	{
		cm.addRecipe(r1);
		assertFalse(cm.addRecipe(r1));
	}
	@Test
	public void testAddRecipe3()
	{
		r1.setPrice(-1);
		assertTrue(cm.addRecipe(r1));
	}
	@Test
	public void testAddRecipe4a()
	{
		r1.setAmtCoffee(-3);
		assertTrue(cm.addRecipe(r1));
	}
	@Test
	public void testAddRecipe4b()
	{
		r1.setAmtMilk(-1);
		assertTrue(cm.addRecipe(r1));
	}
	@Test
	public void testAddRecipe4c()
	{
		r1.setAmtSugar(-1);
		assertTrue(cm.addRecipe(r1));
	}
	@Test
	public void testAddRecipe4d()
	{
		r1.setAmtChocolate(-1);
		assertTrue(cm.addRecipe(r1));
	}
	@Test
	public void testAddRecipe5()
	{
		Recipe r2 = new Recipe();
		r2.setName("Coffee2");
		r2.setAmtCoffee(1);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(1);
		
		Recipe r3 = new Recipe();
		r3.setName("Coffee3");
		r3.setAmtCoffee(1);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(1);
		
		Recipe r4 = new Recipe();
		r4.setName("Coffee4");
		r4.setAmtCoffee(1);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(1);
		
		Recipe r5 = new Recipe();
		r5.setName("Coffee5");
		r5.setAmtCoffee(1);
		r5.setAmtMilk(1);
		r5.setAmtSugar(1);
		r5.setAmtChocolate(1);
		
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		assertFalse(cm.addRecipe(r5));
	}
	@Test
	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}
	@Test
	public void testDeleteRecipe2() {
		assertFalse(cm.deleteRecipe(null));
	}
	@Test
	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	@Test
	public void testEditRecipe2() {
		assertFalse(cm.editRecipe(null,r1));
	}
	@Test
	public void testEditRecipe3() {
		cm.addRecipe(r1);
		Recipe r2 = new Recipe();
		r2.setName("Milk");
		r2.setPrice(-1);
		r2.setAmtCoffee(0);
		r2.setAmtMilk(20);
		r2.setAmtSugar(0);
		r2.setAmtChocolate(0);
		assertFalse(cm.editRecipe(r1, r2));
	}
	@Test
	public void testEditRecipe4()
	{
		Recipe r2 = new Recipe();
		r2.setName("Coffee2");
		r2.setAmtCoffee(1);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(1);
		
		Recipe r3 = new Recipe();
		r3.setName("Coffee3");
		r3.setAmtCoffee(1);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(1);
		
		Recipe r4 = new Recipe();
		r4.setName("Coffee4");
		r4.setAmtCoffee(1);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(1);
		
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		
		Recipe r5 = new Recipe();
		r5.setName("Coffee3");
		r5.setPrice(1);
		r5.setAmtCoffee(1);
		r5.setAmtMilk(1);
		r5.setAmtSugar(1);
		r5.setAmtChocolate(1);
		
		assertFalse(cm.editRecipe(r2, r5));
	}
	@Test
	public void testAddInventory1() {
		boolean inv = cm.addInventory(1, 1, 1, 1);
		assertTrue(inv);
	}
	@Test
	public void testAddInventory2()
	{
		boolean inv = cm.addInventory(1, 1, 1, -1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory3()
	{
		boolean inv = cm.addInventory(1, 1, -1, 1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory4()
	{
		boolean inv = cm.addInventory(1, 1, -1, -1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory5()
	{
		boolean inv = cm.addInventory(1, -1, 1, 1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory6() {
		boolean inv = cm.addInventory(1, -1, 1, -1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory7() {
		boolean inv = cm.addInventory(1, -1, -1, 1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory8()
	{
		boolean inv = cm.addInventory(1, -1, -1, -1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory9()
	{
		boolean inv = cm.addInventory(-1, 1, 1, 1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory10()
	{
		boolean inv = cm.addInventory(-1, 1, 1, -1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory11()
	{
		boolean inv = cm.addInventory(-1, 1, -1, 1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory12() {
		boolean inv = cm.addInventory(-1, 1, -1, -1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory13()
	{
		boolean inv = cm.addInventory(-1, -1, 1, 1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory14() {
		boolean inv = cm.addInventory(-1, -1, 1, -1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory15()
	{
		boolean inv = cm.addInventory(-1, -1, -1, 1);
		assertFalse(inv);
	}
	@Test
	public void testAddInventory16() {
		boolean inv = cm.addInventory(-1, -1, -1, -1);
		assertFalse(inv);
	}
	@Test
	public void testPurchaseBeverage1() {
		cm.addRecipe(r1);
		assertEquals(0, cm.makeCoffee(r1, 50));
		}
	@Test
	public void testPurchaseBeverage2() {
		cm.addRecipe(r1);
		assertEquals(40, cm.makeCoffee(r1, 40));
	}
	@Test
	public void testPurchaseBeverage3() {
		Recipe r2 = new Recipe();
		r2.setName("Coffee");
		r2.setAmtCoffee(50);
		r2.setAmtMilk(50);
		r2.setAmtSugar(50);
		r2.setAmtChocolate(50);
		cm.addRecipe(r2);
		
		assertEquals(50, cm.makeCoffee(r2, 50));
	}
	@Test
	public void testGetNameForRecipe1() {
		cm.addRecipe(r1);
		assertEquals(r1, cm.getRecipeForName("Coffee"));
	}
	@Test
	public void testGetNameForRecipe2() {
		Recipe r2 = new Recipe();
		r2.setName("Coffee2");
		r2.setAmtCoffee(1);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(1);
		
		Recipe r3 = new Recipe();
		r3.setName("Coffee3");
		r3.setAmtCoffee(1);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(1);
		
		Recipe r4 = new Recipe();
		r4.setName("Coffee4");
		r4.setAmtCoffee(1);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(1);
		
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		assertEquals(r4, cm.getRecipeForName("Coffee4"));
	}
	@Test
	public void testGetRecipe1() {
		Recipe r2 = new Recipe();
		r2.setName("Coffee2");
		r2.setAmtCoffee(1);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(1);
		
		Recipe r3 = new Recipe();
		r3.setName("Coffee3");
		r3.setAmtCoffee(1);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(1);
		
		Recipe r4 = new Recipe();
		r4.setName("Coffee4");
		r4.setAmtCoffee(1);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(1);
		
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		Recipe[] r = {r4, r3, r2, r1};
		Assert.assertArrayEquals(r, cm.getRecipes());
	}
	
	@After
	public void tearDown() throws Exception
	{
		cm = null;
		i = null;
		r1 = null;
	}
}