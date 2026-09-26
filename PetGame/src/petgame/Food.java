package petgame;

/**
 * This class represents food that can be given to a pet.
 * It can display the name, fullness, and image which is 
 * automatically selected based on the food name
 * 
 * This class implements the {@link Item} interface.
 * 
 * @author Braeden Patierno-Barker 251382353 and Michael Pachowski 251371408
 * 
 */

public class Food implements Item {
	
	/** Initializes a name for the food */
	private String name;
	
	/** Initializes the amount of fullness the food gives */
	private int fullness;
	
	/** Initializes a image for the food */
	private String image;
	
	/**
	 * This constructor initializes the name, fullness, and image of the food
	 * 
	 * @param name Takes the name of the food
	 */
	public Food(String name) {
		this.name = name;
		if (name.toLowerCase().equals("apple")) {
			fullness = 15;
		}
		else if (name.toLowerCase().replaceAll("\\s", "").equals("applepie")) {
			fullness = 20;
		}
		else {
			fullness = 25;
		}
		
		if (name.toLowerCase().equals("apple")) {
			image = "Apple.png";
		} else if(name.toLowerCase().replaceAll("\\s", "").equals("applepie")) {
			image = "ApplePie.png";
		} else {
			image = "Cake.png";
		}
	}
	
	/**
	 * This method returns the amount of fullness that the specific food gives to the pet
	 * 
	 * @return This returns the amount of fullness that the food gives
	 */
	public int getFoodFullness() {
		return this.fullness;
	}
	
	/**
	 * This method returns the name of the food that was given to the pet
	 * 
	 * @return This returns the food name
	 */
	public String getName () {
		return name;
	}
	
	/**
	 * This method returns the image of the food that was given to the pet
	 * 
	 * @return This returns the food image
	 */
	public String getImage () {
		return image;
	}
}
