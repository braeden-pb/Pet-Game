package petgame;

import java.util.*;

/**
 * This class manages a collection of items, with the items being added, removed and getting the 
 * list of items.
 * 
 * @author Braeden Patierno-Barker 251382353 and Michael Pachowski 251371408
 * 
 */

public class Inventory {
	
	/** HashMap storing the items */
	private Map<String, Item> items;
	
	/** HashMap storing the itemCounter */
	private Map<String, Long> itemCounter;
	
	/**
	 * Constructs an inventory and item counter using a HashMap
	 */
	public Inventory(HashMap<String, Long> inventory) {
		items = new HashMap<String,Item>();
		itemCounter = inventory;
		for (String key:itemCounter.keySet()) {
			if (itemCounter.get(key)>0) {
				if (key.equals("apple")||key.equals("applepie")||key.equals("cake")) {
					items.put(key, new Food(key));
				}
				else {
					items.put(key, new Gift(key));
				}
			}
		}
	}
	
	/**
	 * Adds an item to the inventory
	 * 
	 * @param item to be added
	 */
	public void addItems(Item item) {
		String itemName = item.getName().toLowerCase().replaceAll("\\s", "");
		items.put(itemName, item);
		if (itemName.equals("apple")) {
			itemCounter.put(itemName, (itemCounter.get(itemName)) + 1L);
		} else if (itemName.equals("applepie")) {
			itemCounter.put(itemName, (itemCounter.get(itemName)) + 1L);	
		} else if (itemName.equals("cake")) {
			itemCounter.put(itemName, itemCounter.get(itemName) + 1L);	
		} else if (itemName.equals("teddy")) {
			itemCounter.put(itemName, itemCounter.get(itemName) + 1L);	
		} else if (itemName.equals("ball")) {
			itemCounter.put(itemName, itemCounter.get(itemName) + 1L);	
		} else {
			itemCounter.put(itemName, itemCounter.get(itemName) + 1L);
		}
	}
	
	/**
	 * Removes an item from the inventory 
	 * 
	 * @param item to be removed
	 */
	public void removeItems(Item item) {
		String itemName = item.getName().toLowerCase().replaceAll("\\s", "");
		if(items.containsKey(itemName)) { 
			if (itemName.equals("apple")) {
				itemCounter.put(itemName, itemCounter.get(itemName) - 1L);
			} else if (itemName.equals("applepie")) {
				itemCounter.put(itemName, itemCounter.get(itemName) - 1L);	
			} else if (itemName.equals("cake")) {
				itemCounter.put(itemName, itemCounter.get(itemName) - 1L);	
			} else if (itemName.equals("teddy")) {
				itemCounter.put(itemName, itemCounter.get(itemName) - 1L);	
			} else if (itemName.equals("ball")) {
				itemCounter.put(itemName, itemCounter.get(itemName) - 1L);	
			} else {
				itemCounter.put(itemName, itemCounter.get(itemName) - 1L);
			}
			
			if (itemCounter.get(itemName) == 0) {
				items.remove(itemName);
			}
		}
	}
	
	/**
	 * Gets the item currently stored in the inventory
	 * 
	 * @return a Map containing the item names as keys and Item objects as values
	 */
	public Map<String, Item> getItemList() {
		return items;
	}
	
	/**
	 * Gets the item current inventory with a counter
	 * 
	 * @return the inventory with a counter beside the items
	 */
	public Map<String, Long> getInventory() {
		return itemCounter;
	}
	
	/**
	 * Gets the item counter for that specific item and how many of it is stored in inventory
	 * 
	 * @param name takes the name of the item
	 * @return the counter of how many of that specific item is stored in inventory
	 */
	public Long getItemCounter(String name) {
		return itemCounter.get(name.toLowerCase().replaceAll("\\s", ""));
	}
}