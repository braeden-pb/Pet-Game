package petgame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

class PetTest {

	SaveFile file = new SaveFile("testfile.toml");
	Pet pet = new Pet("bob", file, "dragon");
	Inventory test = new Inventory(file.getInventory());
	Food food = new Food("Apple Pie");
	Gift gift = new Gift("Ball");
	
	@Test
	void testUpdateStats() {
		pet.updateStats(300);
		int result = 2101;
		int expectedResult = pet.getScore();
		assertEquals(result, expectedResult);
	}

	@Test
	void testCheckStates() {
		pet.checkStates(0);
		String result = "angry";
		String expectedResult = pet.getState();
		assertEquals(result, expectedResult);
	}

	@Test
	void testCheckScore() {
		pet.checkScore();
		Long result = 1L;
		Long expectedResult = pet.getInventoryCount("teddy");
		assertEquals(result, expectedResult);
	}

	@Test
	void testFeed() {
		pet.feed(food);
		int result = 70;
		int expectedResult = pet.getFullness();
		assertEquals(result, expectedResult);
	}

	@Test
	void testGiveGift() {
		pet.giveGift(gift);
		int result = 35;
		int expectedResult = pet.getHappiness();
		assertEquals(result, expectedResult);
	}

	@Test
	void testPlay() {
		pet.play();
		int result = 20;
		int expectedResult = pet.getHappiness();
		assertEquals(result, expectedResult);
	}

	@Test
	void testExercise() {
		pet.exercise();
		int result1 = 65;
		int result2 = 30;
		int result3 = 25;
		int expectedResult1 = pet.getHealth();
		int expectedResult2 = pet.getSleep();
		int expectedResult3 = pet.getFullness();
		assertEquals(result1, expectedResult1);
		assertEquals(result2, expectedResult2);
		assertEquals(result3, expectedResult3);
	}

	@Test
	void testGoToBed() {
		pet.goToBed();
		String result = "sleeping";
		String expectedResult = pet.getState();
		assertEquals(result, expectedResult);
	}

	@Test
	void testVisitVet() {
		pet.visitVet();
		int result = 70;
		int expectedResult = pet.getHealth();
		assertEquals(result, expectedResult);
	}

	
	@Test
	void testGetInventoryCount() {
		test.addItems(food);
		Long expectedResult = pet.getInventoryCount(food.getName());
		Long result = 1L;
		assertEquals(result, expectedResult);
	}
	
	@Test
	void testAddInventoryItem() {
		test.addItems(food);
		Long expectedResult = pet.getInventoryCount(food.getName());
		Long result = 1L;
		assertEquals(result, expectedResult);
	}
	
	@Test
	void testRemoveInventoryItem() {
		test.addItems(food);
		test.addItems(food);
		test.removeItems(food);
		Long expectedResult = pet.getInventoryCount(food.getName());
		Long result = 1L;
		assertEquals(result, expectedResult);
	}
	
	@Test
	void testGetInventoryMap() {
		test.addItems(food);
		Map<String, Item> expectedResult = test.getItemList();
		assertTrue(expectedResult.containsKey("applepie"));
	}
	
	@Test
	void testGetName() {
		String expectedResult = pet.getName();
		String result = "bob";
		assertEquals(result, expectedResult);
	}

	@Test
	void testGetScore() {
		int expectedResult = pet.getScore();
		int result = 2000;
		assertEquals(result, expectedResult);
	}

	@Test
	void testGetType() {
		String expectedResult = pet.getType();
		String result = "dragon";
		assertEquals(result, expectedResult);
	}

	@Test
	void testGetHealth() {
		int expectedResult = pet.getHealth();
		int result = 50;
		assertEquals(result, expectedResult);
	}

	@Test
	void testGetSleep() {
		int expectedResult = pet.getSleep();
		int result = 50;
		assertEquals(result, expectedResult);
	}

	@Test
	void testGetFullness() {
		int expectedResult = pet.getFullness();
		int result = 50;
		assertEquals(result, expectedResult);
	}

	@Test
	void testGetHappiness() {
		int expectedResult = pet.getHappiness();
		int result = 20;
		assertEquals(result, expectedResult);
	}

	@Test
	void testSetHealth() {
		pet.setHealth(100);
		int expectedResult = pet.getHealth();
		int result = 100;
		assertEquals(result, expectedResult);
	}

	@Test
	void testSetSleep() {
		pet.setSleep(100);
		int expectedResult = pet.getSleep();
		int result = 100;
		assertEquals(result, expectedResult);
	}

	@Test
	void testSetFullness() {
		pet.setFullness(100);
		int expectedResult = pet.getFullness();
		int result = 100;
		assertEquals(result, expectedResult);
	}

	@Test
	void testSetHappiness() {
		pet.setHappiness(100);
		int expectedResult = pet.getHappiness();
		int result = 100;
		assertEquals(result, expectedResult);
	}

	@Test
	void testSetMaxHealth() {
		pet.setMaxHealth(100);
		int expectedResult = pet.getMaxHealth();
		int result = 100;
		assertEquals(result, expectedResult);
	}

	@Test
	void testSetMaxSleep() {
		pet.setMaxSleep(100);
		int expectedResult = pet.getMaxSleep();
		int result = 100;
		assertEquals(result, expectedResult);
	}

	@Test
	void testSetMaxHappiness() {
		pet.setMaxHappiness(100);
		int expectedResult = pet.getMaxHappiness();
		int result = 100;
		assertEquals(result, expectedResult);
	}
	
	@Test
	void testSetMaxFullness() {
		pet.setMaxFullness(100);
		int expectedResult = pet.getMaxFullness();
		int result = 100;
		assertEquals(result, expectedResult);
	}
}
