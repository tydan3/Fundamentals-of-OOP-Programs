package mypackage;

import java.awt.Color;

import ch.aplu.turtle.Turtle;

public class Driver {
	
	public static void main(String[] args) {
		Turtle t = new Turtle(Color.MAGENTA);
		//t.forward(100);
		//t.right(90);
		//t.forward(100);
		//TurtleOps.drawSpiralIterative(t, 200, 25);
		//TurtleOps.drawSpiralRecursive(t, 200, 25);
		//TurtleOps.drawBoxes(t, 200, 25);
		//TurtleOps.drawBoxesRecursive(t, 200, 25);
		//TurtleOps.drawTree(t, 100, 15);
		TurtleOps.drawKoch(t, 300, 4);
	}

}
