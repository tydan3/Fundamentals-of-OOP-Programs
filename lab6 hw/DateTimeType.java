public class DateTimeType extends EnhancedDateType {
   private int hours;
   private int minutes;
   
   public DateTimeType() {
      hours = 0;
      minutes = 0;
   }
   
   public boolean equals(Object other) {
      if (other instanceof DateTimeType) {
         DateTimeType a = (DateTimeType) other;
         if (super.getDay() == a.getDay()) {
            if (super.getMonth() == a.getMonth()) {
               if (super.getYear() == a.getYear()) {
                  if (super.getMonthName().equals(a.getMonthName())) {
                     if (hours == a.hours && minutes == a.minutes) {
                        return true;
                     }
                  }
               }
            }
         }
      }
      return false;
   }   
   
   public int getHours() {
      return hours;
   }
   
   public int getMinutes() {
      return minutes;
   }
   
   public void setDate(int day, int month, int year, String monthName,
   int hours, int minutes) {
      super.setDate(day, month, year, monthName);
      this.hours = hours;
      this.minutes = minutes;
   }
   
   public String toString() {
      return super.toString() + " " + hours + minutes / 60 + ": " + minutes % 60;
   }
}