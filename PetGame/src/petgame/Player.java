 package petgame; 

/**
 * This class represents a player who interacts with the pet. The player handles actions such as
 * feeding, playing, exercising, sleeping, giving gifts, and visiting the vet.
 * 
 * @author Liam Wray 251230783
 * 
 */

public class Player {
	
	/** Initializes a pet */
	private Pet pet;
	
	/**
	 * This constructor creates a player pet
	 * 
	 * @param playerPet This takes the players pet
	 */
	public Player (Pet playerPet) {
		pet = playerPet;
	}
	
	/**
	 * This method feeds the pet with a specific type of food
	 * 
	 * @param FoodType this feeds the pet with a specific type of food
	 */
	public void feedPet(Food FoodType) {
		pet.feed(FoodType);
	}
	
	/**
	 * This sets the players pet given the pet
	 * 
	 * @param playerPet sets players pet
	 */
	public void setPlayerPet(Pet playerPet) {
		pet = playerPet;
	}
	  
	
	/**
	 * This gives a gift to the pet
	 * 
	 * @param gift gives a specific gift to the pet
	 */
	public void giveGift(Gift gift) {
		pet.giveGift(gift);
	}
	
	/**
	 * This pets the pet to bed
	 */
	public void goToBed() {
	    pet.goToBed();
	}
	
	/**
	 * This takes the pet to visit the vet
	 */
	public void takePetToVet() {
	   pet.visitVet();
	}
	
	/**
	 * This method plays with the pet
	 */
	public void play() {
	    pet.play();
	}
	
	/**
	 * This makes the pet exercise
	 */
	public void exercise() {
	    pet.exercise();
	}
}

