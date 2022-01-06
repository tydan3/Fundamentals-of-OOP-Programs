/*
 * TCCS 143 Spring 2018
 */

import java.util.Arrays;
import java.util.Calendar;

/**
 * Represents a written item in the library.
 * @author Monika
 * @version Winter 2019
 * class invariant year published <= current year, pages > 0
 */
public class WrittenItem extends AbstractItem {
 
    /**
     * represents number of pages.
     */
    private int myPages;

    /**
     * Constructs a WrittenItem object with the following properties:
     *                  if pages < 1, pages = 1;
     * 						if year > current year, year = current year
     * @param aCatalogID is a string denoting valid library id number
     * @param aTitle is a string denoting valid title
     * @param aYearPublished is the year the item was published, year <= current year
     * @param aPeople is a list of authors/ artists
     * @param aPublisher is a string denoting a publisher
     * @param aPages is an integer > 0 denoting the number of pages
     */
    public WrittenItem(String aCatalogID, String aTitle, int aYearPublished, 
    String aPublisher, String[] authors, int aPages) {
      super(aCatalogID, aTitle, aYearPublished, aPublisher, authors);
      myPages = aPages;
        if (myPages < 1) {
            myPages = 1;
        }
    }

    /**
     * Returns number of pages.
     * @return number of pages of WrittenItem object
     */
    public int getMyPages() {
        return myPages;
    }

    /**
     * Assigns number of pages.
     * @param aPages is an integer > 0 denoting the number of pages
     */
    public void setMyPages(int aPages) {
    	myPages = aPages;
        if (myPages < 1) {
            myPages = 1;
        }
    }
    
    /**
     * Returns a string representing written item contents.
     * @return WrittenItem fields as a string
     */
	public String toString() {
		return "WrittenItem [CatalogID=" + super.toString() + ", Pages=" + myPages + "]";
	}     
    
}