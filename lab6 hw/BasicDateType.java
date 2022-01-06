public class BasicDateType extends AbstractDateType {
   private int year;
   
   public BasicDateType() {
      year = 0;
   }
   
   public boolean equals(Object other) {
      if (other instanceof BasicDateType) {
         BasicDateType a = (BasicDateType) other;
         if (getDay() == a.getDay()) {
            if (getMonth() == a.getMonth()) {
               if (year == a.year) {
                  return true;
               }
            }
         }
      }
      return false;
   
   }
   
   public int getYear() {
      return year;
   }
   
   public void setDate(int day, int month, int year) {
      super.setDate(day, month);
      this.year = year;  
   }
   
   public String toString() {
      return super.toString() + "/" + year;
   }
}