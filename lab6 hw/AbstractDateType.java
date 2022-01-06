/**
 * Represents a date object consisting of day and month
 * @author Monika
 * @version Winter 2019
 */
public abstract class AbstractDateType {
	
	/**
	 * represents the day.
	 */
	private int day;
	
	/**
	 * represents the month.
	 */
	private int month;
	
	/**
	 * Parameterless constructor - creates an AbstractDateType object, representing January 1
	 */
	public AbstractDateType() {
		day = 1;
		month = 1;
	}
	
	/**
	 * Parameterized constructor - creates an AbstractDateType object.
	 * @param newDay >= 1 && <= 31
	 * @param newMonth >= 1 && <= 12 
	 */
	public AbstractDateType(int newDay, int newMonth) {
		day = newDay;
		month = newMonth;
	}   

	/**
	 * Copy constructor - creates an AbstractDateType as the deep copy of the other.
	 * @param other represents another AbstractDateType object to be copied, !null
	 */
	public AbstractDateType(AbstractDateType other) {
		this(other.day, other.month);	
	}
   
   public boolean equals(Object other) {
      if (other instanceof AbstractDateType) {
         AbstractDateType a = (AbstractDateType) other;
         if (day == a.day && month == a.month) {
            return true;
         }
      }
      return false;
   }
	
	/**
	 * Returns the day.
	 * @return the day of the month
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Returns the month.
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Resets the day and month to newDay and newMonth.
	 * @param newDay >= 1 && <= 31
	 * @param newMonth >= 1 && <= 12 
	 */
	public void setDate(int newDay, int newMonth) {
		day = newDay;
		month = newMonth;
	}

	/** 
	 * Overrides Java toString method.
	 * @return a String object representing AbstractDateType as dd/mm
    */
	public String toString() {
		String representation = "";
		if(day < 10)
			representation += "0";
		representation = representation + day + "/";
		if(month < 10)
			representation += "0";
		representation = representation + month;
		return representation;
	}
}
