import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/** 
 * Represents a Reservation object that customers can make.
 * Contains the essential details of a reservation.
 * @author Beh Ming Jun
 * @version 10
 * @since 2021-11-13
 */

public class Reservation {

	/**
	 * The date and Arrival time of the Reservation.
	 */
	private Date dateAndArrivalTime;

	/**
	 * The number of pax per Reservation.
	 */
	private int numPax;

	/**
	 * The name of the person who booked the Reservation.
	 */
	private String name;

	/** 
	 * The contact of the perso who booked the Reservation.
	 */
	private int contact;

	/** 
	 * Boolean attribute to check if the Reservation has expired.
	 */
	private boolean isExpired;

	/**
	 * Date object to get the date and time that the Reservation expires.
	 */
	private Date expiryDateTime;

	/**
	 * Creates a new Reservation with the given contact
	 * date and arrival time, number of pax and name of 
	 * person who made the reservation.
	 * @param contact This Reservation's contact number (person who booked the Reservation).
	 * @param dateAndArrivalTime This Reservation's date and booking time.
	 * @param numPax This Reservation's number of pax.
	 * @param name This Reservation's name (person who booked the Reservation).
	 */
	public Reservation(int contact, String dateAndArrivalTime, int numPax, String name) {
		// TODO - implement Reservations.Reservations
		this.contact = contact;
		this.dateAndArrivalTime = convertToDate(dateAndArrivalTime);
		this.numPax = numPax;
		this.name = name;
		this.expiryDateTime = convertExpiryDateTime(this.dateAndArrivalTime);
		//throw new UnsupportedOperationException();
	}

	/**
	 * Get the current date and time and check if the Reservation has expired.
	 * Reservation is considered expired if it has been more than 15
	 * minutes past the Reservation date and time.
	 * @return true if Reservation has expired.
	 */
	public boolean getIsExpired() {
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
	    Date curDateTime = new Date(); 
	    //curDateTime = formatter.format(curDateTime);
	    long minutesDiff = getTimeDiff(this.dateAndArrivalTime, curDateTime, TimeUnit.MINUTES);
	    if (minutesDiff > 15) {
	    	this.isExpired = true;
	    }
	    
	    else {
	    	this.isExpired = false;
	    }
	    
		return this.isExpired;
	}

	/**
	 * Get the time difference between 2 Date objects in minutes
	 * @param date1 First date to be compared.
	 * @param date2 Second date to be compared.
	 * @param timeUnit The timeunit that will be returned Eg. MINUTES.
	 * @return the time difference in minutes.
	 */
	public long getTimeDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Converts a String in the format "dd-MM-yyyy HH:mm" into a Date object.
	 * @param DateTime String to be converted into Date object.
	 * @return the date object after conversion.
	 */
	public Date convertToDate(String DateTime) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		
		try {
			date = sdf.parse(DateTime);
		}catch(Exception e){
			System.out.println(e);
		}

		return date;
	}
	
	/**
	 * Adds 15minutes to a Date object to get the expiry time of a Reservation.
	 * @param DateTime
	 * @return
	 */
	public Date convertExpiryDateTime(Date DateTime) {
		long timeInSecs = DateTime.getTime();
		Date Add15Mins = new Date (timeInSecs + (15*60*1000));
		return Add15Mins;
	}
	
	public void printReservation() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm"); 
		
		System.out.println("Reservation Details for " + name + ":\r\n"
				+ "Contact Number: " + contact + "\r\n"
				+ "Date and Arrival Time: " + formatter.format(dateAndArrivalTime) + "\r\n"
				+ "Number of Pax: " + numPax + "\r\n");
	}

	public Date getExpiryDateTime() {
		return this.expiryDateTime;
	}
	
	public int getContact() {
		return this.contact;
	}
	public boolean checkContact(int contactNumber){
		boolean contactMatch=false;
		if(this.contact==contactNumber){
			contactMatch=true;
		}
		return contactMatch;
	}
}