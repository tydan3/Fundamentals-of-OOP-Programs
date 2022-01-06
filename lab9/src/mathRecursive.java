public class mathRecursive {
   
   public static int mathRec(int n) {
      int x = 0;
      if (n == 1) {
         x = 1;
      } else {
         x =  4 * mathRec(n-1);
      }
      System.out.println(x);
      if (x == 1) {
         System.out.println(x + ": is a base case");   
      } else {
         System.out.println(x + ": is a recursive case");
      }
      return x;
   }
      
   public static double realNum(double n, double app, double tol) {
      if ((Math.abs(Math.pow(app, 2) - n) <= tol)) {
          System.out.println(app);
    	  return app;
      } else {
         app = ((Math.pow(app, 2) + n) / (2 * app));
         realNum(n, app, tol);
      }
      return app;
   }
   
}