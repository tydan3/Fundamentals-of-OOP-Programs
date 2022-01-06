/*
* Daniel Ty
* 2/14/2019
* TCSS 143 A
* Lab Assignment 5: BankCustomerImmutable
*/

import java.util.*;

public final class BankCustomerImmutable {
   private String name;
   private Integer id;
   private double[] accounts;
   static ArrayList<Integer> customerIds = new ArrayList<Integer>();
   
   public BankCustomerImmutable(String name, double[] accounts) {
      this.name = name;
      double[] deepAccounts = new double[accounts.length];
      for (int i = 0; i < accounts.length;  i++) {
         deepAccounts[i] = accounts[i];
      }
      this.accounts = deepAccounts;
      Random rand = new Random();
      id = rand.nextInt(1000);
      for (int i = 0; i < customerIds.size(); i++) {
         if (id == customerIds.get(i)) {
            id = rand.nextInt(1000);
            i = 0;
         }
      }
      customerIds.add(id);
   }
   
   public BankCustomerImmutable(BankCustomerImmutable other) {
      name = other.name;
      id = other.id;
      accounts = new double[other.accounts.length];
      for (int i = 0; i < accounts.length;  i++) {
         accounts[i] = other.accounts[i];
      }
   }
   
   public String getName() {
      BankCustomerImmutable n = new BankCustomerImmutable(this);
      return n.name;
   }
   
   public Integer getId() {
      BankCustomerImmutable n = new BankCustomerImmutable(this);
      return n.id;
   }
   
   public double[] getAccounts() {
      BankCustomerImmutable n = new BankCustomerImmutable(this);
      return n.accounts;
   }
   
   public ArrayList<Integer> getCustomerIds() {
      BankCustomerImmutable n = new BankCustomerImmutable(this);
      return n.customerIds;
   }
   
   public BankCustomerImmutable setName(String name) {
      BankCustomerImmutable n = new BankCustomerImmutable(this);
      n.name = name;
      return n;
   }
   
   public String toString() {
      String s = "name: " + name + "\nid: " + id + "\naccounts: " + Arrays.toString(accounts);
      return s;
   }
   
   public int numOfAccounts() {
      return accounts.length;
   }
   
   public BankCustomerImmutable setAccountValues(int index, double balance) {   
      BankCustomerImmutable n = new BankCustomerImmutable(this);
      if (index > 0 && index < n.accounts.length) {
         n.accounts[index] = balance;
      }
      return n;
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