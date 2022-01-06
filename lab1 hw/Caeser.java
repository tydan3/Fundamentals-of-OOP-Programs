// Daniel Ty
// TCSS 143 A
// Lab 01
// Due 1/15/2019

import java.util.*;
public class Caeser {

   public static final String alphabet = " abcdefghijklmnopqrstuvwxyz";
   public static final String key = "defghijklmnopqrstuvwxyzabc ";

   public static void main(String[] args) {
      // initially test with this phrase but once working, change to interactive input
      // change to lowercase
      // call encrypt method and collect the result
      // print to the screen  
      Scanner input = new Scanner(System.in);
      String plaintext = input.nextLine();
      plaintext = plaintext.toLowerCase();
      System.out.println(encrypt(plaintext));
   }
   
   public static String encrypt(String plain) {
      // iterate over the string
      // for each char from plaintext, find its index in alphabet
      // use the same index from alphabet and apply it to the key
      // append the key letter at that location to your cipher   
      String cipher = "";
      for (int i = 0; i < plain.length(); i++) {
         cipher += key.charAt(alphabet.indexOf(plain.charAt(i)));
      }           
      return cipher;
   }
   
}