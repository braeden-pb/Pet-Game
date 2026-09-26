package petgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DragonTest {

	SaveFile file = new SaveFile("testfile.toml");
	Dragon pet = new Dragon("bob", file, "dragon");
	Food food = new Food("Apple");

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
		int result1 = 72;
		int result2 = 33;
		int result3 = 27;
		int expectedResult1 = pet.getHealth();
		int expectedResult2 = pet.getSleep();
		int expectedResult3 = pet.getFullness();
		assertEquals(result1, expectedResult1);
		assertEquals(result2, expectedResult2);
		assertEquals(result3, expectedResult3);
	}

}
