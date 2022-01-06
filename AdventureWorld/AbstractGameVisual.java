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
public abstract class AbstractGameVisual implements GameVisual {
	private int x;
	private int y;
	
	/**
	 * Parameterless constructor, sets x and y to default value of 0.
	 */
	public AbstractGameVisual() {
		x = 0;
		y = 0;
	}


	public abstract char getChar();


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public void setX(int x) {
		this.x = x;

	}


	public void setY(int y) {
		this.y = y;
	}

}
