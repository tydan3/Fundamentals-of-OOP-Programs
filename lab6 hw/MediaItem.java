/*
 * TCCS 143 lab
 */


import java.util.Arrays;
import java.util.Calendar;

/**
 * Represents media item in a library. 
 * @author Monika
 * @version Winter 2019
 * class invariant runtime >= 0; tracks number >= 1; year <= current year
 */
public class MediaItem extends AbstractItem {
		 
    /**
     * run time of the media item.
     */
    private double myRuntime;
    
    /**
     * number of tracks.
     */
    private int myTracksNumber;   

    /**
     * Constructs media item object with the following properties:
     *  if aRuntime <= 0, runtime = 0; if number of tracks < 1,
     *          number of tracks = 1; if year > current year, year = current year .
     * @param aCatalogID is a string denoting valid library id number
     * @param aTitle is a string denoting valid title
     * @param aYearPublished is the year the item was published, year <= current year
     * @param aPublisher is a string denoting a publisher
     * @param authors is a list of authors/ artists
     * @param aRuntime is the running time of media item, > 0
     * @param aTracksNumber is the number of tracks of media item, >= 1     
     */
    public MediaItem(String aCatalogID, String aTitle, int aYearPublished, 
    String aPublisher, String[] authors, double aRuntime, int aTracksNumber)  {
        super(aCatalogID, aTitle, aYearPublished, aPublisher, authors);
        myRuntime = aRuntime;
        myTracksNumber = aTracksNumber;
        if(myRuntime < 0)
            myRuntime = 0;
        if (myTracksNumber < 1) {
            myTracksNumber = 1;
        }        		
    }
   
      
    /**
     * Returns runnning time of an item.
     * @returns runnning time of an item
     */
    public double getMyRuntime() {
        return myRuntime;
    }

    /**
     * Assigns running time of an item.
     * @param aRuntime >= 0
     */
    public void setMyRuntime(double aRuntime) {
        myRuntime = aRuntime;
        if(myRuntime < 0)
        	myRuntime = 0;
    }

    /**
     * Returns the number of tracks.
     * @return number of tracks
     */
    public int getMyTracksNumber() {
        return myTracksNumber;
    }

    /**
     * Assigns number of tracks to a media item.
     * @param aTracksNumber is >= 1
     */
    public void setMyTracksNumber(int aTracksNumber) {
        myTracksNumber = aTracksNumber;
        if (myTracksNumber < 1) {
            myTracksNumber = 1;
        }
    }

    /**
     * Returns a string representing media item contents.
     * @return MediaItem fields as a string
     */
	public String toString() {
		return "MediaItem [CatalogID=" + super.toString() + ", myRuntime="
				+ myRuntime + ", myTracksNumber=" + myTracksNumber + "]";
	}
       
}