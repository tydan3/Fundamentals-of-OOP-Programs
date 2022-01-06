/*
* Daniel Ty
* 3/7/2019
* TCSS 143 A
* Project 3
*/

/**
 * Represents an item.
 * @author Daniel Ty
 * @version Winter 2019
 */
public class Item extends AbstractGameVisual {
	private char name;
	private double weight;
	private double value;
	
	/**
	 * Parameterless constructor for item, sets item to default values: 
	 * name = '?' , weight = 0, value = 0.
	 */
	public Item() {
		name = '?';
		weight = 0;
		value = 0;
	}

	/**
	 * returns weight of item.
	 * @return item weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * sets weight of item.
	 * @param weight item weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * returns point value of item.
	 * @return item's point value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * sets value of item
	 * @param value item value
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	/**
	 * sets name of item.
	 * @param name
	 */
	public void setName(char name) {
		this.name = name;
	}

	/**
	 * Returns a character to display on screen to represent an item.
	 * @return a character symbolizing the item
	 */
	public char getChar() {
		return name;
	}

	/**
	 * Returns String that represents the object
	 * @return String representation of object
	 */
	public String toString() {
		return "Name: " + name + "\nValue: " + value + "\nWeight " + weight;
	}
}
