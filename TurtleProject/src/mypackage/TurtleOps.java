package mypackage;

import ch.aplu.turtle.Turtle;

public class TurtleOps {
	
	public static void drawSpiralIterative(Turtle tom, int initialLength, int decrement) {
		while (initialLength > 0) {
			tom.forward(initialLength);
			tom.right(90);
			initialLength -= decrement;
		}
	}
	
	public static void drawSpiralRecursive(Turtle tom, int initialLength, int decrement) {
		if (initialLength > 0) {
			tom.forward(initialLength);
			tom.right(90);
			drawSpiralRecursive(tom, initialLength - decrement, decrement);
		}
	}
	
	public static void drawBox(Turtle tom, int side) {
		for (int i = 0; i < 4; i++) {
			tom.forward(side);
			tom.right(90);
		}
	}
	
	public static void drawBoxes(Turtle tom, int initialLength, int decrement) {
		while (initialLength > 0) {
			drawBox(tom, initialLength);
			initialLength -= decrement;
			
		}
	}
	
	public static void drawBoxesRecursive(Turtle tom, int initialLength, int decrement) {
		if (initialLength > 0) {
			drawBox(tom, initialLength);
			drawBoxesRecursive(tom, initialLength -= decrement, decrement);
		}
	}
	
	public static void drawTree(Turtle tom, int initialLength, int decrement) {
		if (initialLength >= 5) {
			tom.forward(initialLength);
			tom.right(30);
			drawTree(tom, initialLength - decrement, decrement);
			tom.left(60);
			drawTree(tom, initialLength - decrement, decrement);
			tom.right(30);
			tom.back(initialLength);
		}
	}
	
	public static void drawKoch(Turtle tom, double side, int level) {
		if (level == 0) {
			tom.forward(side);
		} else {
			drawKoch(tom, side / 3.0, level - 1);
			tom.left(60);
			drawKoch(tom, side / 3.0, level - 1);
			tom.right(120);
			drawKoch(tom, side / 3.0, level - 1);
			tom.left(60);
			drawKoch(tom, side / 3.0, level - 1);
			
			
		}
	}
}
