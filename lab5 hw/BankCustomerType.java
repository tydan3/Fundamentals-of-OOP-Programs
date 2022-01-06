/*
* Daniel Ty
* 2/14/2019
* TCSS 143 A
* Lab Assignment 5: BankCustomerType
*/

import java.util.*;

public class BankCustomerType {
   private String name;
   private Integer id;
   private double[] accounts;
   private static int[] customerIds = new int[0];
   
   public BankCustomerType(String name, double[] accounts) {
      this.name = name;
      this.accounts = accounts;
      Random rand = new Random();
      id = rand.nextInt(2);
      for (int i = 0; i < customerIds.length; i++) {
         if (id == customerIds[i]) {
            id = rand.nextInt(2);
            i = 0;
         }
      }
      customerIds = new int[customerIds.length + 1];
      customerIds[customerIds.length - 1] = id;
   }
   
   public BankCustomerType(BankCustomerType other) {
      name = other.name;
      id = other.id;
      accounts = new double[other.accounts.length];
      for (int i = 0; i < accounts.length;  i++) {
         accounts[i] = other.accounts[i];
      }
   }
   
   public String getName() {
      return name;
   }
   
   public Integer getId() {
      return id;
   }
   
   public double[] getAccounts() {
      return accounts;
   }
   
   public int[] getCustomerIds() {
      return customerIds;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public String toString() {
      String s = "name: " + name + "\nid: " + id + "\naccounts: " + Arrays.toString(accounts);
      return s;
   }
   
   public int numOfAccounts() {
      return accounts.length;
   }
   
   public void setAccountValues(int index, double balance) {   
      if (index > 0 && index < accounts.length) {
         accounts[index] = balance;
      }
   }
   
   public double calculateTotal() {
      double total = 0.0;
      for (double element : accounts) {
         total += element;
      }
      return total;
   }
   
   public int numberOfLoans() {
      int loans = 0;
      for (double element : accounts) {
         if (element < 0) {
            loans++;
         }
      }
      return loans;
   }
   
}