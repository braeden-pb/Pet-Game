package petgame;

import java.io.IOException;

import javax.swing.Timer;

/**
 * This class creates a timer in the background of the program to control 
 * the flow of certain events.
 * 
 * @author Evan Salmon 251351912
 * 
 */

public class GameLoop {

	/** Initializes a screen timer */
	private Timer screenTimer;
	
	/** Initializes a stats timer */
	private Timer statsTimer;
	
	/** Initializes a progress timer */
	private Timer progressTimer;
	
	/** Initializes a states timer */
	private Timer stateTimer;
	
	private Timer constantTimer;
	
	/** Initializes ticks for every second the statsTimer runs */
	private int tick = 0;
	
	/** Initializes ticks for every frame */
	private int frameTick;
	
	/**
	 * Initializes ticks for every second the application is running
	 */
	private int constantTick;
	
	
	/**
	 * This constructors starts a screen timer and stats timer. It then
	 * constantly checks the states of the pet and updates the stats of the pet 
	 */
	public GameLoop() {
		stateTimer = new Timer(16, e -> {
			frameTick++;
			Game.getInstance().getCurrentPet().checkStates(frameTick);
	});
		screenTimer = new Timer(16, e -> {
				Game.getInstance().getGui().updateScreen();
				try {
					Game.getInstance().getGui().checkTimelimit();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		});
		statsTimer = new Timer(1000, e -> {
			tick++;
			Game.getInstance().getCurrentPet().checkScore();
			Game.getInstance().getCurrentPet().updateStats(tick);
			Game.getInstance().getGui().updateProgressBar();
			Game.getInstance().getGui().setFlipped(tick);
		});	
		
		progressTimer = new Timer(100, e-> {
			Game.getInstance().getGui().updateProgressBar();
		});
		
		constantTimer = new Timer(1000, e-> {
			constantTick++;
			
		});
	}
	
	
	/**
	 * gets the running time in seconds and converts it to hh:mm:ss format
	 * @return a formated time string
	 */
	public String getTime() {
		int hours = constantTick / 3600;
	    int secondsLeft = constantTick - hours * 3600;
	    int minutes = secondsLeft / 60;
	    int seconds = secondsLeft - minutes * 60;

	    String formattedTime = "";
	    if (hours < 10)
	        formattedTime += "0";
	    formattedTime += hours + ":";

	    if (minutes < 10)
	        formattedTime += "0";
	    formattedTime += minutes + ":";

	    if (seconds < 10)
	        formattedTime += "0";
	    formattedTime += seconds ;

	    return formattedTime;
	    //taken from https://stackoverflow.com/questions/22545644/how-to-convert-seconds-into-hhmmss
	}
	
	public int getSeconds () {
		return tick;
	}
		
	/**
	 * This starts the stat and screen timer
	 */
	public void startTimer() {
		statsTimer.start();
		screenTimer.start();
		stateTimer.start();
		progressTimer.start();
	}
	
	/**
	 * This starts the progressTimer
	 */
	public void startProgressTimer() {
		progressTimer.start();
	}
	
	
	/**
	 * This starts the constantTimer
	 */
	public void startConstantTimer() {
		constantTimer.start();
	}
	
	
	/**
	 * This ends the stat timer and resets the tick to 0
	 */
	public void endTimer() {
		statsTimer.stop();
		stateTimer.stop();
		tick = 0;
	}
	
}
