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
	/**
	 * addRecipe1 acceptance test.
	 */
	@Test
	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}
	/**
	 * addRecipe2 acceptance test.
	 */
	@Test
	public void testAddRecipe2()
	{
		cm.addRecipe(r1);
		assertFalse(cm.addRecipe(r1));
	}
	/**
	 * addRecipe3 acceptance test.
	 */
	@Test
	public void testAddRecipe3()
	{
		r1.setPrice(-1);
		assertTrue(cm.addRecipe(r1));
	}
	/**
	 * addRecipe4a acceptance test.
	 */
	@Test
	public void testAddRecipe4a()
	{
		r1.setAmtCoffee(-3);
		assertTrue(cm.addRecipe(r1));
	}
	/**
	 * addRecipe4b acceptance test.
	 */
	@Test
	public void testAddRecipe4b()
	{
		r1.setAmtMilk(-1);
		assertTrue(cm.addRecipe(r1));
	}
	/**
	 * addRecipe4c acceptance test.
	 */
	@Test
	public void testAddRecipe4c()
	{
		r1.setAmtSugar(-1);
		assertTrue(cm.addRecipe(r1));
	}
	/**
	 * addRecipe4d acceptance test.
	 */
	@Test
	public void testAddRecipe4d()
	{
		r1.setAmtChocolate(-1);
		assertTrue(cm.addRecipe(r1));
	}
	/**
	 * addRecipe5 acceptance test.
	 */
	@Test
	public void testAddRecipe5()
	{
		final Recipe r2 = new Recipe();
		r2.setName("Coffee2");
		r2.setAmtCoffee(1);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(1);
		
		final Recipe r3 = new Recipe();
		r3.setName("Coffee3");
		r3.setAmtCoffee(1);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(1);
		
		final Recipe r4 = new Recipe();
		r4.setName("Coffee4");
		r4.setAmtCoffee(1);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(1);
		
		final Recipe r5 = new Recipe();
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
	/**
	 * deleteRecipe1 acceptance test.
	 */
	@Test
	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}
	/**
	 * deleteRecipe2 acceptance test.
	 */
	@Test
	public void testDeleteRecipe2() {
		assertFalse(cm.deleteRecipe(null));
	}
	/**
	 * Mutation Testing: Killed line 93 - negated conditional
	 */
	@Test
	public void testDeleteRecipe3() {
		final Recipe r2 = new Recipe();
		r2.setName("Coffee2");
		r2.setAmtCoffee(1);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(1);
		
		final Recipe r3 = new Recipe();
		r3.setName("Coffee3");
		r3.setAmtCoffee(1);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(1);
		
		final Recipe r4 = new Recipe();
		r4.setName("Coffee4");
		r4.setAmtCoffee(1);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(1);
		
		final Recipe r5 = new Recipe();
		r5.setName("Coffee5");
		r5.setAmtCoffee(1);
		r5.setAmtMilk(1);
		r5.setAmtSugar(1);
		r5.setAmtChocolate(1);
		
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		cm.addRecipe(r5);
		assertFalse(cm.deleteRecipe(r5));
	}
	/**
	 * editRecipe1 acceptance test.
	 */
	@Test
	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	/**
	 * editRecipe2 acceptance test
	 */
	@Test
	public void testEditRecipe2() {
		assertFalse(cm.editRecipe(null,r1));
	}
	/**
	 * editRecipe3 acceptance test
	 */
	@Test
	public void testEditRecipe3() {
		cm.addRecipe(r1);
		final Recipe r2 = new Recipe();
		r2.setName("Milk");
		r2.setPrice(-1);
		r2.setAmtCoffee(0);
		r2.setAmtMilk(20);
		r2.setAmtSugar(0);
		r2.setAmtChocolate(0);
		assertFalse(cm.editRecipe(r1, r2));
	}
	/**
	 * editRecipe4 acceptance test.
	 */
	@Test
	public void testEditRecipe4()
	{
		final Recipe r2 = new Recipe();
		r2.setName("Coffee2");
		r2.setAmtCoffee(1);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(1);
		
		final Recipe r3 = new Recipe();
		r3.setName("Coffee3");
		r3.setAmtCoffee(1);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(1);
		
		final Recipe r4 = new Recipe();
		r4.setName("Coffee4");
		r4.setAmtCoffee(1);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(1);
		
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		
		final Recipe r5 = new Recipe();
		r5.setName("Coffee3");
		r5.setPrice(1);
		r5.setAmtCoffee(1);
		r5.setAmtMilk(1);
		r5.setAmtSugar(1);
		r5.setAmtChocolate(1);
		
		assertFalse(cm.editRecipe(r2, r5));
	}
	/**
	 * addInventory1 acceptance test.
	 */
	@Test
	public void testAddInventory1() {
		final boolean inv = cm.addInventory(1, 1, 1, 1);
		assertTrue(inv);
	}
	/**
	 * addInventory2 acceptance test.
	 */
	@Test
	public void testAddInventory2()
	{
		final boolean inv = cm.addInventory(1, 1, 1, -1);
		assertFalse(inv);
	}
	/**
	 * addInventory3 acceptance test.
	 */
	@Test
	public void testAddInventory3()
	{
		final boolean inv = cm.addInventory(1, 1, -1, 1);
		assertFalse(inv);
	}
	/**
	 * addInventory4 acceptance test.
	 */
	@Test
	public void testAddInventory4()
	{
		final boolean inv = cm.addInventory(1, 1, -1, -1);
		assertFalse(inv);
	}
	/**
	 * addInventory5 acceptance test.
	 */
	@Test
	public void testAddInventory5()
	{
		final boolean inv = cm.addInventory(1, -1, 1, 1);
		assertFalse(inv);
	}
	/**
	 * addInventory6 acceptance test.
	 */
	@Test
	public void testAddInventory6() {
		final boolean inv = cm.addInventory(1, -1, 1, -1);
		assertFalse(inv);
	}
	/**
	 * addInventory7 acceptance test.
	 */
	@Test
	public void testAddInventory7() {
		final boolean inv = cm.addInventory(1, -1, -1, 1);
		assertFalse(inv);
	}
	/**
	 * addInventory8 acceptance test.
	 */
	@Test
	public void testAddInventory8()
	{
		final boolean inv = cm.addInventory(1, -1, -1, -1);
		assertFalse(inv);
	}
	/**
	 * addInventory9 acceptance test.
	 */
	@Test
	public void testAddInventory9()
	{
		final boolean inv = cm.addInventory(-1, 1, 1, 1);
		assertFalse(inv);
	}
	/**
	 * addInventory10 acceptance test.
	 */
	@Test
	public void testAddInventory10()
	{
		final boolean inv = cm.addInventory(-1, 1, 1, -1);
		assertFalse(inv);
	}
	/**
	 * addInventory11 acceptance test.
	 */
	@Test
	public void testAddInventory11()
	{
		final boolean inv = cm.addInventory(-1, 1, -1, 1);
		assertFalse(inv);
	}
	/**
	 * addInventory12 acceptance test.
	 */
	@Test
	public void testAddInventory12() {
		final boolean inv = cm.addInventory(-1, 1, -1, -1);
		assertFalse(inv);
	}
	/**
	 * addInventory13 acceptance test.
	 */
	@Test
	public void testAddInventory13()
	{
		final boolean inv = cm.addInventory(-1, -1, 1, 1);
		assertFalse(inv);
	}
	/**
	 * addInventory14 acceptance test.
	 */
	@Test
	public void testAddInventory14() {
		final boolean inv = cm.addInventory(-1, -1, 1, -1);
		assertFalse(inv);
	}
	/**
	 * addInventory15 acceptance test.
	 */
	@Test
	public void testAddInventory15()
	{
		final boolean inv = cm.addInventory(-1, -1, -1, 1);
		assertFalse(inv);
	}
	/**
	 * addInventory16 acceptance test.
	 */
	@Test
	public void testAddInventory16() {
		final boolean inv = cm.addInventory(-1, -1, -1, -1);
		assertFalse(inv);
	}
	
	/**
	 * Mutation Test: Killed Conditional Boundary changed.
	 */
	@Test
	public void testAddInventory17(){
		final boolean inv = cm.addInventory(0, 0, 0, 0);
		assertTrue(inv);
	}
	
	/**
	 * Mutation Test: Killed lines 138 - 141 for replacing integer addition with subtraction and removed call to Inventory::SetCoffee, Inventory::SetMilk, Inventory::SetSugar, Inventory::SetChocolate
	 */
	@Test
	public void testAddInventory18()
	{
		cm.addInventory(i.getCoffee(), i.getMilk(), i.getSugar(), i.getChocolate());
		assertEquals(30, i.getCoffee());
		assertEquals(30, i.getMilk());
		assertEquals(30, i.getSugar());
		assertEquals(30, i.getChocolate());
	}
	
	/**
	 * Mutation Test: Killed line 151 checkInventory: mutated return of Object value for CoffeeMaker::checkInventory to if (x != null)
	 */
	@Test
	public void testCheckInventory() {
		assertEquals(15, i.getCoffee());
		assertEquals(15, i.getMilk());
		assertEquals(15, i.getSugar());
		assertEquals(15, i.getChocolate());
	}
	/**
	 * purchaseBeverage1 acceptance test.
	 */
	@Test
	public void testPurchaseBeverage1() {
		cm.addRecipe(r1);
		assertEquals(0, cm.makeCoffee(r1, 50));
		}
	/**
	 * purchaseBeverage2 acceptance test.
	 */
	@Test
	public void testPurchaseBeverage2() {
		cm.addRecipe(r1);
		assertEquals(40, cm.makeCoffee(r1, 40));
	}
	/**
	 * purchaseBeverage3 acceptance test.
	 */
	@Test
	public void testPurchaseBeverage3() {
		final Recipe r2 = new Recipe();
		r2.setName("Coffee");
		r2.setAmtCoffee(50);
		r2.setAmtMilk(50);
		r2.setAmtSugar(50);
		r2.setAmtChocolate(50);
		cm.addRecipe(r2);
		
		assertEquals(50, cm.makeCoffee(r2, 50));
	}
	/**
	 * Mutation Testing: killed subtraction to addition in lines 170-173
	 */
	@Test
	public void testPurchaseBeverage4() {
		r1.setAmtChocolate(1);
		
		i.setCoffee(i.getCoffee() - r1.getAmtCoffee());
		i.setMilk(i.getMilk() - r1.getAmtMilk());
		i.setSugar(i.getSugar() - r1.getAmtSugar());
		i.setChocolate(i.getChocolate() - r1.getAmtChocolate());
		
		cm.makeCoffee(r1, 51);
		assertEquals(9, i.getCoffee());
		assertEquals(13, i.getMilk());
		assertEquals(13, i.getSugar());
		assertEquals(13, i.getChocolate());
	}
	
	@Test
	public void testGetNameForRecipe1() {
		cm.addRecipe(r1);
		assertEquals(r1, cm.getRecipeForName("Coffee"));
	}
	@Test
	public void testGetNameForRecipe2() {
		final Recipe r2 = new Recipe();
		r2.setName("Coffee2");
		r2.setAmtCoffee(1);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(1);
		
		final Recipe r3 = new Recipe();
		r3.setName("Coffee3");
		r3.setAmtCoffee(1);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(1);
		
		final Recipe r4 = new Recipe();
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
		final Recipe r2 = new Recipe();
		r2.setName("Coffee2");
		r2.setAmtCoffee(1);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(1);
		
		final Recipe r3 = new Recipe();
		r3.setName("Coffee3");
		r3.setAmtCoffee(1);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(1);
		
		final Recipe r4 = new Recipe();
		r4.setName("Coffee4");
		r4.setAmtCoffee(1);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(1);
		
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		final Recipe[] r = {r4, r3, r2, r1};
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