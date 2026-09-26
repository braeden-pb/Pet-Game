package petgame;


import java.awt.DefaultFocusTraversalPolicy;
import java.io.File;
import java.io.IOException;
import java.time.*;
import java.util.HashMap;
import java.util.Map;
import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;


/**
 * This class is responsible for loading and managing game save data 
 * from a TOML file. It provides methods to retrieve various attributes of the saved 
 * game, such as the pet's type, health, hunger, happiness, and other game-related 
 * statistics. Additionally, it supports fetching parental control settings and game 
 * session information from the config file.
 * 
 * @author Evan Salmon 251351912
 */
public class SaveFile {
	private Toml saveFile;
	private  Map<String, Object>  saveData;
	private TomlWriter writer;
	private File file;	
	
	/**
	 * Constructor Initializes save data from a given file name
	 * @param filename the name of the TOML file to be used
	 */
	public SaveFile(String filename)  {
		
		String appDir = System.getProperty("user.dir");
		File saveDir = new File(appDir,"saves");
		
		 if (!saveDir.exists()) {
			    saveDir.mkdir();
			}
		
		writer = new TomlWriter();
		 
		
		 
		 this.file = new File(saveDir,filename);
		 
		 if (!file.exists()) {
			 Map<String, Object> defaultData = initializeData();
		        try {
					writer.write(defaultData, file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
		 
		saveFile = new Toml().read(file);
		saveData = new HashMap<>(saveFile.toMap());
		}
	
	
	/**
	 * Initialize default save data
	 * @return default data for a save file
	 */
	public Map<String, Object> initializeData() {
        Map<String, Object> data = new HashMap<>();
        
        Map<String,Object> petData= new HashMap<>();
        petData.put("sleep", 0);
        petData.put("happiness", 0);
        petData.put("name", "");
        petData.put("health", 0);
        petData.put("dead", "false");
        petData.put("state", "normal");
        petData.put("type", "");
        petData.put("hunger", 0);
        
        Map<String, Object> gameData = new HashMap<>();
        gameData.put("score", 0);
        gameData.put("inuse", true);
        gameData.put("lastplayed", "");
        
        Map<String, Object> inventoryData = new HashMap<>();
        inventoryData.put("apple", 5);
        inventoryData.put("ball", 5);
        inventoryData.put("teddy", 3);
        inventoryData.put("cake", 1);
        inventoryData.put("fidgetspinner", 1);
        inventoryData.put("applepie", 3);
        
        data.put("pet", petData);
        data.put("game", gameData);
        data.put("Inventory", inventoryData);
        
        return data;
        
	}
	
	/**
	 * Gets the pet type from the save file
	 * 
	 * @return a string of the current save file pet's type
	 */
	public String getPetType() {
		return saveFile.getString("pet.type");
	}
	
	/**
	 * Loads content of the file
	 */
	public void load() {
		this.saveFile = new Toml().read(file);
		}
	
	
	/**
	 * Gets if the current save file is being used
	 * 
	 * @return boolean value of it the current save file is in use
	 */
	public boolean inUse() {
		return saveFile.getBoolean("game.inuse");
	}
	
	/**
	 * Gets the pet's health value from the save file
	 * 
	 * @return an integer of the current save file pet's health value
	 */
	public Integer getHealth() {
		return saveFile.getLong("pet.health").intValue();
	}
	
	/**
	 * Gets the pet's name from the save file
	 * 
	 * @return a string of the current savefile pet's name
	 */
	public String getName() {
		return saveFile.getString("pet.name");
	}
	
	/**
	 * Gets the pet's health value from the save file
	 * 
	 * @return an integer of the current save file pet's health value
	 */
	public Integer getHunger() {
		return saveFile.getLong("pet.hunger").intValue();
	}
	
	/**
	 * Gets the game score of the save file
	 * 
	 * @return an integer of the current save file's game score
	 */
	public Integer getScore() {
		return saveFile.getLong("game.score").intValue();
	}
	
	/**
	 * Gets the pet's happiness value from the save file
	 * 
	 * @return an integer of the current save file pet's happiness value
	 */
	public Integer getHappiness() {
		return saveFile.getLong("pet.happiness").intValue();
	}
	
	/**
	 * Gets the pet's sleep value from the save file
	 * 
	 * @return an integer of the current save file pet's sleep value
	 */
	public Integer getSleep() {
		return saveFile.getLong("pet.sleep").intValue();
	}
	
	/**
	 * Gets the pet's state from the save file
	 * 
	 * @return a string of the current save file pet's state
	 */
	public String getState() {
		return saveFile.getString("pet.state");
	}
	
	/**
	 * This sets a save state for a file to true or false
	 * @param state a true or false state for the save file
	 * @throws IOException if writing to the save file fails
	 */
	public void setSaveState(Boolean state) throws IOException {
		Map<String, Object> gameInfo = new HashMap<>((Map<String, Object>) saveData.get("game"));
		gameInfo.put("inuse", state);
		saveData.put("game", gameInfo);
		writer.write(saveData, file);
		Game.getInstance().getConfigFile().setSaveStatus(file.getName().replaceAll(".toml", ""), state);
		 this.saveFile = new Toml().read(file);
	}
	
	/**
	 * This sets a name of the file
	 * @throws IOException if writing to the save file fails
	 */
	public void setName(String name) throws IOException {
		Map<String, Object> petInfo = new HashMap<>((Map<String, Object>) saveData.get("pet"));
		petInfo.put("name", name);
		saveData.put("pet", petInfo);
		writer.write(saveData, file);
		 this.saveFile = new Toml().read(file);
		
	}
	
	/**
	 * This loads a pet type into the toml file
	 */
	public void resetSaveFile(String type) throws IOException {
		loadPet(type);
	}
	
	/**
	 * This loads the inventory of the pet
	 */
	public HashMap<String,Long> getInventory() {;
		return (HashMap<String, Long>) saveFile.toMap().get("Inventory");
	}
	
	/**
	 * This revives the pet once the pet is in the dead state and by 
	 * going to parental controls and clicking revive 
	 */
	public void revivePet() throws IOException {
		Map<String, Object> petInfo = new HashMap<>((Map<String, Object>) saveData.get("pet"));
		if (saveFile.getString("pet.type").equals("dragon")) {
			petInfo.put("health", 150);
			petInfo.put("sleep", 100);
			petInfo.put("happiness", 90);
			petInfo.put("hunger", 120);
			petInfo.put("state", "normal");
			petInfo.put("dead", false);
		} else if (saveFile.getString("pet.type").equals("robot")) {
			petInfo.put("health", 120);
			petInfo.put("sleep", 80);
			petInfo.put("happiness", 100);
			petInfo.put("hunger", 80);
			petInfo.put("state", "normal");
			petInfo.put("dead", false);
		} else {
			petInfo.put("health", 80);
			petInfo.put("sleep", 120);
			petInfo.put("happiness", 90);
			petInfo.put("hunger", 110);
			petInfo.put("state", "normal");
			petInfo.put("dead", false);
		}
		saveData.put("pet", petInfo);
		TomlWriter writer = new TomlWriter();
	    writer.write(saveData, file);
	    this.saveFile = new Toml().read(file);
	}
	
	/**
	 * This loads the pet with the correct stats depending on the pet type
	 */
	public synchronized void  loadPet(String type) throws IOException {
		Map<String, Object> petInfo = new HashMap<>((Map<String, Object>) saveData.get("pet"));
		Map<String, Object> inventoryInfo = new HashMap<>((Map<String, Object>) saveData.get("Inventory"));
		Map<String, Object> gameInfo = new HashMap<>((Map<String, Object>) saveData.get("game"));
		System.out.println(petInfo.toString());
		if (type.equals("dragon")) {
			petInfo.put("health", 150);
			petInfo.put("sleep", 100);
			petInfo.put("happiness", 90);
			petInfo.put("hunger", 120);
			petInfo.put("state", "normal");
			petInfo.put("dead", false);
		} else if (type.equals("robot")) {
			petInfo.put("health", 120);
			petInfo.put("sleep", 80);
			petInfo.put("happiness", 100);
			petInfo.put("hunger", 80);
			petInfo.put("state", "normal");
			petInfo.put("dead", false);
		} else {
			petInfo.put("health", 80);
			petInfo.put("sleep", 120);
			petInfo.put("happiness", 90);
			petInfo.put("hunger", 110);
			petInfo.put("state", "normal");
			petInfo.put("dead", false);
		}
		
		inventoryInfo.put("apple", 5);
		inventoryInfo.put("applepie", 3);
		inventoryInfo.put("cake", 1);
		inventoryInfo.put("ball", 5);
		inventoryInfo.put("teddy", 3);
		inventoryInfo.put("fidgetspinner", 1);
		
		gameInfo.put("score", 0);
		

		
		saveData.put("pet", petInfo);
		saveData.put("Inventory", inventoryInfo);
		saveData.put("game", gameInfo);
	    writer.write(saveData, file);
	    this.saveFile = new Toml().read(file);
    }
	
	public void deleteSave() throws IOException {
		Map<String, Object> gameInfo = new HashMap<>((Map<String, Object>) saveData.get("game"));
		gameInfo.put("inuse", false);
		saveData.put("game", gameInfo);
		writer.write(saveData, file);
	    this.saveFile = new Toml().read(file);
		Game.getInstance().getConfigFile().setSaveStatus(file.getName().replaceAll(".toml", ""), false);
}
	
	/**
	 * This updates the save file with the correct stats depending on what is in the toml file
	 */
	public void updateSaveFile() throws IOException {
		Map<String, Object> petInfo = new HashMap<>((Map<String, Object>) saveData.get("pet"));
		Map<String, Object> gameInfo = new HashMap<>((Map<String, Object>) saveData.get("game"));
		Map<String, Object> inventoryInfo = new HashMap<>((Map<String, Object>) saveData.get("Inventory"));
		petInfo.put("health", Game.getInstance().getCurrentPet().getHealth());
		petInfo.put("sleep", Game.getInstance().getCurrentPet().getSleep());
		petInfo.put("happiness", Game.getInstance().getCurrentPet().getHappiness());
		petInfo.put("state",Game.getInstance().getCurrentPet().getState());
		petInfo.put("name", Game.getInstance().getCurrentPet().getName());
		petInfo.put("type", Game.getInstance().getCurrentPet().getType());
		petInfo.put("hunger", Game.getInstance().getCurrentPet().getFullness());
		gameInfo.put("score", Game.getInstance().getCurrentPet().getScore());
		inventoryInfo.putAll(Game.getInstance().getCurrentPet().getInventoryMap());
		gameInfo.put("lastPlayed", LocalDateTime.now().toString());
		if (Game.getInstance().getCurrentPet().getState().equals("dead")) {
			petInfo.put("dead", true);
		}
		
		saveData.put("pet", petInfo);
		saveData.put("game", gameInfo);
		saveData.put("Inventory", inventoryInfo);
		TomlWriter writer = new TomlWriter();
        writer.write(saveData, file);
	    this.saveFile = new Toml().read(file);

	}
	
	
	
	
	
}
