import java.util.*;
public class BankCustomerDriver {
   public static void main(String[] args) {
      double[] andyAccounts = new double[] {20.4, 30.3, 22.2};
      BankCustomerType andy = new BankCustomerType("andy", andyAccounts);
      double[] bettyAccounts = new double[] {400.9, 303.5, -200.5};
      BankCustomerType betty = new BankCustomerType("betty", bettyAccounts);
      //BankCustomerType betty2 = new BankCustomerType(betty);
      System.out.println(andy);
      System.out.println();
      System.out.println(betty);
      /*System.out.println(betty.calculateTotal());
      System.out.println(betty.numberOfLoans());
      System.out.println();
      System.out.println(betty2);
      
      CustomerList list = new CustomerList();
      list.add(andy);
      list.add(betty);
      list.add(betty2);
      System.out.println();
      System.out.println(list);
      CustomerList list2 = new CustomerList(list);
      System.out.println();
      System.out.println(list2);*/
   }
}