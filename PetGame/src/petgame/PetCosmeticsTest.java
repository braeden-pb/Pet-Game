package petgame;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class PetCosmeticsTest {
	
	SaveFile file = new SaveFile("save1.toml");
	PetCosmetics test = new PetCosmetics();
	
	@Test
	public void testEquip() {
		test.equip("durag");
		boolean expectedResult = true;
		boolean result = test.isEquipped("durag");
		assertEquals(expectedResult, result);
	}

	@Test
	void testUnequip() {
		test.equip("durag");
		test.unequip("durag");
		boolean expectedResult = false;
		boolean result = test.isEquipped("durag");
		assertEquals(expectedResult, result);
	}

	@Test
	void testIsEquipped() {
		test.equip("eyepatch");
		boolean expectedResult = true;
		boolean result = test.isEquipped("eyepatch");
		assertEquals(expectedResult, result);
	}

}
