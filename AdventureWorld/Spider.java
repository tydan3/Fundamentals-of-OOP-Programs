/*
* Daniel Ty
* 3/7/2019
* TCSS 143 A
* Project 3
*/

/**
 * Represents a spider.
 * @author Daniel Ty
 * @version Winter 2019
 */
public class Spider extends AbstractGameVisual implements Movable {
	private static final char name = 'S';
	private int moveCounter = 0;
	
	/**
	 * Parameterless constructor for a spider.
	 */
	public Spider() {
	}

	/**
	 * Defines movement for spider.
	 */
	public void move() {
		moveCounter++;
		// 10th move: move left 2 if moving position is positive, else move left 2 and add 50 to
		// to position to reappear on other side. 
		if (moveCounter == 10) {
			if (this.getX() - 2 >= 0) {
				this.setX(this.getX() - 2);
			} else {
				this.setX(this.getX() - 2 + 50);
			}
		// 20th move: move up 2 if moving position < 50, else move up 2 and
		// subtract 50 to position to reappear on other side.
		} else if (moveCounter == 20) {
			if (this.getY() + 2 <= 49) {
				this.setY(this.getY() + 2);
			} else {
				this.setY(this.getY() + 2 - 50);
			}
			moveCounter = 0;
		}
	}

	/**
	 * Returns a character to display on screen to represent a spider.
	 * @return a character symbolizing a spider
	 */
	public char getChar() {
		return name;
	}

}
