/*
* Daniel Ty
* 3/7/2019
* TCSS 143 A
* Project 3
*/

/**
 * Defines methods necessary for game visuals.
 * @author Daniel Ty
 * @version Winter 2019
 */
public interface GameVisual {
	
	/** 
	 * Returns a character to display on screen to represent the object.
	 * @return character to display on screen
	 */
	public char getChar();
	
	/**
	 * Returns the x position of the game object.
	 * @return x position
	 */
	public int getX();
	
	/**
	 * Returns the y position of the game object.
	 * @return y position
	 */
	public int getY();
	
	/**
	 * Sets the x position of game object.
	 * @param x position for x coordinate
	 */
	public void setX(int x);
	
	/**
	 * Sets the y position of game object
	 * @param y position for y coordinate
	 */
	public void setY(int y);
	
	/**
	 * Returns String that represents the object
	 * @return String representation of object
	 */
	public String toString();

}