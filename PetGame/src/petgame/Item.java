package petgame;
/**
 * This interface defines the methods getName and getImage, which returns 
 * the name and image respectively.
 * 
 * @author Braeden Patierno-Barker 251382353 and Michael Pachowski 251371408
 * 
 */

public interface Item {
	
	/**
	 * Get the name of the item
	 * 
	 * @return the items name as a string.
	 */
	public String getName();
	
	/**
	 * Get the image of the item
	 * 
	 * @return the image of the item as a string
	 */
	public String getImage();
}
