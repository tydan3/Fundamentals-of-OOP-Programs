import java.util.*;
import java.io.*;

public class CrosswordTest {
   public static void main(String[] args) throws FileNotFoundException {
      CrosswordPuzzle j = new CrosswordPuzzle(5);
      Scanner inputFile = new Scanner(new File("crosswords1.txt"));
      j.readInputFile(inputFile);
      j.displayBoard("outputFile");
      j.extractWords();
      j.displayWords();
      System.out.println(j.countBlackSquares());
      j.rotate90();
      j.displayBoard("90");
      System.out.println(j.countBlackSquares());
      j.displayStats();
   }
}