package petgame;

import java.util.*;

/**
 * This class goes over equipping and unequipping the various pet cosmetics like
 * a durag, an eye patch and a top hat.
 * 
 * @author Michael Pachowski 251371408
 * 
 */

public class PetCosmetics  {

	/**
	 * A hashmap storing the name of the costmetic and a boolean to see if it has
	 * been equipped or not
	 */
	private HashMap<String, Boolean> cosmetic;

	/**
	 * Construct the PetCosmetic with the cosmetics
	 */
	public PetCosmetics() {
		cosmetic = new HashMap<>();
		cosmetic.put("durag", false);
		cosmetic.put("eyepatch", false);
		cosmetic.put("tophat", false);
	}

	/**
	 * Equip a cosmetic to the pet
	 * 
	 * @param name of the file that we are testing with, to equip the pet with that
	 *             respective cosmetic
	 */
	public void equip(String name) {
		if (name.toLowerCase().equals("durag")) {
			cosmetic.put("durag", true);
			cosmetic.put("tophat", false);
			cosmetic.put("eyepatch", false);
		} else if (name.toLowerCase().equals("eyepatch")) {
			cosmetic.put("eyepatch", true);
			cosmetic.put("durag", false);
			cosmetic.put("tophat", false);
		} else {
			cosmetic.put("tophat", true);
			cosmetic.put("durag", false);
			cosmetic.put("eyepatch", false);
		}
	}

	/**
	 * Unequip a cosmetic from the pet
	 * 
	 * @param name of the file that we are testing with, to unequip the pet with
	 *             that respective cosmetic
	 */
	public void unequip(String name) {
		if (name.toLowerCase().equals("durag")) {
			cosmetic.put("durag", false);
		} else if (name.toLowerCase().equals("eyepatch")) {
			cosmetic.put("eyepatch", false);
		} else {
			cosmetic.put("tophat", false);
		}
	}

	/**
	 * Check to see if a cosmetic is equipped
	 * 
	 * @return boolean to see if a cosmetic is equipped, will return true if it is,
	 *         false if not
	 */
	public boolean isEquipped(String name) {
		return cosmetic.get(name);
	}

}
