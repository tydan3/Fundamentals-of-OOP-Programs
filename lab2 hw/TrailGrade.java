// Daniel Ty
// TCSS 143 A
// Lab 02
// Due 1/22/2019
import java.util.*;

public class TrailGrade {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String quit = "";
      while (!quit.equals("quit")) {
         System.out.print("RouteName: ");
         String trailName = input.nextLine();
         System.out.print("Length: ");
         double length = input.nextDouble();
         System.out.print("Enter trail rating (integer value 1-5): ");
         while(!input.hasNextInt()) {
            input.next();
            System.out.print("Enter trail rating (integer value 1-5): ");
         }
         int rating = input.nextInt();
         while (rating < 1 || rating > 5) {
            System.out.print("Enter trail rating (integer value 1-5): ");
            rating = input.nextInt();
         }
         System.out.print("Elevation Gain(as integer): ");
         while(!input.hasNextInt()) {
            input.next();
            System.out.print("Elevation Gain(as integer): ");
         }
         int elevationGain = input.nextInt();
         System.out.print("Highest Point(as integer): ");
         while(!input.hasNextInt()) {
            input.next();
            System.out.print("Highest Point(as integer): ");
         }
         int highestPoint = input.nextInt();
         double trailGrade = calculateGrade(elevationGain, length);
         String interestLevel = determineInterest(length, rating, elevationGain, highestPoint);
         display(trailName, interestLevel, trailGrade);
         System.out.println("Exit program? Type quit to exit. Type anything to repeat.");
         quit = input.next();
      } 
   }
   
   public static double calculateGrade(double elevationGain, double length) {
      return (double)Math.round((elevationGain / (length * 5280)) * 1000) / 10;
   }
   
   public static String determineInterest(double length, int rating, int elevationGain,
   int highestPoint) {
      if (length >= 3 && length <= 7 && rating >= 4 && elevationGain >= 0 &&
      elevationGain <= 800 && highestPoint >= 2000) {
         return "very interested";
      } else if (length < 8 && rating == 5 && elevationGain > 800) {
         return "interested";
      } else if (length >= 8 && elevationGain >= -200 && elevationGain <= 200 && highestPoint >=
      2500) {
         return "sort-of interested";
      } else {
         return "not interested";
      }
   }
   
   public static void display(String trailName, String interestLevel, double trailGrade) {
      System.out.println("TrailName      InterestLevel      Grade");
      System.out.println(trailName + "      " + interestLevel + "      " + trailGrade);
      
   }

}
     