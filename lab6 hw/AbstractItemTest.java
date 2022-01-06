public class AbstractItemTest {
   
   public static void main(String[] args) {
      MediaItem a = new MediaItem("id", "a", 2009, "publisher", new String[]{"Tim", "Joe"},
      2.0, 6);
      WrittenItem b = new WrittenItem("id", "b", 2009, "publisher", new String[]{"Tim", "Joe"},
      3);
      System.out.println(a);
      System.out.println(b);
      System.out.println(a.equals(b)); 
     
   }
}