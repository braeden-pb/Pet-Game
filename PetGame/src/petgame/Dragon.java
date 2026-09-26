package petgame;

/**
 * This class represents the dragon pet that is used by the player. It tracks the pets different states,
 * and updates the stats accordingly.
 * 
 * @author Rushd Alashqar 251377969 and Braeden Patierno-Barker 251382353
 */

public class Dragon extends Pet {
	
	/**
     * Constructor of the Dragon pet with the name the savefile and the type as the parameters
     * 
     * @param name the name of the pet
     * @param petSave the SaveFile being used for the pet to get the statistics
     * @param type the type of pet
     */
    public Dragon(String name, SaveFile petSave, String type) {
        super(name, petSave, type);
        setMaxHealth(150);
        setMaxSleep(100);
        setMaxFullness(120);
        setMaxHappiness(90);
    }

    /**
     * Play with the pet, increasing its happiness
     */
    @Override
    public void play() {
    	if (!getState().equals("sleeping") && !getState().equals("dead") && !getState().equals("angry")) {
            setHappiness(Math.min(getMaxHappiness(), getHappiness() + 19));
        }
    }
    
    /**
     * This method represents the exercise for the pet, and the stats affected by this 
     * exercise
     */
    @Override
    public void exercise() {
    	if (!getState().equals("sleeping") && !getState().equals("dead")) {
    		setHealth(Math.min(getMaxHealth(), getHealth() + 22));
            setSleep(Math.max(0, getSleep() - 17));
            setFullness(Math.max(0, getFullness() - 23));
    	}
    }
}
