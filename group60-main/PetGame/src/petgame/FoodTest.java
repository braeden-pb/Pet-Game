package petgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FoodTest {
	Food test = new Food("Apple Pie");
	
	@Test
	void testGetFoodFullness() {
		int result = 20;
		int expectedResult = test.getFoodFullness();
		assertEquals(result, expectedResult);
	}

	@Test
	void testGetName() {
		String result = "Apple Pie";
		String expectedResult = test.getName();
		assertEquals(result, expectedResult);
	}

	@Test
	void testGetImage() {
		String result = "ApplePie.png";
		String expectedResult = test.getImage();
		assertEquals(result, expectedResult);
	}
}
