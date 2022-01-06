/*
* Daniel Ty
* 3/7/2019
* TCSS 143 A
* Project 3
*/
import java.util.ArrayList;

/**
 * Represents a backpack.
 * @author Daniel Ty
 * @version Winter 2019
 */
public class Backpack {
	private double maxSize;
	private double weight;
	private ArrayList<Item> itemList = new ArrayList<Item>();
	
	/**
	 * Constructs a backpack of given weight capacity.
	 * @param maxSize max weight backpack can carry
	 */
	public Backpack(double maxSize) {
		this.maxSize = maxSize;
		weight = 0;
	}
	
	/**
	 * Returns backpack's max carry weight. 
	 * @return max carry weight
	 */
	public double getMaxSize() {
		return maxSize;
	}
	
	/**
	 * Returns total weight of items in backpack.
	 * @return weight inside backpack
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Adds an item to the backpack.
	 * @param someItem item to be added to backpack
	 */
	public void addItem(Item someItem) {
		// only add item if its addition to weight in backpack doesn't exceed carry capacity
		if (weight + someItem.getWeight() <= maxSize) {
			itemList.add(someItem);
			// add item's weight to weight in backpack
			weight += someItem.getWeight();
		}
	}
	
	/**
	 * Returns String that represents the backpack
	 * @return String representation of backpack
	 */
	public String toString() {
		// Track total worth, print out contents of backpack, print total weight and worth
		String s = "";
		double totalWorth = 0;
		for (Item element : itemList) {
			s += element.toString() + "\n";
			totalWorth += element.getValue();
		}
		s += "\n~ Weight: " + weight + "\n~ Total Worth: " + totalWorth;
		return s;
	}
}
