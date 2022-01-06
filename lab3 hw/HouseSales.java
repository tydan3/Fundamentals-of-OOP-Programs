// Daniel Ty
// TCSS 143A
// Lab 03 part 4
import java.util.*;
import java.io.*;

public class HouseSales {
   
   public static void main(String[] args) throws FileNotFoundException {
      String[] houseAddress = new String[20];
      int[] housePrice = new int[20];
      Scanner data = new Scanner(new File("myhouses.dat"));
      int lineCount = 1;
      int index = 0;
      int i = 0;
      while (data.hasNextLine()) {
         index = i / 2;
         if (lineCount % 2 == 1) {
            houseAddress[index] = data.nextLine();
         } else {
            Scanner priceLine = new Scanner(data.nextLine());
            priceLine.nextInt();
            housePrice[index] = priceLine.nextInt();
         }
         lineCount++;
         i++;
      }
      System.out.println();
      
      display(houseAddress,housePrice);
      System.out.println();
      
      System.out.println("Average price: " + averageSales(housePrice));
      System.out.println();
      
      highestPrice(houseAddress, housePrice);
      System.out.println();
      
      lowestPrice(houseAddress, housePrice);
   }
   
   public static void display(String[] address, int[] price) {
      System.out.println("Address\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPrice");
      for (int i = 0; i < price.length; i++) {
         System.out.println(address[i] + "\t\t\t\t\t\t\t\t\t$" + price[i]);
      }
   }
   
   public static double averageSales(int[] price) {
      double sum = 0;
      for (int element : price) {
         sum += element;
      }
      return sum / price.length;
   }
   
   public static void highestPrice(String[] address, int[] price) {
      int highest = price[0];
      int index = 0;
      for (int i = 0; i < price.length; i++) {
         if (highest < price[i]) {
            highest = price[i];
            index = i;
         }
      }
      System.out.print("Highest priced house(s): " + address[index]);
      for (int i = 0; i < price.length; i++) {
         if (highest == price[i] && i != index) {
            System.out.print("\n\t\t\t\t\t\t\t\t " + address[i]);
         }
      }
      System.out.println();
   }
   
   public static void lowestPrice(String[] address, int[] price) {
      int lowest = price[0];
      int index = 0;
      for (int i = 0; i < price.length; i++) {
         if (lowest > price[i]) {
            lowest = price[i];
            index = i;
         }
      }
      System.out.print("Lowest priced house(s): " + address[index]);
      for (int i = 0; i < price.length; i++) {
         if (lowest == price[i] && i != index) {
            System.out.print("\n\t\t\t\t\t\t\t\t" + address[i]);
         }
      }
      System.out.println();
   }
         
}   