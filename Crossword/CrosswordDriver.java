import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class CrosswordDriver {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner infile, console = new Scanner(System.in);
		int numOfFiles, rows;
		PrintStream outfile;
		String filename;
		CrosswordPuzzle crossPuzzle;
		
		System.out.println("How many files would you like to process? ");
		numOfFiles = console.nextInt();
		
		for (int i = 0; i < numOfFiles; i++) {
			System.out.println("Enter the name of the file:  ");
			filename = console.next();
			infile = new Scanner(new File(filename)); 
			outfile = new PrintStream(new File("out" + filename));
		
			rows = infile.nextInt();
			crossPuzzle = new CrosswordPuzzle(rows);
			
			crossPuzzle.readFile(infile);
         System.out.println("Original puzzle: ");
			crossPuzzle.displayBoard(System.out);
			crossPuzzle.displayBoard(outfile);
			crossPuzzle.extractWords();
         System.out.println("Extracted words: ");
			crossPuzzle.displayWords();
         System.out.println("Rotated puzzle: ");
			crossPuzzle.rotate90();
			crossPuzzle.displayBoard(System.out);
			crossPuzzle.displayBoard(outfile);
			crossPuzzle.displayStats();
			infile.close();
			outfile.close();
		}
	}

}
