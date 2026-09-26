package petgame;

/**
 * This class represents a gift that can be given to a pet.
 * It can display the name, happiness, and image which is 
 * automatically selected based on the gift name
 * 
 * This class implements the {@link Item} interface.
 * 
 * @author Braeden Patierno-Barker 251382353 and Michael Pachowski 251371408
 * 
 */

public class Gift implements Item {
	
	/** Initializes a name for the gift */
	private String name;
	
	/** Initializes the amount of happiness the gift gives */
	private int happiness;
	
	/** Initializes a image for the gift */
	private String image;
	
	/**
	 * This constructor initializes the name, happiness, and image of the gift
	 * 
	 * @param name Takes the name of the gift
	 */
	public Gift(String name) {
		this.name = name;
		if (name.toLowerCase().equals("ball")) {
			happiness = 15;
		}
		else if (name.toLowerCase().replaceAll("\\s", "").equals("teddy")) {
			happiness = 20;
		}
		else {
			happiness = 25;
		}
		
		if (name.toLowerCase().equals("ball")) {
			image = "ball.png";
		} else if(name.toLowerCase().equals("teddy")) {
			image = "teddy.png";
		} else {
			image = "spinner.png";
		}
	}
	
	/**
	 * This method returns the amount of happiness that the specific gift gives to the pet
	 * 
	 * @return This returns the amount of happiness that the gift gives
	 */
	public int getGiftHappiness() {
		return this.happiness;
	}
	
	/**
	 * This method returns the name of the gift that was given to the pet
	 * 
	 * @return This returns the gift name
	 */
	public String getName () {
		return name;
	}
	
	/**
	 * This method returns the image of the gift that was given to the pet
	 * 
	 * @return This returns the gift image
	 */
	public String getImage() {
		return image;
	}
}
