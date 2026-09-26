package petgame;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*; 

import org.junit.jupiter.api.Test;

class InventoryTest{
	
	SaveFile file = new SaveFile("testfile.toml");
	Inventory test = new Inventory(file.getInventory());
	Food item = new Food("Apple Pie");

	@Test
	public void testAddItems() {
		test.addItems(item);
		Map<String, Item> expectedResult = test.getItemList();
		assertEquals(1, expectedResult.size());
		assertTrue(expectedResult.containsKey("applepie"));
	}
	
	@Test
	public void testRemoveItems() {
		test.addItems(item);
		test.addItems(item);
		test.addItems(item);
		test.removeItems(item);
		Map<String, Item> expectedResult = test.getItemList();
		assertEquals(1, expectedResult.size());
		assertTrue(expectedResult.containsKey("applepie"));
	}
	
	@Test
	public void testGetItemList() {
		test.addItems(item);
		Map<String, Item> expectedResult = test.getItemList();
		assertTrue(expectedResult.containsKey("applepie"));	
	}
	
	@Test
	public void testGetItemCounter() {
		test.addItems(item);
		test.addItems(item);
		Long expectedResult = 2L;
		assertEquals(expectedResult, test.getItemCounter(item.getName()));
	}
}
