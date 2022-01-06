public class test {
   public static void main(String[] args) {
      BasicDateType a = new BasicDateType();
      a.setDate(2, 19, 2019);
      System.out.println(a);
      BasicDateType b = new BasicDateType();
      b.setDate(2, 19, 2019);
      System.out.println(b);
      System.out.println(a.equals(b));

   }
}