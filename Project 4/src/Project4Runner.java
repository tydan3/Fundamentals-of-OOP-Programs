
/*
* Daniel Ty
* 3/19/2019
* TCSS 143 A
* Project 4
*/
import java.util.*;
import java.io.*;

public class Project4Runner {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("dictionary.txt"));
		WordMap dictionary = new WordMap();
		dictionary.readInput(input);
		Scanner console = new Scanner(System.in);
		System.out.println("This program uses a dictionary to compute distances between pairs of words.");
		String firstWord;
		String secondWord;
		// Loop if word input lengths are not equal
		do {
			// Loop for first word input if not in dictionary
			do {
				System.out.println("Enter a word:");
				firstWord = console.next().toLowerCase();
				if (!dictionary.containsWord(firstWord)) {
					System.out.println("This word is not in the dictionary. Try again.");
				}
			} while (!dictionary.containsWord(firstWord));
			// Loop for second word input if not in dictionary
			do {
				System.out.println("Enter a second word:");
				secondWord = console.next().toLowerCase();
				if (!dictionary.containsWord(secondWord)) {
					System.out.println("This word is not in the dictionary. Try again.");
				}
			} while (!dictionary.containsWord(secondWord));
			if (firstWord.length() != secondWord.length()) {
				System.out.println("The distance cannot be measured due to uneven word lengths. Try again");
			}
		} while (firstWord.length() != secondWord.length());
		// Create DistanceOneMap based on length of either word inputed
		DistanceOneMap dMap = new DistanceOneMap();
		dMap.createMap(dictionary.getSet(firstWord.length()));
		// Find distance between the two words inputed
		int distance = dMap.distance(firstWord, secondWord);
		// Print distance if greater than or equal to 0, else print an explanation
		if (distance >= 0) {
			System.out.println("The distance between the two words is: " + distance);
			System.out.println(dMap.path());
		} else {
			System.out.println("Could not find the distance based on the provided dictionary");
		}
		PrintStream output = new PrintStream(new File("myoutput.txt"));
		// Output may only print WordMap and not DistanceOneMap if it's too long.
		// To see DistanceOneMap, switch the order of the print statements to print
		// DistanceOneMap before WordMap.
		output.println("WordMap: " + dictionary);
		output.println("DistanceOneMap: " + dMap);
	}

}
