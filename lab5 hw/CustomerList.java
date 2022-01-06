/*
* Daniel Ty
* 2/14/2019
* TCSS 143 A
* Lab Assignment 5: CustomerList
*/

import java.util.*;

public class CustomerList {
   private int size;
   private BankCustomerType[] bankCustomers;

   public CustomerList() {
      bankCustomers = new BankCustomerType[100];
      size = 0;
   }

   public CustomerList(CustomerList other) {
      size = other.size;
      bankCustomers = new BankCustomerType[other.bankCustomers.length];
      for (int i = 0; i < size; i++)
         //bankCustomers[i] = other.bankCustomers[i];
         bankCustomers[i] = new BankCustomerType(other.bankCustomers[i]);  
   }
   
   public void add(BankCustomerType element) {
      // if the array is full, create a new array, twice the size of the old one
      if (size == bankCustomers.length) {
         BankCustomerType[] newArray = new BankCustomerType[size * 2];
         for (int i = 0; i < size; i++)
            newArray[i] = bankCustomers[i];
         bankCustomers = newArray;
      }
      bankCustomers[size] = element;
      size++;
   }
   
   public void add(int index, BankCustomerType newElement) {
      if (index >= 0 && index < size) {   
         // resize if not enough room in array
         if (size >= bankCustomers.length) {
            BankCustomerType[] newArray = new BankCustomerType[size * 2];
            for (int i = 0; i < bankCustomers.length; i++)
               newArray[i] = bankCustomers[i];
            bankCustomers = newArray;
         }
         // shift the existing elements
         for (int i = size; i > index; i--)
            bankCustomers[i] = bankCustomers[i - 1];
            
         // insert
         bankCustomers[index] = newElement;
         size++;
      }
   }      
   

   public int length() {
      return size;
   }
   

   public BankCustomerType get(int index) {
      return bankCustomers[index];
   }
   
   public String toString() {
      String result = "[";
      if (size > 0)
         result += bankCustomers[0];
      for (int i = 1; i < size; i++)
         result += ", " + bankCustomers[i];
      result += "]";
      return result;
   }
   
   public int numOfAccounts() {
      int accountCount = 0;
      for (BankCustomerType element : bankCustomers) {
         accountCount += element.numOfAccounts();
      }
      return accountCount;
   }
   
   public double howMuchMoney() {
      double sum = 0;
      for (BankCustomerType element : bankCustomers) {
         sum += element.calculateTotal();
      }
     return sum;
   }

}    