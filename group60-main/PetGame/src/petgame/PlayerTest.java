//import junit.framework.TestCase;
package petgame;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlayerTest {
	SaveFile file = new SaveFile("testfile.toml");
	Pet pet = new Pet("bob", file, "ghost");
	Player test = new Player(pet);
	String state = pet.getState();

	
	@Test
	public void playTest () {
		pet.setHappiness(20);
		test.play();
		int result = pet.getHappiness();
		System.out.println(result);
		int expected = 20;
		System.out.println(state);
		assertEquals(result,expected);
		
	}
	

	@Test
	public void feedTest() {
		pet.setFullness(15);
		Food apple = new Food("apple");
		test.feedPet(apple);
		int expected = 30;
		int result = pet.getFullness();
		assertEquals(result,expected);
		
	}
	
	@Test
	public void setPlayerPetTest() {
		test.setPlayerPet(pet);
		String result = pet.getName();
		String expected = "bob";
		assertEquals(result,expected);
	}
	
	@Test
	public void GiveGiftTest () {
		Gift gift = new Gift("ball");
		pet.setHappiness(60);
		test.giveGift(gift);
		int result = pet.getHappiness();
		int expected = 75;
		assertEquals(expected,result);
	}

	
	@Test
	public void bedTest () {
		test.goToBed();
		String result = pet.getState();
		String expected = "sleeping";
		assertEquals(result,expected);
	}
	
	@Test
	public void vetTest () {
		pet.setHealth(20);
		test.takePetToVet();
		int health = pet.getHealth();
		int expected = 40;
		assertEquals(expected, health);
		
	}

	@Test
	public void exerciseTest() {
		pet.setHealth(20);
		test.exercise();
		int result = pet.getHealth();
		int expected = 35;
		assertEquals(result,expected);
	}

}
