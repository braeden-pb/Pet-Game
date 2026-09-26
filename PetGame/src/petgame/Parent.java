package petgame;

import java.io.IOException;

/**
 * This class represents a player who interacts with the pet. The player handles actions such as
 * feeding, playing, exercising, sleeping, giving gifts, and visiting the vet.
 * 
 * @author Liam Wray 251230783
 * 
 */

public class Parent {
	
	private int clock = (int) System.currentTimeMillis();
	private String password;
	private int endTime,startTime;
	private int startingTotalTime = 0;
	
	/**
	 * This constructor creates a password for the parent
	 * 
	 * @param pass creates a password
	 */
	public Parent(String pass) {
		password = pass;
	}
	
	/**
	 * This gets the password that was set
	 * 
	 * @return gets the password the parent set
	 */
	public String getPassword() {
		return password;
	}
		
	/**
	 * This sets a password for the parent to use to login
	 * 
	 * @param pass sets a password for the parents to use
	 * @throws IOException if there is an error writing the password in the config file
	 */
	public void setPassword(String pass) throws IOException {
		password = pass;
		Game.getInstance().getConfigFile().setPassword(pass);	
	}
	
	/**
	 * This sets a window for the player to play the game
	 * 
	 * @param time1 start window for the player to play the game
	 * @param time2 end window for the player to play the game
	 */
	public void setWindow(int time1, int time2) {
		startTime = time1;
		endTime = time2;
	}
	
	/**
	 * This gets the start time of when the player can play the game
	 * 
	 * @return gets the start time
	 */
	public int getStartTime() {
		return startTime;
	}
	
	/**
	 * This sets the start time of when the player can play the game
	 * 
	 * @param time gives a start time
	 */
	public void setStartTime (int time) {
		startTime = time;
	}
	
	
	/**
	 * This gets the end time of when the player has to stop playing the game
	 * 
	 * @return gets the start time
	 */
	public int getEndTime () {
		return endTime;
	}
	
	
	/**
	 * This sets the end time of when the player has to stop playing the game
	 * 
	 * @param time gives a end time
	 */
	public void setEndTime (int time) {
		startTime = time;
	}
	
	/**
	 * Checks to see if the window for when the player can play the game is still open
	 * 
	 * @return whether or not the player can play the game
	 */
	public boolean inWindow () {
		if ((clock <= startTime) || (clock >= endTime)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Gets the in-game clock value
	 * 
	 * @return the clock value
	 */
	public int getClock() {
		return clock;
	}
	
	/**
	 * Sets the in-game clock value
	 * 
	 * @param time clock value to set
	 */
	public void setClock (int time) {
		clock = time;
	}
	
	/**
	 * This allows the parent to add more time for how long the player can play the game
	 * 
	 * @param time the added time that the player can play
	 */
	public void addTime(int time) {
		startingTotalTime += time;
	}
	
	/**
	 * This gets the total time the player can play the game
	 * 
	 * @return the total time the player can play
	 */
	public int getTotalTime () {
		return startingTotalTime;
	}
	
	/**
	 * Revives pet by setting a new save file if the pet is dead
	 * 
	 * @param fileName the name of the save file for reviving the pet 
	 */
	public void revivePet(String fileName) {
		Game.getInstance().setSaveFile(fileName);
	}

}