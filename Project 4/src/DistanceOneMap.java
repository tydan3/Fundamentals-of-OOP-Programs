
/*
* Daniel Ty
* 3/19/2019
* TCSS 143 A
* Project 4
*/
import java.util.*;

public class DistanceOneMap {
	private Map<String, HashSet<String>> distanceMap;
	private HashSet<String> exploredWords = new HashSet<String>(); // Helper data structure; HashSet for speed since
																   // order does not matter

	public DistanceOneMap() {
		distanceMap = new HashMap<String, HashSet<String>>(); // HashMap for speed since order does not matter
	}

	public void createMap(HashSet<String> inputSet) {
		// Iterator for keys
		Iterator<String> keys = inputSet.iterator();
		// While loop for each key
		while (keys.hasNext()) {
			String key = keys.next();
			HashSet<String> keySet = new HashSet<String>(); // HashSet for speed since order does not matter
			distanceMap.put(key, keySet);
			// Iterator for values
			HashSet<String> valueSet = new HashSet<String>(); // HashSet for speed since order does not matter
			valueSet.addAll(inputSet);
			Iterator<String> values = valueSet.iterator();
			// Nested while loop for each possible value of a key
			while (values.hasNext()) {
				String value = values.next();
				// If possible value is equal to key in length and different by one letter, add
				// value to set at that key
				if (value.length() == key.length() && isDistanceOne(key, value)) {
					distanceMap.get(key).add(value);
				}
			}
		}
	}

	public boolean containsWord(String word) {
		return distanceMap.containsKey(word);
	}

	public String toString() {
		return distanceMap.toString();
	}

	private boolean isDistanceOne(String startingWord, String endingWord) {
		int distance = 0;
		for (int i = 0; i < startingWord.length(); i++) {
			if (startingWord.charAt(i) != endingWord.charAt(i)) {
				distance++;
			}
		}
		return distance == 1;
	}

	// This method is not entirely correct. I seem to get a distance larger than
	// expected.
	public int distance(String startingWord, String endingWord) {
		// Queue for stacks of strings
		Queue<Stack<String>> stackQueue = new LinkedList<Stack<String>>(); // LinkedList because it functions like a queue;
																		   // first in, first out 
		// For each word one letter different from starting word, create a stack with
		// this word and
		// starting word, add stack to queue
		for (String word : distanceMap.get(startingWord)) {
			Stack<String> stack = new Stack<String>();
			stack.push(startingWord);
			stack.push(word);
			stackQueue.add(stack);
		}
		// Add starting word to set
		exploredWords.add(startingWord);

		for (int i = stackQueue.size(); i > 0; i = stackQueue.size()) {
			// Look at top of each stack
			Stack<String> stack = stackQueue.poll();
			String processWord = stack.peek();
			// If equal to ending word, add stack values to set, return it's size minus 1
			// (represents distance)
			if (processWord.equals(endingWord)) {
				exploredWords.addAll(stack);
				return exploredWords.size() - 1;
				// If unequal, look at all its words that differ by one letter
			} else {
				for (String word : distanceMap.get(processWord)) {
					// If any of those words are not in our set, add their corresponding stack to
					// the queue
					if (!exploredWords.contains(word)) {
						Stack<String> newStack = new Stack<String>();
						newStack.addAll(stack);
						newStack.push(word);
						stackQueue.add(newStack);
					}
				}
			}
			exploredWords.add(processWord);
		}
		return -1;
	}

	public String path() {
		String s = "";
		if (exploredWords.size() == 0) {
			s = "0";
		} else {
			Iterator<String> element = exploredWords.iterator();
			s += element.next();
			while (element.hasNext()) {
				s += ", " + element.next();
			}
		}
		return s;
	}

}
