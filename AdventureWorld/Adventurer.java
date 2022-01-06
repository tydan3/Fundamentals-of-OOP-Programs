/*
* Daniel Ty
* 3/7/2019
* TCSS 143 A
* Project 3
*/

/**
 * Represents an adventurer.
 * @author Daniel Ty
 * @version Winter 2019
 */
public class Adventurer extends AbstractGameVisual implements Movable {
	private static final char name =  'A';
	private Backpack pack;
	private boolean hasKey = false;
	private int moveCounter = 0;
	
	/**
	 * Parameterless constructor for an adventurer.
	 */
	public Adventurer() {
		pack = new Backpack(1000);
	}

	/**
	 * Returns whether there is space for a given item to be added into backpack.
	 * @param newItemsWeight weight of item to be added
	 * @return true if there is space for the item, false if not.
	 */
	public boolean hasSpace(double newItemsWeight) {
		return pack.getWeight() + newItemsWeight < pack.getMaxSize();
	}
	
	/**
	 * Adds an item to adventurer's backpack.
	 * @param someItem item to be added to backpack
	 */
	public void addItem(Item someItem) {
		pack.addItem(someItem);
	}
	
	/**
	 * Adds key to adventurer's possession.
	 */
	public void addKey() {
		if (!hasKey) {
			Key myKey = new Key();
			hasKey = true;
		}
	}
	
	/**
	 * Returns whether an adventurer has a key.
	 * @return true if they have a key, false if not.
	 */
	public boolean hasKey() {
		return hasKey;
	}
	
	/**
	 * Defines movement for adventurer.
	 */
	public void move() {
		moveCounter++;
		// 1st move: move left 1 if moving position is positive, else move left 1 and add 50 to
		// to position to reappear on other side.
		if (moveCounter == 1) {
			if (this.getX() - 1 >= 0) {
				this.setX(getX() - 1);
			} else {
				this.setX(getX() - 1 + 50);
			}
		// 2nd and 3rd move: move up 1 if moving position < 50, else move up 1 and
		// subtract 50 to position to reappear on other side.	
		} else if (moveCounter == 2 || moveCounter == 3) {
			if (this.getY() + 1 < 50) {
				this.setY(getY() + 1);
			} else {
				this.setY(this.getY() + 1 - 50);
			}
		// 4th thru 6th move: move right 1 if moving position < 50, else move right 1 and
		// subtract 50 to position to reappear on other side.
		} else if (moveCounter >= 4 && moveCounter <= 6) {
			if (this.getX() + 1 < 50) {
				this.setX(getX() + 1);
			} else {
				this.setX(this.getX() + 1 - 50);
			}
		// 7th thru 10th move: move down 1 if moving position is positive, else move down 1 and add 50 to
		// to position to reappear on other side. After tenth move, reset move counter.
		} else {
			if (this.getY() - 1 >= 0) {
				this.setY(getY() - 1);
			} else {
				this.setY(getY() - 1 + 50);
			}
			if (moveCounter == 10) {
				moveCounter = 0;
			}
		}
	}
	
	/**
	 * Returns a character to display on screen to represent an adventurer.
	 * @return a character symbolizing an adventurer
	 */
	public char getChar() {
		return name;
	}
	
	/**
	 * Returns String that represents the adventurer and their belongings.
	 * @return String representation of adventurer and their belongings
	 */
	public String toString() {
		// print adventurer's position, backpack contents, and key status
		String s = "Adventurer:\n(" + this.getX() + ", " + this.getY() + ")\n";
		s += pack.toString() + "\n\nThis adventurer's key status = " + hasKey;
		return s;
	}

}
