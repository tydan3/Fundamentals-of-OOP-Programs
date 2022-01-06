// Daniel Ty
// TCSS 143A
// Project 1
// Due 1/31/2019

import java.io.*;
import java.util.*;

/** This program learns how to recognize diabetes from a given data set
* and use the learned recognition to predict diabetes in a new data set.
* @author Daniel Ty
* @version 1/30/2019
*/
public class DiagnoseDiabetes {

   /** Driver method of the class DiagnoseDiabetes processing.
   * @param args is used for command line input
   * @throws FileNotFoundException for file not found
   */
   public static void main(String[] args) throws FileNotFoundException {
      //prompt user for training file name
      Scanner console = new Scanner(System.in);
      System.out.print("Enter the name of the training set file: ");
      String trainingFile = console.next();
      //creates array of end values of each line in training file
      int[] lineEndVal = lineEndVal(trainingFile);
      //counts amount of lines for each patient type, determined by last value of each line
      int illLines = 0;
      int healthyLines = 0;
      for (int i = 0; i < lineEndVal.length; i++) {
         if (lineEndVal[i] >= 0.65) {
            illLines++;
         } else {
            healthyLines++;
         }
      }
      //use counted lines to intialize arrays for ill or healthy patients
      double[][] ill = new double[illLines][6];
      double[][] healthy = new double[healthyLines][6];
      fill(ill, healthy, lineEndVal, trainingFile);
      //find average of each attribute in ill or healthy arrays
      double[] illAvg = average(ill);
      double[] healthyAvg = average(healthy);
      //find midpoint (i.e., seperation value) of attribute between ill and healthy 
      double[] sepValues = sepValues(illAvg, healthyAvg);
      //round values in average and seperation arrays and print
      round(illAvg);
      round(healthyAvg);
      round(sepValues);
      print(illAvg, healthyAvg, sepValues);
      //compare seperation values to new patient data and create a results csv
      System.out.print("Enter the name of file containing patient data: ");
      diagnose(console.next(), sepValues);
   }

   /** Creates an array of the last values of each line from the training file.
   * @param fileName is the name of the text file for training
   * @throws FileNotFoundException exception for file not found
   */
   public static int[] lineEndVal(String fileName) throws FileNotFoundException {
      Scanner input = new Scanner(new File(fileName));
      Scanner lines = new Scanner(new File(fileName));
      //count number of lines
      int lineCount = 0;
      while (lines.hasNextLine()) {
         lines.nextLine();
         lineCount++;
      }
      //record end value of each line
      int[] lineEndVal = new int[lineCount];
      for (int i = 0; i < lineCount; i++) {
         for (int j = 0; j < 6; j++) { 
            input.next();
         }
         lineEndVal[i] = input.nextInt();
      }
      return lineEndVal;
   }
   
   /** Fills the empty ill and healthy arrays with their repective values from the training file.
   * @param ill represents ill patients and their data
   * @param healthy represents healthy patients and their data
   * @param lineEndVal contains the last value of each line from the training file
   * @param fileName is the name of the text file for training
   * @throws FileNotFoundException exception for file not found
   */
   public static void fill (double[][] ill, double[][] healthy, int[] lineEndVal, 
   String fileName) throws FileNotFoundException {
      Scanner input = new Scanner(new File(fileName));
      int healthyCount = 0;
      int illCount = 0;
      for (int i = 0; i < lineEndVal.length; i++) {        
         if (lineEndVal[i] < 0.65) { //healthy patients
            Scanner healthyPatient = new Scanner(input.nextLine()); //healthy lines
            for (int k = 0; k < 6; k++) {
               if (healthyPatient.hasNextDouble()) {
                  healthy[healthyCount][k] = healthyPatient.nextDouble(); //fill attributes  
               } else { // for the "?"
                  healthy[healthyCount][k] = 0;
                  healthyPatient.next();
               }
            }
            healthyCount++;
         } else { //ill patients
            Scanner illPatient = new Scanner(input.nextLine()); //ill lines
            for (int k = 0; k < 6; k++) {
               if (illPatient.hasNextDouble()) {
                  ill[illCount][k] = illPatient.nextDouble(); //fill attributes
               } else { // for the "?"
                  ill[illCount][k] = 0;
                  illPatient.next();
               }
            }
            illCount++;
         }         
      }
   }
   
   /** Creates an array of the average value for each attribute in the given array.
   * @param patientType is the array of the type of patient(ill or healthy)
   * @return an array of the average value for each attribute
   */
   public static double[] average(double[][] patientType) {
      double[] average = new double[6];
      for (int i = 0; i < 6; i++) { //attributes
         double sum = 0;
         for (int j = 0; j < patientType.length; j++) { //# of patients
            sum += patientType[j][i];
         }
         average[i] = sum / patientType.length;
      }
      return average;
   }
   
   /** Creates an array of the midpoint between ill and healthy for each attribute.
   * @param illAvg is the average value for each attribute of an ill patient
   * @param healthyAvg is the average value for each attribute of a healthy patient
   * @return midpoint between ill and healthy of each attribute
   */
   public static double[] sepValues(double[] illAvg, double[] healthyAvg) {
      double[] sepValues = new double[6];
      for (int i = 0; i < 6; i++) {
         //determine which is the smaller value between ill and healthy attributes
         double bigger = Math.max(illAvg[i], healthyAvg[i]);
         double smaller = Math.min(illAvg[i], healthyAvg[i]);
         sepValues[i] = smaller + ((bigger - smaller) / 2);
      }
      return sepValues;
   }
   
   /** Rounds values in an array to the nearest hundredth place.
   * @param array is the array whose values are to be rounded
   */
   public static void round(double[] array) {
      for (int i = 0; i < array.length; i++) {
         array[i] = Math.round(array[i] * 100d) / 100d;
      }
   }
   
   /** Prints averages of healthy patients, ill patients, and class separation values.
   * @param illAvg is the average value for each attribute of an ill patient
   * @param healthyAvg is the average value for each attribute of a healthy patient
   * @param sepValues is the midpoint between ill and healthy for each attribute
   */   
   public static void print(double[] illAvg, double[] healthyAvg, double[] sepValues) {
      System.out.println("Healthy patients' averages: ");
      System.out.println(Arrays.toString(healthyAvg));
      System.out.println("Ill patients' averages: ");
      System.out.println(Arrays.toString(illAvg));
      System.out.println("Seperator values: ");
      System.out.println(Arrays.toString(sepValues));
   }
   
   /** Makes predictions for new patients that haven't been diagnosed yet and
   * outputs this data to results.csv.
   * @param diagnoseFile is the name of the csv file to make predictions of diagnoses on
   * @param sepValues is the midpoint between ill and healthy for each attribute
   * @throws FileNotFoundException exception for file not found
   */
   public static void diagnose(String diagnoseFile, double[] sepValues) throws 
   FileNotFoundException {
      Scanner input = new Scanner(new File(diagnoseFile));
      PrintStream output = new PrintStream(new File("results.csv"));
      output.println("id, diagnosis");
      int patientCount = 0;
      int codeOne = 0;
      int codeTwo = 0; 
      int codeThree = 0; 
      //parse new patients csv file
      String aline;
      while (input.hasNextLine()) {
         aline = input.nextLine();
         String[] tokens = aline.split(",");
         output.print(tokens[0] + ",");
         int attributes = 0;
         for (int i = 1; i < 7; i++) {
            //change String tokens to double
            double value = Double.parseDouble(tokens[i]);
            //compare values against seperation value
            if (value > sepValues[i - 1]) {
               attributes++;
            }
         }
         //number of attributes above 3 equals code number
         if (attributes > 3) {
            output.print(attributes - 3);
            if (attributes - 3 == 1) {
               codeOne++;
            } else if (attributes - 3 == 2) {
               codeTwo++;
            } else if (attributes == 6) {
               codeThree++;
            }
         }
         output.println();
         patientCount++;
      }
   System.out.println("Number of patients:\t\t\t" + patientCount);
   System.out.println("Diagnosis Code 1:\t\t\t\t" + codeOne);
   System.out.println("Diagnosis Code 2:\t\t\t\t" + codeTwo);  
   System.out.println("Diagnosis Code 3:\t\t\t\t" + codeThree);
   System.out.println("Check results.csv for specific patients and their codes"); 
   }
   
}