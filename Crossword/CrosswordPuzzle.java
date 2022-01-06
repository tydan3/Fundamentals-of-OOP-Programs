/*
* Daniel Ty
* 2/14/2019
* TCSS 143 A
* Project 2: CrosswordPuzzle
*/

import java.util.*;
import java.io.*;

/** 
 * Represents a crossword puzzle and calculates various statistics.
 * @author Daniel Ty
 * @version Winter 2019
 */
public class CrosswordPuzzle {
   private char[][] crossGrid;
   private String[] words;
   
   /**
    * Creates a 1d array of strings of default size 10 and a 2d array 
    * of characters with x number of rows.
    * @param x number of rows in crossword puzzle
    */
   public CrosswordPuzzle(int x) {
      words = new String[10];
      crossGrid = new char[x][];
   }
   
   /**
    * Reads the crossword puzzle lines from a file and populates a  
    * 2d array of characters.
    * @param inputFile name of the file to be read
    * @throws FileNotFoundException for file not found
    */
   public void readFile(Scanner inputFile) throws FileNotFoundException {
      int i = 0; // index of outer array (rows)
      inputFile.nextLine();
      while (inputFile.hasNextLine()) { // parse file lines
         String s = inputFile.nextLine();
         crossGrid[i] = new char[s.length()]; // set inner array (chars in row) to length of line
         for (int j = 0; j < s.length(); j++) {
            crossGrid[i][j] = s.charAt(j); // extracts chars from line to inner array
         }
         i++; // iterate outer array index
      }
   }
   
   /**
    * Extracts all horizontal and vertical words from the 2d array crossGrid to the
    * 1d array of Strings called words. 
    */  
   public void extractWords() {
      String[] h = extractHorizontalWords();
      String[] v = extractVerticalWords();
      words = new String[h.length + v.length];
      for (int i = 0; i < h.length; i++) {
         words[i] = h[i];
      }
      for (int i = 0; i < v.length; i++) {
         words[i + h.length] = v[i]; // add vertical words after last index of horizontal words
      }   
   }
   
   /**
    * Extracts words from crossGrid rows.
    * @return String array of words from crossGrid rows
    */
   private String[] extractHorizontalWords() {
      String[] words;
      // Count number of vertical words to find size of array
      int wordCount = 0;
      for (int i = 0; i < crossGrid.length; i++) {
         String s = ""; // s represents potential word
         for (int j = 0; j < crossGrid[i].length; j++) {
            if (crossGrid[i][j] != '#') { // add array element to s if it is not '#'
               s += crossGrid[i][j];
            } else {
               if (s.length() > 1) { // check if s is a word after reaching '#'
                  wordCount++;
               }
               s = ""; // reset s to start a new word 
            }
         }
         if (s.length() > 1) { // check if s is a word after reaching end of row
            wordCount++;
         }
      }
      
      // use wordCount to set size of array
      words = new String[wordCount];
      int index = 0;
      // use same process for counting words to put them into the array instead
      for (int i = 0; i < crossGrid.length; i++) {
         String s = "";
         for (int j = 0; j < crossGrid[i].length; j++) {
            if (crossGrid[i][j] != '#') { // add array element to s if it is not '#'
               s += crossGrid[i][j];
            } else {
               if (s.length() > 1) { // check if s is a word after reaching '#'
                  words[index] = s; // add word to array
                  index++;
               }
               s = ""; // reset s to start a new word 
            }
         }
         if (s.length() > 1) { // check if s is a word after reaching end of row
            words[index] = s; // add word to array
            index++;
         }
      }
      return words;
   }
   
   /**
    * Extracts words from crossGrid columns.
    * @return String array of words from crossGrid columns
    */
   private String[] extractVerticalWords() {
      String[] words;
      // Count number of horizontal words to find size of array
      int wordCount = 0;
      for (int i = 0; i < crossGrid[0].length; i++) {
         String s = ""; // s represents potential word
         for (int j = 0; j < crossGrid.length; j++) {
            if (crossGrid[j][i] != '#') { // add array element to s if it is not '#'
               s += crossGrid[j][i];
            } else {
               if (s.length() > 1) { // check if s is a word after reaching '#'
                  wordCount++;
               }
               s = ""; // reset s to start a new word 
            }
         }
         if (s.length() > 1) { // check if s is a word after reaching end of row
            wordCount++;
         }
      }
      
      // use wordCount to set size of array      
      words = new String[wordCount];
      int index = 0;
      // use same process for counting words to put them into the array instead
      for (int i = 0; i < crossGrid[0].length; i++) {
         String s = "";
         for (int j = 0; j < crossGrid.length; j++) {
            if (crossGrid[j][i] != '#') { // add array element to s if it is not '#'
               s += crossGrid[j][i];
            } else {
               if (s.length() > 1) { // check if s is a word after reaching '#'
                  words[index] = s; // add word to array
                  index++;
               }
               s = ""; // reset s to start a new word 
            }
         }
         if (s.length() > 1) { // check if s is a word after reaching end of row
            words[index] = s; // add word to array
            index++;
         }
      }
      return words;
   }
   
   /**
    * Writes all words to console.
    */
   public void displayWords() {
      for (String element : words) {
         System.out.println(element);
      }
   }
   
   /**
    * Writes the 2d array of characters to the outputStream; a blank
    * character follows each original character from the 2d array.  
    * @param outputStream name of created file to be printed to
    * @throws FileNotFoundException for file not found
    */   
   public void displayBoard(PrintStream outputStream) throws FileNotFoundException {
      for (int i = 0; i < crossGrid.length; i++) { // loop outer array
         for (int j = 0; j < crossGrid[i].length; j++) { // loop inner array
            outputStream.print(crossGrid[i][j] + " ");
         }
         outputStream.println();
      }
   }

   /**
    * Rotates the board (crossGrid) 90 degrees.
    */
   public void rotate90() {
      char[][] original = crossGrid;
      crossGrid = new char[original[0].length][original.length];
      for (int i = 0; i < original[0].length; i++) {  // loop original inner array
         for (int j = 0; j < original.length; j++) { // loop original outer array
            crossGrid[i][j] = original[j][i];
         }
      }
   }
   
   /**
    * Displays crossword stats to console.
    */
   public void displayStats() {
      System.out.println("number of words: " + words.length);
      System.out.println("number of black squares: " + countBlackSquares());
      
      double percent = (double)countBlackSquares() / (crossGrid.length * crossGrid[0].length) * 100;
      percent = round(percent);
      
      System.out.println("and their percentage of the grid: " + percent);
      
      int shortest = words[0].length();
      int longest = words[0].length();
      for (String element : words) {
         if (shortest > element.length()) {
            shortest = element.length();
         }
         if (longest < element.length()) {
            longest = element.length();
         }
      }
      
      System.out.println("shortest word: " + shortest);
      System.out.println("longest word: " + longest);
      System.out.println("average word length: " + averageWordLength());
   }
   
   /**
    * Counts and returns the number of black squares in the
    * crossword puzzle.
    * @return number of black squares in crossword
    */ 
   public int countBlackSquares() {
      int count = 0;
      for (char[] array : crossGrid) {
         for (char element : array) {
            if (element == '#') {
               count++;
            }
         }
      } 
      return count;
   }
   
   /**
    * Calculates and returns average word length.
    * @return average word length rounded to hundredth place.
    */
   public double averageWordLength() {
      int sum = 0;
      for (String element : words) {
         sum += element.length();
      }      
      double average = (double)sum / words.length;
      return average = round(average);   
   }
   
   /**
    * Rounds a given number to hundredth place.
    * @param number the number to be rounded
    * @return given number rounded to hundredth place
    */
   public double round(double number) {
      return Math.round(number * 100d) / 100d;
   }
      
}