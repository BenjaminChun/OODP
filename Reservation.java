import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Date dateAndArrivalTime;
	private int numPax;
	private String name;
	private int contact;
	private boolean isExpired;
	private Date expiryDateTime;

	/**
	 * 
	 * @param contact
	 * @param date
	 * @param arrivalTime
	 * @param numPax
	 * @param name
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
	
	public long getTimeDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
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