package petgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GiftTest {
	Gift test = new Gift("Teddy");
	
	@Test
	void testGetGiftHappiness() {
		int result = 20;
		int expectedResult = test.getGiftHappiness();
		assertEquals(result, expectedResult);
	}

	@Test
	void testGetName() {
		String result = "Teddy";
		String expectedResult = test.getName();
		assertEquals(result, expectedResult);
	}

	@Test
	void testGetImage() {
		String result = "teddy.png";
		String expectedResult = test.getImage();
		assertEquals(result, expectedResult);
	}
}
