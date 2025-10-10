package petgame;

import java.awt.EventQueue;
import java.io.IOException;

/**
 * This class handles all the core features such as managing the current pet, player,
 * save files, timers, GUI interaction, and overall game state. The singleton pattern
 * is being used throughout this so only one game instance runs at a time.
 * 
 * @author Evan Salmon 251351912
 * 
 */

public class Game {
	
	/** Initializes a game instance */
	private static final Game instance = new Game();
	
	/** Initializes a pet */
	private Pet currentPet;
	
	/** Initializes a player */
	private Player player;
	
	/** Initializes a saveFile */
	private SaveFile saveFile;
	
	/** Initializes a parent */
	private Parent parent;
	
	/** Initializes a configFile */
	private ConfigFile configFile;
	
	/** Initializes a startTime */
	private long startTime;
	
	/** Initializes a window for the GUI */
	private GUI window;
	
	/** Initializes a gameTimer */
	private GameLoop gameTimer;

	/**
	 * This constructor is a private constructor for the singleton pattern. 
	 * Initializes core game features and setups the GUI.
	 */
	private Game() {
		player = new Player(currentPet);
		parent = new Parent("0000");
			saveFile = new SaveFile("save1.toml");
		saveFile = new SaveFile("save2.toml");
		saveFile = new SaveFile("save3.toml");
		configFile = new ConfigFile();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		gameTimer = new GameLoop();
		gameTimer.startConstantTimer();

	}

	/**
	 * Get the instance of Game using singleton pattern
	 * 
	 * @return singleton Game instance
	 */
	public static Game getInstance() {
		return instance;
	}

	/**
	 * Starts a stats timer and screen timer
	 */
	public void startTimer() {
		gameTimer.startTimer();
	}

	/**
	 * Ends a stats timer and resets tick count
	 */
	public void endTimer() {
		gameTimer.endTimer();
	}

	/**
	 * Starts progress bar timer
	 */
	public void startProgress() {
		gameTimer.startProgressTimer();
	}

	/**
	 * Gets the current pet in use
	 * 
	 * @return the current pet in use
	 */
	public Pet getCurrentPet() {
		return this.currentPet;
	}

	/**
	 * Gets the player in the game
	 * 
	 * @return player in the game
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * Gets the parent control object
	 * 
	 * @return parent object
	 */
	public Parent getParent() {
		return this.parent;
	}

	/**
	 * Gets the save file in use
	 * 
	 * @return the save file
	 */
	public SaveFile getSaveFile() {
		return this.saveFile;
	}

	/**
	 * Gets the config file
	 * 
	 * @return the config file
	 */
	public ConfigFile getConfigFile() {
		return this.configFile;
	}

	/**
	 * Gets GUI window
	 * 
	 * @return GUI window
	 */
	public GUI getGui() {
		return this.window;
	}

	/**
	 * Gets play session time
	 * 
	 * @return the play session time as a formatted String
	 */
	public String getTime() {
		return gameTimer.getTime();
	}

	/**
	 * Gets seconds in the game session
	 * 
	 * @return the seconds in game session
	 */
	public int getSeconds() {
		return gameTimer.getSeconds();
	}

	/**
	 * Sets the save file
	 * 
	 * @param fileName the name of the save file
	 */
	public void setSaveFile(String fileName) {
		this.saveFile = new SaveFile(fileName);
		this.saveFile.load();
	}

	/**
	 * Initializes a new pet given the name, type and sets as pet
	 * 
	 * @param name name of the pet
	 * @param petSave save file associated with pet
	 * @param type the type of the pet (dragon, ghost, robot)
	 */
	public void setCurrentPet(String name, SaveFile petSave, String type) {
		if (type.equals("dragon")) {
			this.currentPet = new Dragon(name, petSave, type);
		} else if (type.equals("ghost")) {
			this.currentPet = new Ghost(name, petSave, type);
		} else {
			this.currentPet = new Robot(name, petSave, type);
		}
		this.player = new Player(currentPet);
	}

	/**
	 * Creates a new save file and initializes a new pet and selects 
	 * the first available save slot
	 * 
	 * @param name the name of the pet
	 * @param type the type of the pet
	 * @throws IOException if the save file can't be written to
	 */
	public synchronized void newSaveFile(String name, String type) throws IOException {
		if (!configFile.getSaveStatus("save1")) {
			this.saveFile = new SaveFile("save1.toml");
			this.saveFile.setSaveState(true);
			this.configFile.setSaveStatus("save1", true);
			this.saveFile.loadPet(type);
			this.setCurrentPet(name, saveFile, type);
			this.saveFile.updateSaveFile();
			this.window.viewScreen("LoadingScreen");
		} else if (!configFile.getSaveStatus("save2")) {
			this.saveFile = new SaveFile("save2.toml");
			this.saveFile.setSaveState(true);
			this.saveFile.loadPet(type);
			this.setCurrentPet(name, saveFile, type);
			this.configFile.setSaveStatus("save2", true);
			this.window.viewScreen("LoadingScreen");
		} else if (!configFile.getSaveStatus("save3")) {
			this.saveFile = new SaveFile("save3.toml");
			this.saveFile.setSaveState(true);
			this.saveFile.loadPet(type);
			this.setCurrentPet(name, saveFile, type);
			this.configFile.setSaveStatus("save3", true);
			this.window.viewScreen("LoadingScreen");
		} else {
			this.window.viewScreen("overwrite");
		}
	}

	/**
	 * Gets the total time since game session has started
	 * 
	 * @return the elapsed time in milliseconds
	 */
	public long getElapsedTime() {
		return System.currentTimeMillis() - startTime;
	}
}
