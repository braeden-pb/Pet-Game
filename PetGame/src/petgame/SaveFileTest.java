package petgame;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.moandjiezana.toml.Toml;

class SaveFileTest {
	SaveFile saveFile = new SaveFile("testfile.toml");
	SaveFile saveFile2 = new SaveFile("testfile2.toml");
	Map<String,Object> defaultData = new HashMap<>(new Toml().read(new File("saves/testfile.toml")).toMap());


	@AfterEach
	public void resetFIie() throws IOException {
		saveFile.setSaveState(false);
	}

	@Test
	public void testGetPetType() {
		String ExpectedType = "dragon";
		String actualType = saveFile.getPetType();
		assertEquals(ExpectedType, actualType);
	}

	@Test
	public void testInUse() {
		Boolean ExpectedUse = false;
		Boolean actualUse = saveFile.inUse();
		assertEquals(ExpectedUse, actualUse);
	}

	@Test
	public void testGetHealth() {
		Integer ExpectedHealth = 50;
		Integer actualHealth = saveFile.getHealth();
		assertEquals(ExpectedHealth, actualHealth);
	}

	@Test
	public void testGetName() {
		String ExpectedName = "testfile.toml";
		String actualName = saveFile.getName();
		assertEquals(ExpectedName, actualName);
	}

	@Test
	public void testGetHunger() {
		Integer ExpectedHunger = 50;
		Integer actualHunger = saveFile.getHunger();
		assertEquals(ExpectedHunger, actualHunger);
	}

	@Test
	public void testGetScore() {
		Integer ExpectedScore = 2000;
		Integer actualScore = saveFile.getScore();
		assertEquals(ExpectedScore, actualScore);
	}

	@Test
	public void testGetHappiness() {
		Integer ExpectedHappiness = 20;
		Integer actualHappiness = saveFile.getHappiness();
		assertEquals(ExpectedHappiness, actualHappiness);
	}

	@Test
	public void testGetSleep() {
		Integer ExpectedSleep = 50;
		Integer actualSleep = saveFile.getSleep();
		assertEquals(ExpectedSleep, actualSleep);
	}

	@Test
	public void testGetState() {
		String ExpectedState = "angry";
		String actualState = saveFile.getState();
		assertEquals(ExpectedState, actualState);
	}

	@Test
	public void testSetSaveState() throws IOException {
		Boolean expectedState  = false;
		saveFile.setSaveState(false);
		Boolean actualState = saveFile.inUse();
		assertEquals(expectedState,actualState);
	}
	
	@Test
	public void testSetName() throws IOException {
		saveFile.setName("testfile.toml");
		String result = "testfile.toml";
		String expectedResult = saveFile.getName();
		assertEquals(result,expectedResult);
	}
	
	@Test
	public void testResetSaveFile() throws IOException {
		saveFile2.loadPet("dragon");
		String result = "dragon";
		String expectedResult = saveFile2.getPetType();
		assertEquals(result,expectedResult);
	}
	
	@Test
	public void testGetInventory() throws IOException {
	    saveFile2.loadPet("dragon");
	    HashMap<String, Long> inventory = saveFile2.getInventory();
	    assertNotNull(inventory);
	    assertEquals(6, inventory.size(), "Inventory should contain 6 items");
	    assertEquals(5L, inventory.get("apple"));
	    assertEquals(5L, inventory.get("ball"));
	    assertEquals(3L, inventory.get("teddy"));
	    assertEquals(1L, inventory.get("cake"));
	    assertEquals(1L, inventory.get("fidgetspinner"));
	    assertEquals(3L, inventory.get("applepie"));
	}
	
	@Test
	public void testRevivePet() throws IOException {
		saveFile2.revivePet();
		String result = "normal";
		String expectedResult = saveFile2.getState();
		assertEquals(result,expectedResult);
	}
	
	@Test
	public void testLoadPet() throws IOException {
		saveFile2.loadPet("dragon");
		String result = "dragon";
		String expectedResult = saveFile2.getPetType();
		assertEquals(result,expectedResult);
	}
}
