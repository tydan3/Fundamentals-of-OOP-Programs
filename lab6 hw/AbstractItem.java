import java.util.Arrays;
import java.util.Calendar;

public class AbstractItem {
   private String myCatalogID;
   private String[] myAuthors;
   private String myTitle;
   private int myYearPublished;
   private String myPublisher;
 
   
   public AbstractItem(String aCatalogID, String aTitle, int aYearPublished, 
   String aPublisher, String[] authors) {
      myCatalogID = aCatalogID;
    	myTitle = aTitle;
    	myYearPublished = aYearPublished;
      if (myYearPublished > aYearPublished) {
            myYearPublished = aYearPublished;
        }
      myPublisher = aPublisher;
      myAuthors = Arrays.copyOf(authors, authors.length);
   }
   
   public boolean equals(AbstractItem other) {
      return myCatalogID.equals(other.myCatalogID);
   }
   
   public String getMyPublisher() {
        return myPublisher;
   }
   
   /**
   * Assigns publisher to WrittenNumber object.
   * @param aPublisher is a string denoting a publisher
   */
   public void setMyPublisher(String aPublisher) {
        myPublisher = aPublisher;
   }
   
    /**
    * Returns item title.
    * @return item title
    */
    public String getMyTitle() {
        return myTitle;
    }
    
    /**
    * Assigns item title to an object.
    * @param aTitle is a valid string denoting item title
    */
    public void setMyTitle(String aTitle) {
        myTitle = aTitle;
    }
    
        /**
     * Returns the year the item was published.
     * @return the year the item was published
     */
    public int getMyYearPublished() {
        return myYearPublished;
    }
    
        /**
     * Assigns publication year to an item.
     * @param aYearPublished is an integer <= current year
     */
    public void setMyYearPublished(int aYearPublished) {
        final int year = Calendar.getInstance().get(Calendar.YEAR);
        if (myYearPublished >  year) {
            myYearPublished = year;
        }
    }
        /**
     * Returns catalog id.
     * @return catalog id
     */
    public String getMyCatalogID() {
        return myCatalogID;
    }
    
    /**
    * Assigns catalog id to an object.
    * @param aCatalogID is a valid string denoting library catalog id
    */
    public void setMyCatalogID(String aCatalogID) {
        myCatalogID = aCatalogID;
    }
    
    /**
    * Returns authors / artists list
    * @return copy of authors / artists list
    */
    public String[] getMyAuthors() {
        return Arrays.copyOf(myAuthors, myAuthors.length);
    }
    
    /**
    * Assigns author / artist list.
    * @param authors != null
    */
    public void setMyAuthors(String[] authors) {
        myAuthors = Arrays.copyOf(authors, authors.length);
    }

    public String toString() {
      return myCatalogID + ", Authors=" + Arrays.toString(myAuthors) + ", Title=" + myTitle
		+ ", YearPublished=" + myYearPublished + ", Publisher=" + myPublisher;
   }
}