# Pet Game

## Description
The Pet Game is an interactive virtual pet simulation developed in Java. It allows players to adopt and manage digital pets by taking responsibility for their health, happiness, sleep, and hunger. The game features a user-friendly graphical user interface (GUI) with various interactive elements designed for ease of use and educational value, teaching responsibility and routine management.

## Requirements
List of required libraries and third-party tools required to run or build your software:
- Java Development Kit (JDK) 23 or newer
- Java Swing (built-in with JDK)
- GitLab (for repository and project management)
- JUnit 5 (for unit testing)

## Building the Software
1. Install JDK 23 or newer.
   - Save the JDK 23 to an easily accessible folder
   - Install the JDK
   - After installation, open a terminal and type java --version. This should be updated to Java 23. 
   - In the search bar, type "Environment Variables"
   - Click "edit the system environment variables"
   - In the "System Properties" window, click "envrionment variables"
   - In the Environemnt variables section, click on "Path" then click "New"
   - paste the location of the JDK 23 folder 
   - Click "ok"
   - Make sure the link of the JDK 23 file is at the top of the path 
2. Clone the GitLab repository:
   ```bash
   git clone <repository-url>
   ```
3. Navigate to the project directory and build the project using your IDE (NetBeans, IntelliJ, Eclipse).

## Running the Software
1. Make sure you have JDK 23 correctly installed. This can be done by:
   - Opening the command prompt from your search bar
   - Type java -version. The output from your command should look something like this: java version "23.0.2" 2025-01-21
   - Then type javac -version. The output from this command should look something like this: javac 23.0.2
2. Run the main class from your IDE or via command line:
   ```bash
   java -jar main.jar
   ```

## User Guide
The Pet Game includes multiple screens and interactions:

- **Main Menu:** Start a new game, load an existing game view tutorials adjst parental controls, or exit.
- **Gameplay:** Manage your pet’s health, sleep, hunger and happiness through interactive commands like feeding playing exercising and veterinary visits
- **Tutorial:** Comprehensive instructions on gameplay and GUI interactions.
- **Pet Selection:** Choose from different pet types each with unique characteristics affecting gameplay
- **Inventory:** Manage food and gifts for your pet which affect fullness and happiness respectively
- **Saving & Loading:** Save your pet's state inventory and scores reload them later to resume gameplay.

### Gameplay Commands:
- **Feed:** Select food to reduce hunger.
- **Give Gift:** Offer gifts to improve happiness.
- **Take to Vet:** Restore pet’s health with cooldown periods.
- **Play:** Increase happiness; limited by cooldown.
- **Exercise:** Boost health but decrease sleepiness and hunger.

### Vital Statistics:
- Health
- Sleep
- Fullness
- Happiness

Vital statistics decrease over time and can be managed through gameplay actions.

## Account Information
The game does not require user accounts but allows multiple save slots for different pets.

## Parental Controls
- Password-protected area accessible from the main menu.
- Set gameplay time limits view playtime statistics reset statistics and revive pets to maximum health.

## Additional Information
- **Extra Features:** Includes non-trivial features like minigames and enhanced animations and unlockable pets and item stores and or advanced parental controls.
- **Accessibility:** Supports keyboard shortcuts and commands and the game is playable with keyboard or mouse for improved accessibility
- **Error Handling:** user-friendly error messages.

## References
- Some assets such as backgrounds were generated using AI.
- Sprites made by Liam Wray
