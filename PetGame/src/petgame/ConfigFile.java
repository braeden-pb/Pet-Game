package petgame;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;


/**
 * This class handles reading from and writing to the config.toml file. This
 * includes game stats, save status, and parental controls.
 * 
 * @author Evan Salmon 251351912
 * 
 */

public class ConfigFile {
	
	/** Initializes a toml file */
	private Toml configFile;
	
	/** Initializes a HashMap */
	private Map<String, Object> configData;
	
	/** Initializes a toml file */
	private TomlWriter writer;
	
	
	/**
	 * Sets the config file
	 */
	private File config;

	/**
	 * This constructor loads and parses config.toml into a writable map using toml
	 */
	public ConfigFile() {
		String appDir = System.getProperty("user.dir");
		File saveDir = new File(appDir,"saves");
		writer = new TomlWriter();
		config = new File(saveDir,"config.toml");
		
		if (!saveDir.exists()) {
		    saveDir.mkdir();
		}
		
		 if (!config.exists()) {
			 Map<String, Object> defaultData = initializeConfigData();
		        try {
					writer.write(defaultData, config);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		
		configFile = new Toml().read(config);
		configData = new HashMap<>(configFile.toMap());
	}
	
	/**
	 * Gets the play time across all save files from the config file
	 * 
	 * @return the total play time across all save files in hh:mm:ss format
	 */
	public  String getTotalTime() {
		String hour = configFile.getLong("stats.totalHours").toString();
		String min = configFile.getLong("stats.totalMins").toString();
		String sec = configFile.getLong("stats.totalSecs").toString();
		
		return hour + " hours " + min + " mins " + sec + " seconds";

	}
	
	/**
	 * Initializes the data for the config file with default values
	 * @return default data for the config file
	 */
	public Map<String, Object> initializeConfigData() {
		Map<String, Object> data = new HashMap<>();
		
		Map<String, Object> savesData = new HashMap<>();
		savesData.put("save1", false);
		savesData.put("save2", false);
		savesData.put("save3", false);
		
		Map<String, Object> statsData = new HashMap<>();
		statsData.put("totalSecs", 0);
		statsData.put("totalMins", 0);
		statsData.put("totalHours", 0);
		statsData.put("avgHours", 0);
		statsData.put("avgMins", 0);
		statsData.put("avgSecs", 0);
		statsData.put("totalSessions", 0);
		
		Map<String, Object> parentalControlData = new HashMap<>();
		parentalControlData.put("timeLimit", false);
		parentalControlData.put("timeEnd", "00:00:00");
		parentalControlData.put("password", "");
		parentalControlData.put("timeStart", "00:00:00");
		
		data.put("saves", savesData);
		data.put("stats", statsData);
		data.put("parentalControls", parentalControlData);
		
		return data;
		
		
	}
	
	/**
	 * Gets the average play time for a session across all save files from the config file
	 * 
	 * @return he average play time for a session across all save files in hh:mm:ss format
	 */
	public String getAverageTime() {
		String hour = configFile.getLong("stats.avgHours").toString();
		String min = configFile.getLong("stats.avgMins").toString();
		String sec = configFile.getLong("stats.avgSecs").toString();
		
		return hour + " hours " + min + " mins " + sec + " seconds";
	}
	
	
	/**
	 * Gets the password to access parental controls from the config file
	 * 
	 * @return a string of a 4-digit password pin 
	 */
	public String getPassword() {
		return configFile.getString("parentalControls.password");
		
	}
	
	/**
	 * Gets the save status of the file based on if it in use or not
	 * 
	 * @param filename The filename of the save file to get
	 * @return the save status of the file
	 */
	public Boolean getSaveStatus(String filename) {
		return configFile.getBoolean("saves." + filename);
	}
	
	/**
	 * This sets the save status whether or not the file is in use or not
	 * 
	 * @param filename This takes the filename of the file
	 * @param status This sets whether or not the file is being used
	 * @throws IOException This throws an exception if it can't write to the file
	 */
	public void setSaveStatus(String filename, Boolean status) throws IOException {
		Map<String, Object> saves = new HashMap<>((Map<String, Object>) configData.get("saves"));
		saves.put(filename, status);
		configData.put("saves", saves);
		writer.write(configData, config);
		 this.configFile = new Toml().read(config);
	}
	
	/**
	 * Gets if the time window feature is enabled or not
	 * 
	 * @return a boolean representing if the time limit feature is enabled 
	 */
	public Boolean timeWindowEnabled() {
		return configFile.getBoolean("parentalControls.timeLimit");
	}
	
	/**
	 * Sets a new password for the parental controls
	 * 
	 * @param password A string of the new password
	 * @throws IOException if the writer can't write to the config file 
	 */
	public void setPassword(String password) throws IOException  {
		Map<String, Object> parentalControls = new HashMap<>((Map<String, Object>) configData.get("parentalControls"));
		parentalControls.put("password", password);
		configData.put("parentalControls", parentalControls);
        writer.write(configData, config);
		 this.configFile = new Toml().read(config);
	}
	
	/**
	 * Sets the time limit for the player
	 * 
	 * @param startTime start time of the time limit
	 * @param endTime end time of the time limit
	 * @throws IOException if the writer can't write to the config file 
	 */
	public void setTimeLimits(String startTime, String endTime) throws IOException {
		Map<String, Object> parentalControls = new HashMap<>((Map<String, Object>) configData.get("parentalControls"));
		parentalControls.put("timeStart", startTime);
		parentalControls.put("timeEnd", endTime);
		configData.put("parentalControls", parentalControls);
        writer.write(configData, config);
		 this.configFile = new Toml().read(config);
	}
	
	/**
	 * Sets whether or not the time limit is set
	 * 
	 * @param value whether there is a time limit set
	 * @throws IOException if the writer can't write to the config file 
	 */
	public void setTimeLimit(Boolean value) throws IOException {
		Map<String, Object> parentalControls = new HashMap<>((Map<String, Object>) configData.get("parentalControls"));
		parentalControls.put("timeLimit", value);
		configData.put("parentalControls", parentalControls);
        writer.write(configData,config);
		 this.configFile = new Toml().read(config);
	}
	
	
	/**
	 * Gets the time limit set by the parent
	 * 
	 * @return a boolean whether or not the player is allowed to play 
	 */
	public Boolean getTimeLimit() {
		return configFile.getBoolean("parentalControls.timeLimit");
	}
	
	/**
	 * Gets start time set by the parent
	 * 
	 * @return The start window of when they player can play
	 */
	public LocalTime getStartWindow() {
		return LocalTime.parse(configFile.getString("parentalControls.timeStart"));
	}
	
	/**
	 * Gets end time set by the parent
	 * 
	 * @return The end window of when they player can't play
	 */
	public LocalTime getEndWindow() {
		return LocalTime.parse(configFile.getString("parentalControls.timeEnd"));
	}
	
	/**
	 * This finds the total time the player has been playing the game
	 * @throws IOException  if writing to the config fails
	 */
	public void calculateTotalTime() throws IOException {
		int oldHour = configFile.getLong("stats.totalHours").intValue();
		int oldMin = configFile.getLong("stats.totalMins").intValue();
		int oldSec = configFile.getLong("stats.totalSecs").intValue();
		
		String newTime = Game.getInstance().getTime();
		String[] newtimeList = newTime.split(":");
		int newHour = Integer.parseInt(newtimeList[0]);
		int newMin = Integer.parseInt(newtimeList[1]);
		int newSec = Integer.parseInt(newtimeList[2]);
		
		newHour = newHour +oldHour;
		
		if (newSec+oldSec >60) {
			newMin+=1;
		}
		else {
			newSec = newSec+oldSec;
		}
		
		if (newMin+oldMin>60) {
			newHour+=1;
		}
		else {
			newMin = newMin +oldMin;
		}
		
		Map<String, Object> stats = new HashMap<>((Map<String, Object>) configData.get("stats"));
		stats.put("totalHours", newHour);
		stats.put("totalMins", newMin);
		stats.put("totalSecs", newSec);
		configData.put("stats", stats);
		writer.write(configData,config);
		 this.configFile = new Toml().read(config);
	}
	
	/**
	 * This finds the average time the player has been playing the game every day
	 * @throws IOException  if writing to the config fails
	 */
	public void calculateAverageTime() throws IOException {
		int totalSession = configFile.getLong("stats.totalSessions").intValue() +1;
		int sessionSeconds = Game.getInstance().getSeconds();
		int totalSecods = (configFile.getLong("stats.totalHours").intValue()*3600) + (configFile.getLong("stats.totalMins").intValue()*60) + configFile.getLong("stats.totalSecs").intValue();
		int averageSec = (sessionSeconds + totalSecods)/totalSession;
		int averageHours = averageSec / 3600;
	    int secondsLeft = averageSec - averageHours * 3600;
	    int averageMinutes = secondsLeft / 60;
	    averageSec = secondsLeft - averageMinutes * 60;
	    
	    Map<String, Object> stats = new HashMap<>((Map<String, Object>) configData.get("stats"));
		stats.put("avgHours", averageHours);
		stats.put("avgMins", averageMinutes);
		stats.put("avgSecs", averageSec);
		stats.put("totalSessions", totalSession);
		configData.put("stats", stats);
		writer.write(configData,config);
		 this.configFile = new Toml().read(config);
		
	}
	
	
	/**
	 * Resets the total and average play time
	 * @throws IOException if writing to the config fails
	 */
	public void resetTime() throws IOException {
		Map<String, Object> stats = new HashMap<>((Map<String, Object>) configData.get("stats"));
		stats.put("totalHours", 0);
		stats.put("totalMins", 0);
		stats.put("totalSecs", 0);
		stats.put("avgHours", 0);
		stats.put("avgMins", 0);
		stats.put("avgSecs", 0);
		stats.put("totalSessions", 0);
		configData.put("stats", stats);
		writer.write(configData,new File("config.toml"));
		 this.configFile = new Toml().read(config);
	}
}
