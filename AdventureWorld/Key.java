/*
* Daniel Ty
* 3/7/2019
* TCSS 143 A
* Project 3
*/

/**
 * Represents a key.
 * @author Daniel Ty
 * @version Winter 2019
 */
public class Key extends AbstractGameVisual {
	private static final char name = 'K';
	
	/**
	 * Parameterless constructor for a key.
	 */
	public Key() {
	}

	/**
	 * Returns a character to display on screen to represent a key.
	 * @return a character symbolizing a key
	 */
	public char getChar() {
		return name;
	}

}
