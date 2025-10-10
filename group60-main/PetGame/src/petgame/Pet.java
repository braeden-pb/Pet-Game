package petgame;

import java.io.File;
import java.util.Map;

/**
 * This class represents the pet being used by the player. It tracks the pets
 * different states, and updates the stats accordingly.
 * 
 * @author Rushd Alashqar 251377969 and Evan Salmon 251351912 and Braeden
 *         Patierno-Barker 251382353 and Michael Pachowski 251371408
 */

public class Pet {
	/** Name of the pet */
	private String name;

	/** Type of pet */
	private String type;

	/** Score of the pet, earned from play time and other things */
	private Integer score;

	/** The inventory of the pet */
	private Inventory inventory;

	/** Health of the pet */
	private int health;

	/** Sleep stat of the pet */
	private int sleep;

	/** How full the pet is */
	private int fullness;

	/** How happy the pet is */
	private int happiness;

	/** Max health of the pet */
	private int maxHealth;

	/** Max sleep stat of the pet */
	private int maxSleep;

	/** Max fullness stat of the pet */
	private int maxFullness;

	/** Max happiness stat of the pet */
	private int maxHappiness;

	/** The state that the pet is in */
	private String state;

	/** This is for ticks converted from frames */
	private final int secondTick = 63;
	
	/**
	 * The inventory of available pet cosmetics
	 */
	private PetCosmetics petCosmetics;

	/**
	 * Constructor of the pet with the name the savefile and the type as the
	 * parameters
	 * 
	 * @param name    the name of the pet
	 * @param petSave the SaveFile being used for the pet to get the statistics
	 * @param type    the type of pet
	 */
	public Pet(String name, SaveFile petSave, String type) {
		this.name = name;
		this.type = type;
		this.score = petSave.getScore();
		this.health = petSave.getHealth();
		this.sleep = petSave.getSleep();
		this.fullness = petSave.getHunger();
		this.happiness = petSave.getHappiness();
		this.state = petSave.getState();
		this.inventory = new Inventory(petSave.getInventory());
		this.petCosmetics =  new PetCosmetics();
		this.maxHealth = 100;
		this.maxSleep = 100;
		this.maxFullness = 100;
		this.maxHappiness = 100;
	}

	/**
	 * Updates the stats of the pet depending on the amount of time passed
	 * 
	 * @param tick the time being tracked to decay stats
	 */
	public void updateStats(Integer tick) {
		if (tick % 300 == 0) {
			score += 100;
		}

		score += 1;

		if (tick % 36000 == 0) {
			score += 5000;
		}

		if (tick % 5 == 0) {
			decayFullness();
			decayHappiness();
		}

		if (tick % 20 == 0 && !state.equals("sleeping")) {
			decaySleep();
		}

		if (tick % 1 == 0 && state.equals("sleeping")) {
			sleep += 1;
		}

		if (tick % 50 == 0 && fullness <= 0) {
			health = Math.max(0, health - 5);
		}
	}

	/**
	 * If the pet is not in sleeping state, decrease the sleep stat by 1
	 */
	private void decaySleep() {
		if (!state.equals("sleeping"))
			sleep = Math.max(0, sleep - 1);
	}

	/**
	 * Decrease the fullness by 1
	 */
	private void decayFullness() {
		fullness = Math.max(0, fullness - 1);
	}
	
	/**
	 * Loads stats from file into the pet
	 * @param filename name of the file to load stats from
	 */
	public void getStats(SaveFile filename) {
		this.health = filename.getHealth();
		this.sleep = filename.getSleep();
		this.fullness = filename.getHunger();
		this.state = filename.getState();
		this.happiness = filename.getHappiness();
	}

	/**
	 * Decrease the happiness by 1
	 */
	private void decayHappiness() {
		happiness = Math.max(0, happiness - 1);
	}

	/**
	 * 
	 * Checks the state that the pet is currently in
	 * @param tick the tick of the timer so states can change on intervals
	 */
	public void checkStates(int tick) {
//        System.out.println("Current state: " + state);
		if (health <= 0) {
			state = "dead";
		}

		else if (sleep <= 0 && !state.equals("sleeping")) {
			health = Math.max(0, health - 20);
			state = "sleeping";
		}

		else if (fullness <= maxFullness / 4 && !state.equals("sleeping")) {
			state = "hungry";
			if (tick % secondTick == 0) {
				health = Math.max(0, health - 1);
				decayHappiness();
			}
		} else if (happiness <= maxHappiness / 4 && !state.equals("sleeping")) {
			state = "angry";
		} else if (!state.equals("sleeping")) {
			state = "normal";
		}

		if (sleep >= maxSleep && state.equals("sleeping")) {
			sleep = maxSleep;
			state = "normal";
		}

		if (happiness >= maxHappiness / 2 && state.equals("angry")) {
			state = "normal";
		}

	}

	/**
	 * Check the score, and add the respective food or give item to the inventory
	 * depending on the amount of score
	 */
	public void checkScore() {
		if (score % 200 == 0 && score != 0) {
			Food apple = new Food("Apple");
			inventory.addItems(apple);
		}

		if (score % 300 == 0 && score != 0) {
			Food applePie = new Food("Apple Pie");
			inventory.addItems(applePie);
		}

		if (score % 400 == 0 && score != 0) {
			Food cake = new Food("Cake");
			inventory.addItems(cake);
		}

		if (score % 200 == 0 && score != 0) {
			Gift teddy = new Gift("Teddy");
			inventory.addItems(teddy);
		}

		if (score % 300 == 0 && score != 0) {
			Gift ball = new Gift("Ball");
			inventory.addItems(ball);
		}

		if (score % 400 == 0 && score != 0) {
			Gift fidgetSpinner = new Gift("Fidget Spinner");
			inventory.addItems(fidgetSpinner);
		}
	}

	/**
	 * This methods add more score to the total score when called
	 * 
	 * @param score adds more score to the total score
	 */
	public void score(int score) {
		this.score += score;
	}

	/**
	 * Method to feed the pet a certain amount
	 * 
	 * @param food value the amount to feed the pet
	 */
	public void feed(Food food) {
		if (!state.equals("sleeping") && !state.equals("dead")) {
			fullness = Math.min(maxFullness, fullness + food.getFoodFullness());
		}
	}

	/**
	 * Get the state that the pet is currently in
	 * 
	 * @return angry or hungry or sleeping or dead or normal depending on the state
	 *         given
	 */
	public String getState() {
		return state;
	}

	/**
	 * This method sets the state of the pet
	 * 
	 * @param state the state to be set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Give a gift to the pet, depending on the value parameter
	 * 
	 * @param gift value an integer value added to the happiness
	 */
	public void giveGift(Gift gift) {
		if (!state.equals("sleeping") && !state.equals("dead")) {
			happiness = Math.min(maxHappiness, happiness + gift.getGiftHappiness());
		}
	}

	/**
	 * Play with the pet, increasing its happiness
	 */
	public void play() {
		if (!state.equals("sleeping") && !state.equals("dead") && !state.equals("angry")) {
			happiness = Math.min(maxHappiness, happiness + 15);
		}
	}

	/**
	 * This method represents the exercise for the pet, and the stats affected by
	 * this exercise
	 */
	public void exercise() {
		if (!state.equals("sleeping") && !state.equals("dead")) {
			health = Math.min(maxHealth, health + 15);
			sleep = Math.max(0, sleep - 20);
			fullness = Math.max(0, fullness - 25);
		}
	}

	/**
	 * Puts the pet to bed making it go to sleep
	 */
	public void goToBed() {
		if (!state.equals("dead")) {
			this.state = "sleeping";
		}
	}

	/**
	 * Bring the pet to the vet and changes stats
	 */
	public void visitVet() {
		if (!state.equals("sleeping") && !state.equals("dead")) {
			health = Math.min(maxHealth, health + 20);
		}
	}

	/**
	 * Get the inventory count
	 * @param name Name of item 
	 * @return the inventory count of the item
	 */
	public Long getInventoryCount(String name) {
		return inventory.getItemCounter(name);
	}

	/**
	 * Get the inventory
	 * @param name Name of item
	 */
	public void addInventoryItem(Item name) {
		inventory.addItems(name);
	}

	/**
	 * Get the inventory
	 * 
	 * @param name Name of item to remove
	 */
	public void removeInventoryItem(Item name) {
		inventory.removeItems(name);
	}

	/**
	 * Get the inventory
	 * 
	 * @return the inventory of the pet
	 */
	public Map<String, Long> getInventoryMap() {
		return inventory.getInventory();
	}

	/**
	 * Get the pet Cosmetics
	 * @return a pet cosmetic object
	 */
	public PetCosmetics getPetCosmetics() {
		return this.petCosmetics;
	}
	
	/**
	 * Get the name
	 * 
	 * @return the name of the pet
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the score
	 * 
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * Get the type
	 * 
	 * @return the type of pet
	 */
	public String getType() {
		return type;
	}

	/**
	 * Get the health
	 * 
	 * @return the health stat
	 */
	public Integer getHealth() {
		return health;
	}

	/**
	 * Get the sleep
	 * 
	 * @return the sleep stat
	 */
	public Integer getSleep() {
		return sleep;
	}

	/**
	 * Get the fullness
	 * 
	 * @return the fullness stat
	 */
	public Integer getFullness() {
		return fullness;
	}

	/**
	 * Get the happiness
	 * 
	 * @return the happiness stat
	 */
	public Integer getHappiness() {
		return happiness;
	}

	/**
	 * Set the health
	 * 
	 * @param health the value to set the health stat to
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Set the sleep
	 * 
	 * @param sleep the value to set the sleep stat to
	 */
	public void setSleep(int sleep) {
		this.sleep = sleep;
	}

	/**
	 * Set the fullness
	 * 
	 * @param fullness the value to set the fullness to
	 */
	public void setFullness(int fullness) {
		this.fullness = fullness;
	}

	/**
	 * Set the happiness
	 * 
	 * @param happiness the value to set the happiness to
	 */
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	/**
	 * Get the max health
	 * 
	 * @return the max health stat
	 */
	public Integer getMaxHealth() {
		return maxHealth;
	}

	/**
	 * Get the max sleep
	 * 
	 * @return the max sleep stat
	 */
	public Integer getMaxSleep() {
		return maxSleep;
	}

	/**
	 * Get the max fullness
	 * 
	 * @return the max fullness stat
	 */
	public Integer getMaxFullness() {
		return maxFullness;
	}

	/**
	 * Get the max happiness
	 * 
	 * @return the max happiness stat
	 */
	public Integer getMaxHappiness() {
		return maxHappiness;
	}

	/**
	 * Sets the maximum health value for the pet.
	 *
	 * @param maxHealth Maximum health value to set.
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * Sets the maximum sleep value for the pet.
	 *
	 * @param maxSleep Maximum sleep value to set.
	 */
	public void setMaxSleep(int maxSleep) {
		this.maxSleep = maxSleep;
	}

	/**
	 * Sets the maximum happiness value for the pet.
	 *
	 * @param maxHappiness Maximum happiness value to set.
	 */
	public void setMaxHappiness(int maxHappiness) {
		this.maxHappiness = maxHappiness;
	}

	/**
	 * Sets the maximum fullness value for the pet.
	 *
	 * @param maxFullness Maximum fullness value to set.
	 */
	public void setMaxFullness(int maxFullness) {
		this.maxFullness = maxFullness;
	}
}