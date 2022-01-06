// this is the class that contains the actual world to be drawn

import java.util.*;

public class SimModel {
	private int myHeight;
	private int myWidth;
	private GameVisual[][] myGrid;
	private char[][] display;
	private ArrayList<GameVisual> myList;
	private SortedMap<String, Integer> entityCount;

	public SimModel(int width, int height) {
		myWidth = width;
		myHeight = height;
		myGrid = new GameVisual[width][height];
		display = new char[width][height];
		updateDisplay();
		myList = new ArrayList<GameVisual>();
		entityCount = new TreeMap<String, Integer>();
	}

	public void add(int number, Class entity) {
		if (myList.size() + number > myWidth * myHeight)
			throw new RuntimeException("adding too many elements");
		for (int i = 0; i < number; i++) {
			Object instance;
			try {
				instance = entity.newInstance();
			} catch (Exception e) {
				throw new RuntimeException("no zero-argument constructor for "
						+ entity);
			}
			if (!(instance instanceof GameVisual)) {
				throw new RuntimeException(entity
						+ " does not implement GameVisual");
			}
			GameVisual next = (GameVisual)instance;
			int x, y;
			do {
				x = randomInt(0, myWidth - 1);
				y = randomInt(0, myHeight - 1);
			} while (myGrid[x][y] != null);
			myGrid[x][y] = next;
			next.setX(x);
			next.setY(y);
			if (next.getClass().getName().equals("Item")) {
				int var = randomInt(0,3);
				if (var == 0) {
					((Item) next).setName('C');
					((Item) next).setValue(randomInt(1,20));
					((Item) next).setWeight(1.0);
				} else if (var == 1) {
					((Item) next).setName('J');
					int v = randomInt(1000,5000);
					((Item) next).setValue(v);
					((Item) next).setWeight(v-900);
				} else {
					((Item) next).setName('B');
					((Item) next).setValue(300);
					((Item) next).setWeight(300);
				}
			} 
			display[x][y] = next.getChar();
			myList.add(next);
		}
		String name = entity.getName();
		if (!entityCount.containsKey(name))
			entityCount.put(name, number);
		else
			entityCount.put(name, entityCount.get(name) + number);
	}

	private static int randomInt(int low, int high) {
		return low + (int)(Math.random() * (high - low + 1));
	}

	public int getWidth() {
		return myWidth;
	}

	public int getHeight() {
		return myHeight;
	}

	public char getChar(int x, int y) {
		return display[x][y];
	}


	private void updateDisplay() {
		// set it to all dots
		for (int x = 0; x < myWidth; x++) 
			for (int y = 0; y < myHeight; y++)
				if (myGrid[x][y] == null)
					display[x][y] = '.';
				else
					display[x][y] = myGrid[x][y].getChar();
	}

	public void update() {
		GameVisual[][] newGrid = new GameVisual[myWidth][myHeight];
		//System.out.println(myWidth);
		for (int i = 0; i < myList.size(); i++) {
			GameVisual next = myList.get(i);
			Movable m1;
			if (next instanceof Movable) {
				m1 = (Movable) next;
				m1.move();
			}
			int x = next.getX();
			int y = next.getY();
			if(newGrid[x][y] == null)
				newGrid[x][y] = next;
			else {
				// if the new entity to consider is a spider, it gobbles up the prior cell contents
				if (next.getChar() == 'S') {
					String c = newGrid[x][y].getClass().getName();
					entityCount.put(c, entityCount.get(c) - 1);
					myList.remove(newGrid[x][y]);
					newGrid[x][y] = next;			
				} 
				// the new entity is not a spider
				else {
					// if the spider is sitting in the grid cell, tough luck, the new entity is gobbled up regardless of what it is
					if (newGrid[x][y].getChar() == 'S') {
						String c = next.getClass().getName();
						entityCount.put(c, entityCount.get(c) - 1);
						myList.remove(next);           			
					}
					// else it must be some adventurer - item or adventurer - key combination
					else {
						if (!(next instanceof Adventurer)) {
							Adventurer person = (Adventurer) newGrid[x][y];
							// arriving item is a key
							if (next instanceof Key) {
								if (!person.hasKey()) {
									person.addKey();
									String c = next.getClass().getName();
									entityCount.put(c, entityCount.get(c) - 1);
									myList.remove(next);
								}						}
							// arriving item is an item
							else if (next instanceof Item) {
								Item myitem = (Item) next;
								if (person.hasSpace(myitem.getWeight())) {
									person.addItem(myitem);
									String c = next.getClass().getName();
									entityCount.put(c, entityCount.get(c) - 1);
									myList.remove(next);
								}
							}
						}
						else {
							Adventurer person = (Adventurer) next;
							// old item is a key
							if (newGrid[x][y] instanceof Key) {
								if (!person.hasKey()) {
									person.addKey();
									String c = newGrid[x][y].getClass().getName();
									entityCount.put(c, entityCount.get(c) - 1);
									myList.remove(newGrid[x][y]);
									newGrid[x][y] = next;
								}						
							}
							// old item is an item
							else if (newGrid[x][y] instanceof Item) {
								Item myitem = (Item) newGrid[x][y];
								if (person.hasSpace(myitem.getWeight())) {
									person.addItem(myitem);
									String c = newGrid[x][y].getClass().getName();
									entityCount.put(c, entityCount.get(c) - 1);
									myList.remove(newGrid[x][y]);
									newGrid[x][y] = next;
								}
							}

						}
					}				
				}
			}
		}
		myGrid = newGrid;
		updateDisplay();
	}

	public Set<Map.Entry<String, Integer>> getCounts() {
		return Collections.unmodifiableSet(entityCount.entrySet());
	}

	public void printStats() {
		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i).getChar() == 'A') {
				System.out.println("\nAdventurer:");
				Adventurer person = (Adventurer) myList.get(i);
				System.out.println(person);
			}
		}
	}

}
