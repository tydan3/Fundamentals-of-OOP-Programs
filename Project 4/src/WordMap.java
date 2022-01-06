
/*
* Daniel Ty
* 3/19/2019
* TCSS 143 A
* Project 4
*/
import java.util.*;

public class WordMap {
	private Map<Integer, HashSet<String>> wordMap;

	public WordMap() {
		wordMap = new HashMap<Integer, HashSet<String>>(); // HashMap and <HashSet> for speed since order does not
														   // matter
	}

	public void readInput(Scanner input) {
		while (input.hasNextLine()) {
			String word = input.nextLine();
			// if map does not have key of word length, put key (word length) and a set with
			// first word into map
			if (!wordMap.containsKey(word.length())) {
				HashSet<String> set = new HashSet<String>(); // HashSet for speed since order does not matter
				set.add(word);
				wordMap.put(word.length(), set);
			} else { // if map does have key of word length, add word to set at that key
				wordMap.get(word.length()).add(word);
			}
		}
	}

	public String toString() {
		return wordMap.toString();
	}

	public HashSet<String> getSet(int key) {
		HashSet<String> set = new HashSet<String>(); // HashSet for speed since order does not matter
		set.addAll(wordMap.get(key));
		return set;
	}

	public boolean containsWord(String word) {
		if (wordMap.containsKey(word.length())) {
			if (wordMap.get(word.length()).contains(word)) {
				return true;
			}
		}
		return false;
	}
}
