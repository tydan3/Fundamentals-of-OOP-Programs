public class EnhancedDateType extends BasicDateType {
   private String monthName;
   
   public EnhancedDateType() {
      monthName = "January";
   }
   
   public boolean equals(Object other) {
      if (other instanceof EnhancedDateType) {
         EnhancedDateType a = (EnhancedDateType) other;
         if (super.getDay() == a.getDay()) {
            if (super.getMonth() == a.getMonth()) {
               if (super.getYear() == a.getYear()) {
                  if (monthName.equals(a.monthName)) {
                     return true;
                  }
               }
            }
         }
      }
      return false;
   }
   
   public String getMonthName() {
      return monthName;
   }
   
   public void setDate(int day, int month, int year, String monthName) {
      super.setDate(day, month, year);
      this.monthName = monthName;
   }
   
   public String toString() {
      return super.toString() + " " + monthName;
   } 
}
